package client.view.tools;

import client.view.DrawingContainerView;
import client.view.StatusAreaView;

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
