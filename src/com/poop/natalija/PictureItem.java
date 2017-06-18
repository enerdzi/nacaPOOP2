package com.poop.natalija;


import java.awt.*;

public abstract class PictureItem {
    private Color color;
    private int thickness;

    public abstract void draw(Graphics2D g);

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
}
