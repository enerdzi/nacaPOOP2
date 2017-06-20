package com.poop.natalija;


import javax.swing.*;
import java.awt.*;

public class MyStatusBar extends JPanel{
    private MyCanvas canvas;

    private JPanel leftPanel = new JPanel();
    private JPanel rightPanel = new JPanel();

    private JLabel toolLabel = new JLabel();
    private JLabel colorLabel = new JLabel();
    private JLabel thicknessLabel = new JLabel();
    private JLabel pointerLabel = new JLabel();
    private JLabel dimensionLabel = new JLabel();

    public MyStatusBar(MyCanvas canvas) {
        this.canvas = canvas;
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(leftPanel, BorderLayout.WEST);
        this.add(Box.createHorizontalGlue());
        this.add(rightPanel, BorderLayout.EAST);

        leftPanel.add(toolLabel);
        leftPanel.add(colorLabel);
        leftPanel.add(thicknessLabel);
        rightPanel.add(pointerLabel);
        rightPanel.add(dimensionLabel);

        resetStatusBar();
    }

    private void setToolLabel() {
        this.toolLabel.setText(canvas.getSelectedTool());
    }

    private void setColorLabel() {
        Color color = canvas.getColor();
        String colorString = "r" + String.valueOf(color.getRed()) + "g" + String.valueOf(color.getGreen())
                + "b" + String.valueOf(color.getBlue());
        this.colorLabel.setText(colorString);
    }

    private void setThicknessLabel() {
        this.thicknessLabel.setText(String.valueOf(canvas.getThickness()));
    }

    private void setPointerLabel() {
        Point point = canvas.getPointer();
        String pointString = "(" + String.valueOf(point.x) + "," + String.valueOf(point.y) + ")";
        this.pointerLabel.setText(pointString);
    }

    private void setDimensionLabel() {
        this.dimensionLabel.setText(canvas.getDimensions());
    }

    public void resetStatusBar(){
        setToolLabel();
        setColorLabel();
        setThicknessLabel();
        setPointerLabel();
        setDimensionLabel();
    }
}
