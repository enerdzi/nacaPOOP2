package com.poop.natalija;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class RectangleListener implements MouseListener, MouseMotionListener{
    private MyCanvas canvas;
    private Rectangle rectangle;

    public RectangleListener(MyCanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        Point point = new Point(e.getX(), e.getY());
        rectangle = new Rectangle(MyCanvas.defaultColor, MyCanvas.defaultThickness, point, point);
        canvas.setDrawingItem(rectangle);
        canvas.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Point point = new Point(e.getX(), e.getY());
        rectangle = new Rectangle(canvas.getColor(), canvas.getThickness(), rectangle.getStart(), point);
        canvas.setDrawingItem(null);
        canvas.getPicture().addItem(rectangle);
        MyAction.newAction(new NewItemAction(canvas, rectangle));
        canvas.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {
        Point point = new Point(e.getX(), e.getY());
        rectangle = new Rectangle(MyCanvas.defaultColor, MyCanvas.defaultThickness, rectangle.getStart(), point);
        canvas.setDrawingItem(rectangle);
        canvas.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {}
}
