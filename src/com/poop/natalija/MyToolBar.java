package com.poop.natalija;


import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class MyToolBar extends JToolBar{
    private MyCanvas canvas;
    private static final int colorButtonSize = 15;
    private static final List<String> thicknessList = Arrays.asList("1", "2", "4", "8");
    private static final List<Color> colorList = Arrays.asList(
            new Color(44, 62, 80),
            new Color(142, 68, 173),
            new Color(41, 128, 185),
            new Color(39, 174, 96),
            new Color(26, 188, 156),
            new Color(241, 196, 15),
            new Color(230, 126, 34),
            new Color(231, 76, 60),
            new Color(52, 73, 94),
            new Color(155, 89, 182),
            new Color(52, 152, 219),
            new Color(46, 204, 113),
            new Color(22, 160, 133),
            new Color(243, 156, 18),
            new Color(211, 84, 0),
            new Color(192, 57, 43)
    );

    public MyToolBar(MyCanvas canvas) {
        this.canvas = canvas;
        createToolBar();

        setFloatable(false);
    }

    private void createToolBar() {
        JButton selectBtn = new JButton("Select");
        this.add(selectBtn);
        selectBtn.addActionListener(e -> {
            canvas.setSelectListener();
        });
        JButton deleteBtn = new JButton("Delete");
        this.add(deleteBtn);
        deleteBtn.addActionListener(e -> {
            canvas.setDeleteListener();
        });
        JCheckBox showBoxCheck = new JCheckBox("Show box", true);
        this.add(showBoxCheck);
        showBoxCheck.addItemListener(e -> {
           MyCanvas.drawBoundingBox = (e.getStateChange()==1 ? true : false);
           canvas.repaint();
        });
        this.addSeparator();
        JButton lineBtn = new JButton("Line");
        this.add(lineBtn);
        lineBtn.addActionListener(e -> {
            canvas.setLineListener();
        });
        this.addSeparator();
        JPanel activeColor = new JPanel();
        activeColor.setBackground(canvas.getColor());
        activeColor.setMaximumSize(new Dimension(colorButtonSize*2, colorButtonSize*2));
        this.add(activeColor);
        JPanel colorsPanel = new JPanel();
        colorsPanel.setLayout(new BoxLayout(colorsPanel, BoxLayout.Y_AXIS));
        JPanel topPanel = new JPanel();
        colorList.stream().limit(8).forEach(color -> {
            JButton colorBtn = new JButton();
            colorBtn.setBackground(color);
            colorBtn.setPreferredSize(new Dimension(colorButtonSize, colorButtonSize));
            topPanel.add(colorBtn);
            colorBtn.addActionListener(e -> {
                canvas.setColor(color);
                activeColor.setBackground(color);
            });
        });
        colorsPanel.add(topPanel);
        JPanel bottomPanel = new JPanel();
        colorList.stream().skip(8).forEach(color -> {
            JButton colorBtn = new JButton();
            colorBtn.setBackground(color);
            colorBtn.setPreferredSize(new Dimension(colorButtonSize, colorButtonSize));
            bottomPanel.add(colorBtn);
            colorBtn.addActionListener(e -> {
                canvas.setColor(color);
                activeColor.setBackground(color);
            });
        });
        colorsPanel.add(bottomPanel);
        colorsPanel.setMaximumSize(colorsPanel.getPreferredSize());
        this.add(colorsPanel);
        this.addSeparator();
        JLabel thicknessLabel = new JLabel("Thickness: ");
        this.add(thicknessLabel);
        JComboBox thicknessSelect = new JComboBox<>(thicknessList.toArray());
        thicknessSelect.setSelectedIndex(0);
        thicknessSelect.setMaximumSize(thicknessSelect.getPreferredSize());
        this.add(thicknessSelect);
        thicknessSelect.addActionListener(e -> {
            JComboBox cb = (JComboBox)e.getSource();
            String label = (String)cb.getSelectedItem();
            int value = Integer.parseInt(label);
            canvas.setThickness(value);
        });
        this.addSeparator();
        JButton undoBtn = new JButton("Undo");
        this.add(undoBtn);
        undoBtn.addActionListener(e -> {
            canvas.undo();
        });
        JButton redoBtn = new JButton("Redo");
        this.add(redoBtn);
        redoBtn.addActionListener(e -> {
            canvas.redo();
        });
    }
}
