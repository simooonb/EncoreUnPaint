package client.controller;

import client.model.DrawingComponent;
import client.model.DrawingComponentListener;
import client.model.DrawingListener;
import client.view.DrawingComponentView;
import client.view.DrawingContainerView;
import client.view.StatusAreaView;
import client.view.ToolbarView;

import javax.swing.*;
import java.awt.*;

public class ToolbarController implements DrawingComponentListener,DrawingListener{
    private ToolbarView toolbarView;
    private StatusAreaView statusAreaView;
    private DrawingContainerView drawingContainerView;
    private Color selectedColorForeground = Color.BLACK;
    private Color selectedColorBackground = Color.BLACK;

    public ToolbarController(ToolbarView toolbarView, StatusAreaView statusAreaView, DrawingContainerView drawingContainerView) {

        this.toolbarView = toolbarView;
        this.statusAreaView = statusAreaView;
        this.drawingContainerView = drawingContainerView;
        drawingContainerView.getDrawing().addDrawingListener(this);

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

        this.toolbarView.getBackgroundColorChooser().addActionListener(e -> {
            drawingContainerView.setCurrentStatus("backgroundColor");
            selectedColorBackground = JColorChooser.showDialog(null, "Choose a color", selectedColorBackground);
            drawingContainerView.setCurrentColorBackground(selectedColorBackground);
            toolbarView.getBackgroundColorChooser().setBackground(selectedColorBackground);
            statusAreaView.editStatus("Background Color");
        });

        this.toolbarView.getForegroundColorChooser().addActionListener(e -> {
            drawingContainerView.setCurrentStatus("foregroundColor");
            selectedColorForeground = JColorChooser.showDialog(null, "Choose a color", selectedColorForeground);
            drawingContainerView.setCurrentColorForeground(selectedColorForeground);
            toolbarView.getForegroundColorChooser().setBackground(selectedColorForeground);
            statusAreaView.editStatus("Foreground Color");
        });
    }
    @Override
    public void onDrawingComponentAdded(DrawingComponent drawingComponent){
        drawingComponent.addDrawingComponentListener(this);
    }

    @Override
    public void onDrawingComponentRemoved(DrawingComponent drawingComponent){
        drawingComponent.removeDrawingComponentListener(this);
    }

    @Override
    public void onMoved(){

    }

    @Override
    public void onRemoved(){

    }

    @Override
    public void onColorChanged(){

    }

    @Override
    public void onSelected(){
        toolbarView.getForegroundColorChooser().setBackground(drawingContainerView.getDrawing().getCurrentComponentSelected().getForegroundColor());
        toolbarView.getBackgroundColorChooser().setBackground(drawingContainerView.getDrawing().getCurrentComponentSelected().getBackgroundColor());
        selectedColorForeground = drawingContainerView.getDrawing().getCurrentComponentSelected().getForegroundColor();
        selectedColorBackground = drawingContainerView.getDrawing().getCurrentComponentSelected().getBackgroundColor();
    }

    @Override
    public void onUnselected(){

    }

}
