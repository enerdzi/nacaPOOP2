package com.poop.natalija;


import java.awt.*;

public class Line extends PictureItem{
    private Point start, end;

    public Line(Point start, Point end, Color color, int thickness) {
        setColor(color);
        setThickness(thickness);
        this.start = start;
        this.end = end;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(getColor());
        g.setStroke(new BasicStroke(getThickness()));
        g.drawLine(start.x, start.y, end.x, end.y);
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
