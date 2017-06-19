package com.poop.natalija;


public class NewItemAction extends MyAction{
    private PictureItem item;

    public NewItemAction(MyCanvas canvas, PictureItem item) {
        super(canvas);
        this.item = item;
    }

    @Override
    protected void undoAction() {
        getCanvas().getPicture().removeItem(item);
    }

    @Override
    protected void redoAction() {
        getCanvas().getPicture().addItem(item);
    }
}
