package com.poop.natalija;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class PolyLineListener implements MouseListener, MouseMotionListener{
    private MyCanvas canvas;
    private PolyLine line;
    private boolean drawing;

    public PolyLineListener(MyCanvas canvas) {
        this.canvas = canvas;
        drawing = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point point = new Point(e.getX(), e.getY());
        if(e.getClickCount() == 1) {
            if (!drawing) {
                line = new PolyLine(MyCanvas.defaultColor, MyCanvas.defaultThickness, point);
                drawing = true;
                line.addPoint(point);
                canvas.setDrawingItem(line);
            } else {
                line.setLastPoint(point);
                line.addPoint(point);
            }
        }
        if (e.getClickCount() == 2) {
            canvas.setDrawingItem(null);
            line.setColor(canvas.getColor());
            line.setThickness(canvas.getThickness());
            line.removeLastPoint();
            canvas.getPicture().addItem(line);
            MyAction.newAction(new NewItemAction(canvas, line));
            drawing = false;
        }
        canvas.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        if (drawing) {
            Point point = new Point(e.getX(), e.getY());
            line.setLastPoint(point);
            canvas.setDrawingItem(line);
            canvas.repaint();
        }
    }
}
