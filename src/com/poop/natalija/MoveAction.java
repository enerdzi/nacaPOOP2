package com.poop.natalija;


import java.awt.*;

public class MoveAction extends MyAction{
    private PictureItem item;
    private Point start, end;

    public MoveAction(MyCanvas canvas,  Point start, Point end) {
        super(canvas);
        this.item = canvas.getSelectedItem();
        this.start = start;
        this.end = end;
    }

    @Override
    protected void undoAction() {
        item.move(start.x - end.x, start.y - end.y);
    }

    @Override
    protected void redoAction() {
        item.move(end.x - start.x, end.y - start.y);
    }
}
