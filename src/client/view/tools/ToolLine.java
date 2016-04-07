package client.view.tools;


import client.view.DrawingContainerView;
import client.view.StatusAreaView;

public class ToolLine extends Tool{
    private String status = "line";

    public ToolLine(DrawingContainerView drawingContainerView, StatusAreaView statusAreaView){
        super("Line",drawingContainerView,statusAreaView);
        addActionListener(e -> {
            getDrawingContainerView().setCurrentStatus(status);
            getStatusAreaView().editStatus("Line");
        });
    }
}
