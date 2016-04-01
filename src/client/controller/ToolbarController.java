package client.controller;

import client.model.drawingComponents.DrawingComponent;
import client.model.drawingComponents.DrawingComponentListener;
import client.model.drawing.DrawingListener;
import client.view.DrawingContainerView;
import client.view.StatusAreaView;
import client.view.tools.Tool;
import client.view.tools.ToolbarView;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

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

        toolbarView.getPlus().addActionListener(actionEvent -> {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Java Classes", "class");
            chooser.setFileFilter(filter);
            Class tool = null;
            Field status = null;
            Tool toolInstance = null;

            if (chooser.showOpenDialog(toolbarView) == JFileChooser.APPROVE_OPTION) {
                try {
                    tool = Class.forName(chooser.getSelectedFile().getName());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

            if (tool == null)
                return;

            try {
                status = tool.getDeclaredField("status");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }

            if (status == null)
                return;

            try {
                toolInstance = (Tool) tool.newInstance();
                toolbarView.add(toolInstance);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        /*this.toolbarView.getSelectForm().addActionListener(e -> {
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
        });*/
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
        /*toolbarView.getForegroundColorChooser().setBackground(drawingContainerView.getDrawing().getCurrentComponentSelected().getForegroundColor());
        toolbarView.getBackgroundColorChooser().setBackground(drawingContainerView.getDrawing().getCurrentComponentSelected().getBackgroundColor());
        selectedColorForeground = drawingContainerView.getDrawing().getCurrentComponentSelected().getForegroundColor();
        selectedColorBackground = drawingContainerView.getDrawing().getCurrentComponentSelected().getBackgroundColor();*/
    }

    @Override
    public void onUnselected(){

    }

}
