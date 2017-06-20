package com.poop.natalija;


import java.awt.*;
import java.util.*;
import java.util.List;

public class ClosedPolyLine extends PictureItem{
    private List<Point> points;

    public ClosedPolyLine(Color color, int thickness, Point start) {
        super(color, thickness);
        points = new ArrayList<>();
        points.add(start);
        makeBoundingBox();
    }

    @Override
    public void drawItem(Graphics2D g) {
        g.setColor(getColor());
        g.setStroke(new BasicStroke(getThickness()));
        for (int i = 0; i < points.size(); i++) {
            int next = (i + 1) % points.size();
            g.drawLine(points.get(i).x, points.get(i).y, points.get(next).x, points.get(next).y);
        }
    }

    @Override
    public void drawSelectedItem(Graphics2D g) {
        g.setColor(getColor());
        g.setStroke(new BasicStroke(getThickness() + MyCanvas.selectedThicker));
        for (int i = 0; i < points.size(); i++) {
            int next = (i + 1) % points.size();
            g.drawLine(points.get(i).x, points.get(i).y, points.get(next).x, points.get(next).y);
        }
    }

    @Override
    protected void makeBoundingBox() {
        Point topLeft = new Point(points.get(0).x, points.get(0).y);
        Point bottomRight = new Point(points.get(0).x, points.get(0).y);
        points.forEach(point -> {
            if (point.x < topLeft.x) topLeft.x = point.x;
            if (point.y < topLeft.y) topLeft.y = point.y;
            if (point.x > bottomRight.x) bottomRight.x = point.x;
            if (point.y > bottomRight.y) bottomRight.y = point.y;
        });
        int width = bottomRight.x - topLeft.x;
        int height = bottomRight.y - topLeft.y;
        MyBoundingBox bb = new MyBoundingBox(topLeft, width, height);
        setBoundingBox(bb);
    }

    @Override
    protected void moveItem(int x, int y) {
        points.forEach(point -> {
            point.x = point.x + x;
            point.y = point.y + y;
        });
    }

    @Override
    public String getDimensions() {
        Point start = points.get(points.size() - 1);
        Point end = points.get(points.size() - 2);
        int width = (int) Math.abs(start.getX() - end.getX());
        int height = (int) Math.abs(start.getY() - end.getY());
        return "(" + String.valueOf(width) + "," + String.valueOf(height) + ")";
    }

    public List<Point> getPoints() {
        return points;
    }

    public void addPoint(Point point) {
        this.points.add(point);
        makeBoundingBox();
    }

    public void setLastPoint(Point point) {
        if (points.size() > 0) {
            points.remove(points.size() - 1);
            points.add(point);
            makeBoundingBox();
        }
    }

    public void removeLastPoint() {
        if (points.size() > 0) {
            points.remove(points.size() - 1);
            makeBoundingBox();
        }
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder("cpoly," + super.toString() + "," + points.size());
        for (Point point : points) {
            ret.append(",").append(point.x).append(",").append(point.y);
        }
        return ret + "\n";
    }
}
