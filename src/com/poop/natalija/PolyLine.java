package com.poop.natalija;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PolyLine extends PictureItem{
    private List<Point> points;

    public PolyLine(Color color, int thickness, Point start) {
        super(color, thickness);
        points = new ArrayList<>();
        points.add(start);
        makeBoundingBox();
    }

    @Override
    public void drawItem(Graphics2D g) {
        g.setColor(getColor());
        g.setStroke(new BasicStroke(getThickness()));
        points.forEach(point -> {
            int index = points.indexOf(point);
            if (index < points.size() - 1) {
                Point next = points.get(index + 1);
                g.drawLine(point.x, point.y, next.x, next.y);
            }
        });
    }

    @Override
    public void drawSelectedItem(Graphics2D g) {
        g.setColor(getColor());
        g.setStroke(new BasicStroke(getThickness() + MyCanvas.selectedThicker));
        points.forEach(point -> {
            int index = points.indexOf(point);
            if (index < points.size() - 1) {
                Point next = points.get(index + 1);
                g.drawLine(point.x, point.y, next.x, next.y);
            }
        });
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
}
