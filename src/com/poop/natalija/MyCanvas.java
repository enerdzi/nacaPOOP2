package com.poop.natalija;


import javax.swing.*;
import java.awt.*;

public class MyCanvas extends JPanel{
    private Picture picture;

    public MyCanvas() {
        picture = new Picture();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.lightGray);
        g.fillRect(0,0, this.getWidth(), this.getHeight());
        picture.repaintPicture(g);
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
