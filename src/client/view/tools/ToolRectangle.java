package client.view.tools;


import client.view.DrawingContainerView;
import client.view.StatusAreaView;

public class ToolRectangle extends Tool{
    private String status = "rectangle";

    public ToolRectangle(DrawingContainerView drawingContainerView, StatusAreaView statusAreaView){
        super("Rectangle",drawingContainerView, statusAreaView);
        addActionListener(e -> {
            getDrawingContainerView().setCurrentStatus(status);
            getStatusAreaView().editStatus("Rectangle");
        });
    }
}
