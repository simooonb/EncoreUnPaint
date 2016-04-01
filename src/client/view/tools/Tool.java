package client.view.tools;

import client.view.DrawingContainerView;
import client.view.StatusAreaView;

import javax.swing.*;

public abstract class Tool extends JButton{

    private DrawingContainerView drawingContainerView;
    private StatusAreaView statusAreaView;

    public Tool(){
        super();
    }
    public Tool(String title){
        super(title);
    }

    public DrawingContainerView getDrawingContainerView() {
        return drawingContainerView;
    }

    public StatusAreaView getStatusAreaView() {
        return statusAreaView;
    }
}
