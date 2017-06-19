package com.poop.natalija;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class DeleteListener implements MouseListener {
    private MyCanvas canvas;
    private List<PictureItem> clickedItems;

    public DeleteListener(MyCanvas canvas) {
        this.canvas = canvas;
    }

    private void loadClickedItems(Point point) {
        clickedItems = canvas.getPicture().getItemsByPoint(point);
    }

    private void deleteAndRepaint(PictureItem selected) {
        if (canvas.getSelectedItem() != null) canvas.getSelectedItem().setSelected(false);
        canvas.setSelectedItem(null);
        if (selected != null) canvas.getPicture().removeItem(selected);
        canvas.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point point = new Point(e.getX(), e.getY());
        PictureItem selected = null;
        loadClickedItems(point);
        if (!clickedItems.isEmpty()) {
            if (canvas.getSelectedItem() == null) selected = clickedItems.get(0);
            else if (!clickedItems.contains(canvas.getSelectedItem())) selected = clickedItems.get(0);
            else selected = canvas.getSelectedItem();
        }
        deleteAndRepaint(selected);
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        canvas.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        canvas.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
}
