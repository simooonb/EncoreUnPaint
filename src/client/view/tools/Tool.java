package client.view.tools;

import client.view.DrawingContainerView;
import client.view.StatusAreaView;

import javax.swing.*;

public abstract class Tool extends JButton{

    private DrawingContainerView drawingContainerView;
    private StatusAreaView statusAreaView;

    public Tool(DrawingContainerView drawingContainerView, StatusAreaView statusAreaView){
        this("",drawingContainerView,statusAreaView);
    }
    public Tool(String title, DrawingContainerView drawingContainerView, StatusAreaView statusAreaView){
        super(title);
        this.drawingContainerView = drawingContainerView;
        this.statusAreaView = statusAreaView;
    }

    public DrawingContainerView getDrawingContainerView() {
        return drawingContainerView;
    }

    public StatusAreaView getStatusAreaView() {
        return statusAreaView;
    }
}
