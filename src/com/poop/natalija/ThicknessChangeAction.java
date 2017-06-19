package com.poop.natalija;


public class ThicknessChangeAction extends MyAction{
    private PictureItem item;
    private int oldThickness, newThickness;

    public ThicknessChangeAction(MyCanvas canvas) {
        super(canvas);
        item = canvas.getSelectedItem();
        oldThickness = item.getThickness();
        newThickness = canvas.getThickness();
    }

    @Override
    protected void undoAction() {
        item.setThickness(oldThickness);
    }

    @Override
    protected void redoAction() {
        item.setThickness(newThickness);
    }
}
