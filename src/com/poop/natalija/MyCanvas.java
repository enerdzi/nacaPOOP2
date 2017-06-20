package com.poop.natalija;


import javax.swing.*;
import java.awt.*;

public class MyCanvas extends JPanel{
    public static boolean drawBoundingBox = true;

    public static final Color defaultColor = Color.darkGray;
    public static final int defaultThickness = 2;

    public static final int selectedThicker = 2;

    private Picture picture;
    private Color color;
    private int thickness;

    private PictureItem drawingItem;
    private PictureItem selectedItem;

    private SelectListener selectListener;
    private DeleteListener deleteListener;

    private LineListener lineListener;
    private PolyLineListener polyLineListener;
    private ClosedPolyLineListener closedPolyLineListener;
    private RectangleListener rectangleListener;

    public MyCanvas() {
        picture = new Picture();
        color = new Color(44, 62, 80);
        thickness = 1;

        drawingItem = selectedItem = null;

        selectListener = new SelectListener(this);
        deleteListener = new DeleteListener(this);

        lineListener = new LineListener(this);
        polyLineListener = new PolyLineListener(this);
        closedPolyLineListener = new ClosedPolyLineListener(this);
        rectangleListener = new RectangleListener(this);

        this.setSelectListener();
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
        if (selectedItem != null) {
            MyAction.newAction(new ColorChangeAction(this));
            selectedItem.setColor(this.color);
            this.repaint();
        }
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
        if (selectedItem != null) {
            MyAction.newAction(new ThicknessChangeAction(this));
            selectedItem.setThickness(this.thickness);
            this.repaint();
        }
    }

    public PictureItem getDrawingItem() {
        return drawingItem;
    }

    public void setDrawingItem(PictureItem drawingItem) {
        this.drawingItem = drawingItem;
    }

    public PictureItem getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(PictureItem selectedItem) {
        this.selectedItem = selectedItem;
    }

    private void removeListeners() {
        this.removeMouseListener(selectListener);
        this.removeMouseMotionListener(selectListener);
        this.removeMouseListener(deleteListener);
        this.removeMouseListener(lineListener);
        this.removeMouseMotionListener(lineListener);
        this.removeMouseListener(polyLineListener);
        this.removeMouseMotionListener(polyLineListener);
        this.removeMouseListener(closedPolyLineListener);
        this.removeMouseMotionListener(closedPolyLineListener);
        this.removeMouseListener(rectangleListener);
        this.removeMouseMotionListener(rectangleListener);
    }

    public void setLineListener() {
        removeListeners();
        unSelect();
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        this.addMouseListener(lineListener);
        this.addMouseMotionListener(lineListener);
    }

    public void setPolyLineListener() {
        removeListeners();
        unSelect();
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        this.addMouseListener(polyLineListener);
        this.addMouseMotionListener(polyLineListener);
    }

    public void setClosedPolyLineListener() {
        removeListeners();
        unSelect();
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        this.addMouseListener(closedPolyLineListener);
        this.addMouseMotionListener(closedPolyLineListener);
    }

    public void setRectangleListener() {
        removeListeners();
        unSelect();
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        this.addMouseListener(rectangleListener);
        this.addMouseMotionListener(rectangleListener);
    }

    public void setSelectListener() {
        removeListeners();
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.addMouseListener(selectListener);
        this.addMouseMotionListener(selectListener);
    }

    public void setDeleteListener() {
        removeListeners();
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.addMouseListener(deleteListener);
    }

    public void undo() {
        if (MyAction.undo()) unSelect();
    }

    public void redo() {
        if (MyAction.redo()) unSelect();
    }

    private void unSelect() {
        if (this.getSelectedItem() != null) this.getSelectedItem().setSelected(false);
        this.setSelectedItem(null);
        this.repaint();
    }
}
