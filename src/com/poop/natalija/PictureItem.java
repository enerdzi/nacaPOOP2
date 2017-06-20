package com.poop.natalija;


import java.awt.*;

public abstract class PictureItem {
    private Color color;
    private int thickness;
    private MyBoundingBox boundingBox;
    private boolean isSelected;

    public PictureItem(Color color, int thickness){
        this.color = color;
        this.thickness = thickness;
        isSelected = false;
    }

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

    public void move(int x, int y) {
        moveItem(x, y);
        moveBoundingBox(x, y);
    }

    public abstract void drawItem(Graphics2D g);
    public abstract void drawSelectedItem(Graphics2D g);
    protected abstract void makeBoundingBox();
    protected abstract void moveItem(int x, int y);
    public abstract String getDimensions();

    private void moveBoundingBox(int x, int y) {
        Point topLeft = boundingBox.getTopLeft();
        Point newTopLeft = new Point(topLeft.x + x, topLeft.y + y);
        boundingBox.setTopLeft(newTopLeft);
    }

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
