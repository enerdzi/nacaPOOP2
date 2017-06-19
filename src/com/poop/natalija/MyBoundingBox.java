package com.poop.natalija;


import java.awt.*;

public class MyBoundingBox {
    private static final int padding = 5;
    private Point topLeft;
    private int width, height;
    private static final Color boundingBoxColor = Color.lightGray;
    private static final int boundingBoxThickness = 1;

    public MyBoundingBox(Point topLeft, int width, int height) {
        this.topLeft = new Point(topLeft.x - padding, topLeft.y - padding);
        this.width = width + 2*padding;
        this.height = height + 2*padding;
    }

    public void draw(Graphics2D g){
        if (MyCanvas.drawBoundingBox) {
            g.setColor(boundingBoxColor);
            g.setStroke(new BasicStroke(boundingBoxThickness));
            g.drawRect(topLeft.x, topLeft.y, width, height);
        }
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
