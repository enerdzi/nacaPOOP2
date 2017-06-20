package com.poop.natalija;


import java.awt.*;
import java.util.Stack;

public abstract class MyAction {
    private static final Stack<MyAction> undoStack = new Stack<>();
    private static final Stack<MyAction> redoStack = new Stack<>();

    public static boolean undo(){
        if (undoStack.isEmpty()) return false;
        MyAction action = undoStack.pop();
        action.undoAction();
        redoStack.push(action);
        action.apply();
        return true;
    }
    public static boolean redo(){
        if (redoStack.isEmpty()) return false;
        MyAction action = redoStack.pop();
        action.redoAction();
        undoStack.push(action);
        action.apply();
        return true;
    }

    public static void newAction(MyAction action) {
        undoStack.push(action);
        redoStack.clear();
    }

    public static void emptyStacks() {
        undoStack.clear();
        redoStack.clear();
    }

    private MyCanvas canvas;

    public MyAction(MyCanvas canvas) {
        this.canvas = canvas;
    }

    protected abstract void undoAction();
    protected abstract void redoAction();

    public MyCanvas getCanvas() {
        return canvas;
    }

    public void setCanvas(MyCanvas canvas) {
        this.canvas = canvas;
    }

    private void apply() {
        canvas.repaint();
    }

    public static boolean isDirty() {
        return !undoStack.isEmpty();
    }
}
