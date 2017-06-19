package com.poop.natalija;


import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Picture {
    private List<PictureItem> items;

    public Picture() {
        items = new ArrayList<>();
    }

    public void repaintPicture(Graphics2D g) {
        items.forEach(pictureItem -> pictureItem.draw(g));
    }

    public void addItem(PictureItem item) {
        items.add(item);
    }
    public List<PictureItem> getItemsByPoint(Point point) {
        List<PictureItem> filteredItems = items
                .stream()
                .filter(item -> item.isClicked(point))
                .collect(Collectors.toList());
        Collections.reverse(filteredItems);
        return filteredItems;
    }
}
