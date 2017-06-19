package com.poop.natalija;


import java.awt.*;

public class ColorChangeAction extends MyAction{
    private PictureItem item;
    private Color oldColor, newColor;

    public ColorChangeAction(MyCanvas canvas) {
        super(canvas);
        item = canvas.getSelectedItem();
        oldColor = item.getColor();
        newColor = canvas.getColor();
    }

    @Override
    protected void undoAction() {
        item.setColor(oldColor);
    }

    @Override
    protected void redoAction() {
        item.setColor(newColor);
    }
}
