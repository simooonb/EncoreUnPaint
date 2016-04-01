package client.controller;

import client.model.drawingComponents.DrawingComponent;
import client.model.drawingComponents.DrawingComponentListener;
import client.model.drawing.DrawingListener;
import client.view.DrawingContainerView;
import client.view.StatusAreaView;
import client.view.tools.ToolbarView;

import javax.swing.*;
import java.awt.*;

public class ToolbarController implements DrawingComponentListener,DrawingListener{
    private ToolbarView toolbarView;
    private StatusAreaView statusAreaView;
    private DrawingContainerView drawingContainerView;

    public ToolbarController(ToolbarView toolbarView, StatusAreaView statusAreaView, DrawingContainerView drawingContainerView) {

        this.toolbarView = toolbarView;
        this.statusAreaView = statusAreaView;
        this.drawingContainerView = drawingContainerView;
        drawingContainerView.getDrawing().addDrawingListener(this);
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
