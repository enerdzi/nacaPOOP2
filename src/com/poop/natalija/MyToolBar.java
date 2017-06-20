package com.poop.natalija;


import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class MyToolBar extends JToolBar{
    private MyCanvas canvas;
    private static final int colorButtonSize = 15;
    private static final List<String> thicknessList = Arrays.asList("1", "2", "4", "8");
    private static final List<Color> colorList = Arrays.asList(
            new Color(0, 0, 0),
            new Color(157, 157, 157),
            new Color(255, 255, 255),
            new Color(190, 38, 51),
            new Color(224, 111, 139),
            new Color(73, 60, 43),
            new Color(164, 100, 34),
            new Color(235, 137, 49),
            new Color(247, 226, 107),
            new Color(47, 72, 78),
            new Color(68, 137, 26),
            new Color(163, 206, 39),
            new Color(27, 38, 50),
            new Color(0, 87, 132),
            new Color(49, 162, 242),
            new Color(178, 220, 239)
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
            canvas.setSelectedTool("Select");
        });
        JButton deleteBtn = new JButton("Delete");
        this.add(deleteBtn);
        deleteBtn.addActionListener(e -> {
            canvas.setDeleteListener();
            canvas.setSelectedTool("Delete");
        });
        JCheckBox showBoxCheck = new JCheckBox("Show box", true);
        this.add(showBoxCheck);
        showBoxCheck.addItemListener(e -> {
           MyCanvas.drawBoundingBox = (e.getStateChange() == 1);
           canvas.repaint();
        });
        this.addSeparator();
        JButton lineBtn = new JButton("Line");
        this.add(lineBtn);
        lineBtn.addActionListener(e -> {
            canvas.setLineListener();
            canvas.setSelectedTool("Line");
        });
        JButton polyLineBtn = new JButton("PolyLine");
        this.add(polyLineBtn);
        polyLineBtn.addActionListener(e -> {
            canvas.setPolyLineListener();
            canvas.setSelectedTool("PolyLine");
        });
        JButton closedPolyLineBtn = new JButton("ClosedPolyLine");
        this.add(closedPolyLineBtn);
        closedPolyLineBtn.addActionListener(e -> {
            canvas.setClosedPolyLineListener();
            canvas.setSelectedTool("Closed PolyLine");
        });
        JButton rectangleBtn = new JButton("Rectangle");
        this.add(rectangleBtn);
        rectangleBtn.addActionListener(e -> {
            canvas.setRectangleListener();
            canvas.setSelectedTool("Rectangle");
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
