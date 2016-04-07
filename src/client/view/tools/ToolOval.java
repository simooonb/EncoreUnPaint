package client.view.tools;

import client.view.DrawingContainerView;
import client.view.StatusAreaView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolOval extends Tool{
    private String status = "oval";

    public ToolOval(DrawingContainerView drawingContainerView, StatusAreaView statusAreaView){
        super("Oval",drawingContainerView,statusAreaView);
        addActionListener(e -> {
            getDrawingContainerView().setCurrentStatus(status);
            getStatusAreaView().editStatus("Oval");
        });
    }
}
