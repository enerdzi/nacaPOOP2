package com.poop.natalija;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

public class SelectListener implements MouseListener, MouseMotionListener{
    private MyCanvas canvas;
    private List<PictureItem> clickedItems;
    private boolean dragged, selectedClicked;
    private Point clickPoint, lastPoint;

    public SelectListener(MyCanvas canvas) {
        this.canvas = canvas;
        dragged = selectedClicked = false;
    }

    private void loadClickedItems(Point point) {
        clickedItems = canvas.getPicture().getItemsByPoint(point);
    }

    private void selectAndRepaint(PictureItem selected) {
        if (canvas.getSelectedItem() != null) canvas.getSelectedItem().setSelected(false);
        canvas.setSelectedItem(selected);
        if (canvas.getSelectedItem() != null) canvas.getSelectedItem().setSelected(true);
        canvas.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        Point point = new Point(e.getX(), e.getY());
        clickPoint = lastPoint = point;
        PictureItem selected = null;
        dragged = selectedClicked = false;
        loadClickedItems(point);
        if (!clickedItems.isEmpty()) {
            if (canvas.getSelectedItem() == null) selected = clickedItems.get(0);
            else if (!clickedItems.contains(canvas.getSelectedItem())) selected = clickedItems.get(0);
            else selectedClicked = true;
        }
        if (!selectedClicked) selectAndRepaint(selected);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        canvas.setCursor(new Cursor(Cursor.HAND_CURSOR));
        if (selectedClicked && !dragged) {
            int index = (clickedItems.indexOf(canvas.getSelectedItem()) + 1) % clickedItems.size();
            PictureItem selected = clickedItems.get(index);
            selectAndRepaint(selected);
        }
        if (dragged) MyAction.newAction(new MoveAction(canvas, clickPoint, lastPoint));
        dragged = selectedClicked = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        canvas.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        canvas.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (canvas.getSelectedItem() != null) {
            canvas.setCursor(new Cursor(Cursor.MOVE_CURSOR));
            Point point = new Point(e.getX(), e.getY());
            dragged = true;
            canvas.getSelectedItem().move(point.x - lastPoint.x, point.y - lastPoint.y);
            lastPoint = point;
            canvas.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {}
}
