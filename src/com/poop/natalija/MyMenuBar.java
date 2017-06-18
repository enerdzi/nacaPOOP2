package com.poop.natalija;


import javax.swing.*;
import java.awt.event.KeyEvent;

public class MyMenuBar extends JMenuBar{
    public MyMenuBar() {
        createMenuBar();
    }

    private void createMenuBar() {
        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);

        JMenuItem newMenuItem = new JMenuItem("New");
        newMenuItem.setMnemonic(KeyEvent.VK_N);
//        newMenuItem.setToolTipText("Create new painting");
        newMenuItem.addActionListener(e -> {

        });
        file.add(newMenuItem);

        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.setMnemonic(KeyEvent.VK_S);
        saveMenuItem.addActionListener(e -> {

        });
        file.add(saveMenuItem);

        JMenuItem saveAsMenuItem = new JMenuItem("Save As");
        saveAsMenuItem.addActionListener(e -> {

        });
        file.add(saveAsMenuItem);

        JMenuItem closeMenuItem = new JMenuItem("Close");
        closeMenuItem.addActionListener(e -> {

        });
        file.add(closeMenuItem);

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> {

        });
        file.add(exitMenuItem);


        JMenu help = new JMenu("Help");
        file.setMnemonic(KeyEvent.VK_H);

        JMenuItem infoMenuItem = new JMenuItem("Info");
        infoMenuItem.addActionListener(e -> {

        });
        help.add(infoMenuItem);

        this.add(file);
        this.add(help);
    }

}
