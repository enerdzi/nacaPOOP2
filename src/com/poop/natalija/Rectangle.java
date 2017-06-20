package com.poop.natalija;


import java.awt.*;

public class Rectangle extends PictureItem{
    private Point start, end, topLeft;
    private int width, height;

    public Rectangle(Color color, int thickness, Point start, Point end) {
        super(color, thickness);
        this.start = start;
        this.end = end;
        makeBoundingBox();
    }

    @Override
    public void drawItem(Graphics2D g) {
        g.setColor(getColor());
        g.setStroke(new BasicStroke(getThickness()));
        setDimensions();
        g.drawRect(topLeft.x, topLeft.y, width, height);
    }

    @Override
    public void drawSelectedItem(Graphics2D g) {
        g.setColor(getColor());
        g.setStroke(new BasicStroke(getThickness() + MyCanvas.selectedThicker));
        setDimensions();
        g.drawRect(topLeft.x, topLeft.y, width, height);
    }

    @Override
    protected void makeBoundingBox() {
        setDimensions();
        MyBoundingBox bb = new MyBoundingBox(topLeft, width, height);
        setBoundingBox(bb);
    }

    @Override
    protected void moveItem(int x, int y) {
        start = new Point(start.x + x, start.y + y);
        end = new Point(end.x + x, end.y + y);
    }

    @Override
    public String getDimensions() {
        return "(" + String.valueOf(width) + "," + String.valueOf(height) + ")";
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

    public void setDimensions() {
        topLeft = new Point((int) Math.min(start.getX(), end.getX()), (int) Math.min(start.getY(), end.getY()));
        width = (int) Math.abs(start.getX() - end.getX());
        height = (int) Math.abs(start.getY() - end.getY());
    }
}
