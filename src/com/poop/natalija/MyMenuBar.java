package com.poop.natalija;


import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class MyMenuBar extends JMenuBar {

    private MyCanvas canvas;
    private boolean saved = false;
    private String path;


    public MyMenuBar(MyCanvas canvas) {
        this.canvas = canvas;
        createMenuBar();
    }

    private void createMenuBar() {
        JMenu file = new JMenu("File");

        JMenuItem newMenuItem = new JMenuItem("New");
        newMenuItem.setMnemonic(KeyEvent.VK_N);
        newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));

//        newMenuItem.setToolTipText("Create new painting");
        newMenuItem.addActionListener(e -> {
            newClick();
        });
        file.add(newMenuItem);

        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.setMnemonic(KeyEvent.VK_S);
        saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
        saveMenuItem.addActionListener(e -> {
            saveClick();
        });
        file.add(saveMenuItem);

        JMenuItem saveAsMenuItem = new JMenuItem("Save As");
        saveAsMenuItem.addActionListener(e -> {
            saveAsClick();
        });
        file.add(saveAsMenuItem);

        JMenuItem closeMenuItem = new JMenuItem("Close");
        closeMenuItem.addActionListener(e -> {
            closeClick();
        });
        file.add(closeMenuItem);

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(e -> {
            exitClick();
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


    private void newClick() {
        setNewImage();
    }

    private void setNewImage() {
        this.path = "";
        this.saved = false;
        canvas.setPicture(new Picture());
        MyAction.emptyStacks();
        canvas.repaint();
    }

    private void saveClick() {
        if (saved) {
            saveImage(path);
        } else {
            String newPath = askUserWhereToSaveImage();
            if (newPath == null) return;
            saveImage(newPath);
            this.path = newPath;
            saved = true;
        }
    }

    private void saveImage(String path) {
        try {
            String content = canvas.getPicture().toString();
            PrintWriter file = new PrintWriter(path);
            file.write(content);
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this.getParent(), "Error, try again");
        }
    }

    private void saveAsClick() {
        String newPath = askUserWhereToSaveImage();
        if (newPath == null) return;
        saveImage(newPath);
        this.path = newPath;
        saved = true;
    }

    private String askUserWhereToSaveImage() {
        JFileChooser saveDialog = new JFileChooser();
        if (saveDialog.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = saveDialog.getSelectedFile();
            return file.getAbsolutePath();
        }
        return null;
    }

    private void closeClick(){
        setNewImage();
    }

    private void exitClick(){
        System.exit(0);
    }
}
