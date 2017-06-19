package com.poop.natalija;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class SelectListener implements MouseListener{
    private MyCanvas canvas;

    public SelectListener(MyCanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point point = new Point(e.getX(), e.getY());
        PictureItem selected = null;
        List<PictureItem> clickedItems = canvas.getPicture().getItemsByPoint(point);
        if (!clickedItems.isEmpty()) {
            if (canvas.getSelectedItem() == null) selected = clickedItems.get(0);
            else if (!clickedItems.contains(canvas.getSelectedItem())) selected = clickedItems.get(0);
            else {
                int index = (clickedItems.indexOf(canvas.getSelectedItem()) + 1) % clickedItems.size();
                selected = clickedItems.get(index);
            }
        }
        if (canvas.getSelectedItem() != null) canvas.getSelectedItem().setSelected(false);
        canvas.setSelectedItem(selected);
        if (canvas.getSelectedItem() != null) canvas.getSelectedItem().setSelected(true);
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
}
