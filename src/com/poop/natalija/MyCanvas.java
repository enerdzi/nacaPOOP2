package com.poop.natalija;


import javax.swing.*;
import java.awt.*;

public class MyCanvas extends JPanel{
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.lightGray);
        g.fillRect(0,0, this.getWidth(), this.getHeight());
    }
}
