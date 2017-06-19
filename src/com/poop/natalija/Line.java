package com.poop.natalija;


import java.awt.*;

public class Line extends PictureItem{
    private Point start, end;

    public Line(Point start, Point end, Color color, int thickness) {
        setColor(color);
        setThickness(thickness);
        this.start = start;
        this.end = end;
        makeBoundingBox();
    }

    @Override
    public void drawItem(Graphics2D g) {
        g.setColor(getColor());
        g.setStroke(new BasicStroke(getThickness()));
        g.drawLine(start.x, start.y, end.x, end.y);
    }

    @Override
    public void drawSelectedItem(Graphics2D g) {
        g.setColor(getColor());
        g.setStroke(new BasicStroke(getThickness() + 2));
        g.drawLine(start.x, start.y, end.x, end.y);
    }

    @Override
    protected void makeBoundingBox() {
        Point topLeft = new Point((int) Math.min(start.getX(), end.getX()), (int) Math.min(start.getY(), end.getY()));
        int width = (int) Math.abs(start.getX() - end.getX());
        int height = (int) Math.abs(start.getY() - end.getY());
        MyBoundingBox bb = new MyBoundingBox(topLeft, width, height);
        setBoundingBox(bb);
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }
}
