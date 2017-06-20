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

    public void removeItem(PictureItem item) {
        items.remove(item);
    }

    public List<PictureItem> getItemsByPoint(Point point) {
        List<PictureItem> filteredItems = items
                .stream()
                .filter(item -> item.isClicked(point))
                .collect(Collectors.toList());
        Collections.reverse(filteredItems);
        return filteredItems;
    }

    public int getItemIndex(PictureItem item) {
        return items.indexOf(item);
    }

    public void insertItem(PictureItem item, int index) {
        items.add(index, item);
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (PictureItem pictureItem : items) {
            ret.append(pictureItem.toString());
        }
        return ret.toString();
    }
}
