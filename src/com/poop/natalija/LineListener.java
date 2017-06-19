package com.poop.natalija;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class LineListener implements MouseListener, MouseMotionListener{
    private MyCanvas canvas;
    Line line;

    public LineListener(MyCanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        Point point = new Point(e.getX(), e.getY());
        line = new Line(point, point, MyCanvas.defaultColor, MyCanvas.defaultThickness);
        canvas.setDrawingItem(line);
        canvas.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Point point = new Point(e.getX(), e.getY());
        line = new Line(line.getStart(), point, canvas.getColor(), canvas.getThickness());
        canvas.setDrawingItem(null);
        canvas.getPicture().addItem(line);
        MyAction.newAction(new NewItemAction(canvas, line));
        canvas.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {
        Point point = new Point(e.getX(), e.getY());
        line = new Line(line.getStart(), point, MyCanvas.defaultColor, MyCanvas.defaultThickness);
        canvas.setDrawingItem(line);
        canvas.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {}
}
