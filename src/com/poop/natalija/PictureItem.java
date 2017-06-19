package com.poop.natalija;


import java.awt.*;

public abstract class PictureItem {
    private Color color;
    private int thickness;
    private MyBoundingBox boundingBox;
    private boolean isSelected;

    public void draw(Graphics2D g) {
        if (isSelected) drawSelected(g);
        else {
            drawItem(g);
            boundingBox.draw(g);
        }
    }

    private void drawSelected(Graphics2D g) {
        drawSelectedItem(g);
        boundingBox.drawSelected(g);
    }

    public abstract void drawItem(Graphics2D g);
    public abstract void drawSelectedItem(Graphics2D g);
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

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isClicked(Point p) {
        return boundingBox.isInBoundingBox(p);
    }
}
