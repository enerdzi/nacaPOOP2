package com.poop.natalija;


import javax.swing.*;
import java.awt.event.KeyEvent;

public class MyMenuBar extends JMenuBar {

    public MyMenuBar() {
        createMenuBar();
    }

    private void createMenuBar() {
        JMenu file = new JMenu("File");

        JMenuItem newMenuItem = new JMenuItem("New");
        newMenuItem.setMnemonic(KeyEvent.VK_N);
        newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));

//        newMenuItem.setToolTipText("Create new painting");
        newMenuItem.addActionListener(e -> {

        });
        file.add(newMenuItem);

        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.setMnemonic(KeyEvent.VK_S);
        saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
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

        JMenuItem infoMenuItem = new JMenuItem("Info");
        infoMenuItem.setMnemonic(KeyEvent.VK_I);
        infoMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_MASK));
        infoMenuItem.addActionListener(e -> {
            JOptionPane.showMessageDialog(this.getParent(), "Natalija Radic");
        });
        help.add(infoMenuItem);

        this.add(file);
        this.add(help);
    }
}
