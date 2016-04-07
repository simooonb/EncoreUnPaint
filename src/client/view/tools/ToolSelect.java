package client.view.tools;

import client.view.DrawingContainerView;
import client.view.StatusAreaView;

public class ToolSelect extends Tool{
    private String status = "selection";

    public ToolSelect(DrawingContainerView drawingContainerView, StatusAreaView statusAreaView){
        super("Select",drawingContainerView,statusAreaView);
        addActionListener(e -> {
            getDrawingContainerView().setCurrentStatus(status);
            getStatusAreaView().editStatus("Selection form");
        });
    }
}
