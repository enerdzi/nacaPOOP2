package com.poop.natalija;


import javax.swing.*;
import java.awt.*;

public class AppWindow extends JFrame{

    public AppWindow() {
        initWindow();
    }

    private void initWindow() {

        ImageIcon icon = new ImageIcon("img/poop.png");

        setJMenuBar(new MyMenuBar());

        setIconImage(icon.getImage());
        setTitle("PooPaint");
        setSize(700,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String args[]){
        EventQueue.invokeLater(() -> {
            AppWindow aw = new AppWindow();
            aw.setVisible(true);
        });
    }

}

