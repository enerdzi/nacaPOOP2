package com.poop.natalija;


import java.awt.*;

public abstract class PictureItem {
    private Color color;
    private int thickness;
    private MyBoundingBox boundingBox;

    public void draw(Graphics2D g) {
        drawItem(g);
        boundingBox.draw(g);
    }

    public abstract void drawItem(Graphics2D g);
    protected abstract void makeBoundingBox();

    public Color getColor() {
        return color;
    }

    public int getThickness() {
        return thickness;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public void setBoundingBox(MyBoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }
}
