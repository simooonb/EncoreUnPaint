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

            if (status == null || !(status.getType().getName().equals("String")))
                return;

            try{
                toolbarView.addTool((Tool)tool.newInstance());
            }
            catch(IllegalArgumentException | IllegalAccessException | InstantiationException ilae){
                ilae.printStackTrace();
            }
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
        /*toolbarView.getForegroundColorChooser().setBackground(drawingContainerView.getDrawing().getCurrentComponentSelected().getForegroundColor());
        toolbarView.getBackgroundColorChooser().setBackground(drawingContainerView.getDrawing().getCurrentComponentSelected().getBackgroundColor());
        selectedColorForeground = drawingContainerView.getDrawing().getCurrentComponentSelected().getForegroundColor();
        selectedColorBackground = drawingContainerView.getDrawing().getCurrentComponentSelected().getBackgroundColor();*/
    }

    @Override
    public void onUnselected(){

    }

}
