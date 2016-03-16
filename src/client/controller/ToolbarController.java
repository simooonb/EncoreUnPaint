package client.controller;

import client.view.StatusAreaView;
import client.view.ToolbarView;

import javax.swing.*;
import java.awt.*;

public class ToolbarController {
    private ToolbarView toolbarView;
    private StatusAreaView statusAreaView;
    private Color selectedColor = Color.BLACK;

    public ToolbarController(ToolbarView toolbarView, StatusAreaView statusAreaView) {

        this.toolbarView = toolbarView;
        this.statusAreaView = statusAreaView;
        this.toolbarView.getSelectForm().addActionListener(e -> {
            System.out.println("select form");
            statusAreaView.editStatus("Selection form");
        });

        this.toolbarView.getFillForm().addActionListener(e -> {
            System.out.println("fill form");
            statusAreaView.editStatus("Fill form");
        });

        this.toolbarView.getDrawOval().addActionListener(e -> {
            System.out.println("draw oval");
            statusAreaView.editStatus("Oval");
        });

        this.toolbarView.getDrawLine().addActionListener(e -> {
            System.out.println("draw line");
            statusAreaView.editStatus("Line");
        });

        this.toolbarView.getDrawRectangle().addActionListener(e -> {
            System.out.println("draw rectangle");
            statusAreaView.editStatus("Rectangle");
        });

        this.toolbarView.getColorChooser().addActionListener(e -> {
            System.out.println("color chooser");
            selectedColor = JColorChooser.showDialog(null, "Choose a color", selectedColor);
            statusAreaView.editStatus("Color");
        });
    }
}
