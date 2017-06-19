package com.poop.natalija;


public class DeleteAction extends MyAction{
    private PictureItem item;
    private int index;


    public DeleteAction(MyCanvas canvas) {
        super(canvas);
        item = canvas.getSelectedItem();
        index = canvas.getPicture().getItemIndex(item);
    }


    @Override
    protected void undoAction() {
        getCanvas().getPicture().insertItem(item, index);
    }

    @Override
    protected void redoAction() {
        getCanvas().getPicture().removeItem(item);
    }
}
