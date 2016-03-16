package client.controller;

import client.view.ToolbarView;

import javax.swing.*;
import java.awt.*;

public class ToolbarController {
    private ToolbarView toolbarView;
    private Color selectedColor = Color.BLACK;

    public ToolbarController(ToolbarView toolbarView) {

        this.toolbarView = toolbarView;
        this.toolbarView.getSelectForm().addActionListener(e -> System.out.println("select form"));

        this.toolbarView.getFillForm().addActionListener(e -> System.out.println("fill form"));

        this.toolbarView.getDrawOval().addActionListener(e -> System.out.println("draw oval"));

        this.toolbarView.getDrawLine().addActionListener(e -> System.out.println("draw line"));

        this.toolbarView.getDrawRectangle().addActionListener(e -> System.out.println("draw rectangle"));

        this.toolbarView.getColorChooser().addActionListener(e -> {
            System.out.println("color chooser");
            selectedColor = JColorChooser.showDialog(null, "Choose a color", selectedColor);
        });
    }
}
