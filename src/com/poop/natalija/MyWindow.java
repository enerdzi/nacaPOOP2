package com.poop.natalija;


import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame{

    public MyWindow() {
        initWindow();
    }

    private void initWindow() {

        ImageIcon icon = new ImageIcon("img/poop.png");

        setJMenuBar(new MyMenuBar());
        MyCanvas canvas = new MyCanvas();
        add(new MyToolBar(canvas), BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);

        setIconImage(icon.getImage());
        setTitle("PooPaint");
        setSize(700,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String args[]){
        EventQueue.invokeLater(() -> {
            MyWindow aw = new MyWindow();
            aw.setVisible(true);
        });
    }

}

