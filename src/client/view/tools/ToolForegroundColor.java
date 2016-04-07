package client.view.tools;

import client.model.drawing.DrawingListener;
import client.model.drawingComponents.DrawingComponent;
import client.model.drawingComponents.DrawingComponentListener;
import client.view.DrawingContainerView;
import client.view.StatusAreaView;

import javax.swing.*;
import java.awt.*;

public class ToolForegroundColor extends Tool implements DrawingListener,DrawingComponentListener{
    private Color selectedColorForeground = Color.BLACK;
    private String status = "foregroundColor";

    public ToolForegroundColor(DrawingContainerView drawingContainerView, StatusAreaView statusAreaView){
        super("Foreground",drawingContainerView,statusAreaView);
        drawingContainerView.getDrawing().addDrawingListener(this);
        setBackground(selectedColorForeground);
        addActionListener(e -> {
            getDrawingContainerView().setCurrentStatus(status);
            selectedColorForeground = JColorChooser.showDialog(null, "Choose a color", selectedColorForeground);
            getDrawingContainerView().setCurrentColorForeground(selectedColorForeground);
            setBackground(selectedColorForeground);
            getStatusAreaView().editStatus("Foreground Color");
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
    public void onMoved(){}

    @Override
    public void onRemoved(){}

    @Override
    public void onColorChanged(){}

    @Override
    public void onSelected(){
        setBackground(getDrawingContainerView().getDrawing().getCurrentComponentSelected().getForegroundColor());
    }

    @Override
    public void onUnselected(){}
}
