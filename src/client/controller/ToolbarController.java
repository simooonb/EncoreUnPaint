package client.controller;

import client.view.DrawingContainerView;
import client.view.StatusAreaView;
import client.view.ToolbarView;

import javax.swing.*;
import java.awt.*;

public class ToolbarController {
    private ToolbarView toolbarView;
    private StatusAreaView statusAreaView;
    private DrawingContainerView drawingContainerView;
    private Color selectedColor = Color.BLACK;

    public ToolbarController(ToolbarView toolbarView, StatusAreaView statusAreaView, DrawingContainerView drawingContainerView) {

        this.toolbarView = toolbarView;
        this.statusAreaView = statusAreaView;
        this.drawingContainerView = drawingContainerView;
        this.toolbarView.getSelectForm().addActionListener(e -> {
            drawingContainerView.setCurrentStatus("selection");
            statusAreaView.editStatus("Selection form");
        });

        this.toolbarView.getFillForm().addActionListener(e -> {
            drawingContainerView.setCurrentStatus("fill");
            statusAreaView.editStatus("Fill form");
        });

        this.toolbarView.getDrawOval().addActionListener(e -> {
            drawingContainerView.setCurrentStatus("oval");
            statusAreaView.editStatus("Oval");
        });

        this.toolbarView.getDrawLine().addActionListener(e -> {
            drawingContainerView.setCurrentStatus("line");
            statusAreaView.editStatus("Line");
        });

        this.toolbarView.getDrawRectangle().addActionListener(e -> {
            drawingContainerView.setCurrentStatus("rectangle");
            statusAreaView.editStatus("Rectangle");
        });

        this.toolbarView.getColorChooser().addActionListener(e -> {
            drawingContainerView.setCurrentStatus("color");
            selectedColor = JColorChooser.showDialog(null, "Choose a color", selectedColor);
            drawingContainerView.setCurrentColor(selectedColor);
            statusAreaView.editStatus("Color");
        });
    }

    public Color getSelectedColor() {
        return selectedColor;
    }
}
