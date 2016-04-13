package client.view.tools;

import client.model.drawing.DrawingListener;
import client.model.drawingComponents.DrawingComponent;
import client.model.drawingComponents.DrawingComponentListener;
import client.view.DrawingContainerView;
import client.view.StatusAreaView;

import javax.swing.*;
import java.awt.*;

public class ToolBackgroundColor extends Tool implements DrawingListener,DrawingComponentListener{
    private Color selectedColorBackground = Color.BLACK;
    private String status = "backgroundColor";
    private Color lastColorBackground = Color.BLACK;

    public ToolBackgroundColor(DrawingContainerView drawingContainerView, StatusAreaView statusAreaView){
        super("Background",drawingContainerView,statusAreaView);
        drawingContainerView.getDrawing().addDrawingListener(this);
        setBackground(selectedColorBackground);
        addActionListener(e -> {
            getDrawingContainerView().setCurrentStatus(status);
            if(lastColorBackground != selectedColorBackground){
                lastColorBackground = selectedColorBackground;
            }
            selectedColorBackground = JColorChooser.showDialog(null, "Choose a color", selectedColorBackground);
            if(selectedColorBackground == null)
                selectedColorBackground = lastColorBackground;
            getDrawingContainerView().setCurrentColorBackground(selectedColorBackground);
            setBackground(selectedColorBackground);
            getStatusAreaView().editStatus("Background Color");
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
        setBackground(getDrawingContainerView().getDrawing().getCurrentComponentSelected().getBackgroundColor());
    }

    @Override
    public void onUnselected(){}
}
