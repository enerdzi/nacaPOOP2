package com.poop.natalija;


import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame{
    MyStatusBar statusBar;

    public MyWindow() {
        initWindow();
    }

    private void initWindow() {

        ImageIcon icon = new ImageIcon("img/poop.png");

        MyCanvas canvas = new MyCanvas(this);
        setJMenuBar(new MyMenuBar(canvas));
        statusBar = new MyStatusBar(canvas);
        add(new MyToolBar(canvas), BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);

        setIconImage(icon.getImage());
        setTitle("PooPaint");
        setSize(900,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public MyStatusBar getStatusBar() {
        return statusBar;
    }

    public static void main(String args[]){
        EventQueue.invokeLater(() -> {
            MyWindow aw = new MyWindow();
            aw.setVisible(true);
        });
    }

}

