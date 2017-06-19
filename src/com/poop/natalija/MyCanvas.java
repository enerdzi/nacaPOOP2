package com.poop.natalija;


import javax.swing.*;
import java.awt.*;

public class MyCanvas extends JPanel{
    public static boolean drawBoundingBox = true;

    public static final Color defaultColor = Color.darkGray;
    public static final int defaultThickness = 2;

    private Picture picture;
    private Color color;
    private int thickness;

    private PictureItem drawingItem;

    private LineListener lineListener;

    public MyCanvas() {
        picture = new Picture();
        color = Color.BLACK;
        thickness = 1;
        drawingItem = null;
        lineListener = new LineListener(this);
    }

    @Override
    public void paint(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.white);
        g.fillRect(0,0, this.getWidth(), this.getHeight());
        picture.repaintPicture(g);
        if (drawingItem != null) drawingItem.draw(g);
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public PictureItem getDrawingItem() {
        return drawingItem;
    }

    public void setDrawingItem(PictureItem drawingItem) {
        this.drawingItem = drawingItem;
    }

    private void removeListeners() {
        this.removeMouseListener(lineListener);
        this.removeMouseMotionListener(lineListener);
    }

    public void setLineListener() {
        removeListeners();
        this.addMouseListener(lineListener);
        this.addMouseMotionListener(lineListener);
    }
}
