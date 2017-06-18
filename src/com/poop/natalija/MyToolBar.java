package com.poop.natalija;


import javax.swing.*;

public class MyToolBar extends JToolBar{
    public MyToolBar() {
        createToolBar();

        setFloatable(false);
    }

    private void createToolBar() {
        JButton b = new JButton("Test");
        this.add(b);
        b.addActionListener(e -> {

        });
    }
}
