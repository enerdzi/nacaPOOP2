package com.poop.natalija;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MyCanvas extends JPanel{
    private MyWindow app;

    public static boolean drawBoundingBox = true;

    public static final Color defaultColor = Color.darkGray;
    public static final int defaultThickness = 2;

    public static final int selectedThicker = 2;

    private Picture picture;
    private Color color;
    private int thickness;

    private PictureItem drawingItem;
    private PictureItem selectedItem;

    private String selectedTool;
    private Point pointer;
    private String dimensions;

    private SelectListener selectListener;
    private DeleteListener deleteListener;

    private LineListener lineListener;
    private PolyLineListener polyLineListener;
    private ClosedPolyLineListener closedPolyLineListener;
    private RectangleListener rectangleListener;

    public MyCanvas(MyWindow app) {
        this.app = app;
        picture = new Picture();
        color = new Color(0, 0, 0);
        thickness = 1;

        drawingItem = selectedItem = null;

        selectListener = new SelectListener(this);
        deleteListener = new DeleteListener(this);

        lineListener = new LineListener(this);
        polyLineListener = new PolyLineListener(this);
        closedPolyLineListener = new ClosedPolyLineListener(this);
        rectangleListener = new RectangleListener(this);

        this.setSelectListener();
        selectedTool = "Select";
        pointer = new Point(0,0);
        dimensions = "";

        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                pointer = e.getPoint();
                app.getStatusBar().resetStatusBar();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                pointer = e.getPoint();
                app.getStatusBar().resetStatusBar();
            }
        });
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
        app.getStatusBar().resetStatusBar();
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
        app.getStatusBar().resetStatusBar();
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
        dimensions = (drawingItem == null) ? "" : drawingItem.getDimensions();
        app.getStatusBar().resetStatusBar();
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

    public String getSelectedTool() {
        return selectedTool;
    }

    public void setSelectedTool(String selectedTool) {
        this.selectedTool = selectedTool;
        app.getStatusBar().resetStatusBar();
    }

    public Point getPointer() {
        return pointer;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
        app.getStatusBar().resetStatusBar();
    }
}
