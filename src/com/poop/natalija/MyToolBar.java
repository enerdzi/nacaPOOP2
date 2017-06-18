package com.poop.natalija;


import javax.swing.*;

public class MyToolBar extends JToolBar{
    private MyCanvas canvas;

    public MyToolBar(MyCanvas canvas) {
        this.canvas = canvas;
        createToolBar();

        setFloatable(false);
    }

    private void createToolBar() {
        JButton b = new JButton("Line");
        this.add(b);
        b.addActionListener(e -> {
            canvas.setLineListener();
        });
    }
}
