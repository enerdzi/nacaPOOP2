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
        JButton selectBtn = new JButton("Select");
        this.add(selectBtn);
        selectBtn.addActionListener(e -> {
            canvas.setSelectListener();
        });
        JButton lineBtn = new JButton("Line");
        this.add(lineBtn);
        lineBtn.addActionListener(e -> {
            canvas.setLineListener();
        });
    }
}
