package com.poop.natalija;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Picture {
    private List<PictureItem> items;

    public Picture() {
        items = new ArrayList<PictureItem>();
    }

    public void repaintPicture(Graphics g) {
        items.forEach(pictureItem -> pictureItem.draw(g));
    }
}
