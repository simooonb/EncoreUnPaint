package client.view.tools;

public class ToolSelect extends Tool{

    public ToolSelect(){
        super("Select");
        addActionListener(e -> {
            getDrawingContainerView().setCurrentStatus("selection");
            getStatusAreaView().editStatus("Selection form");
        });
    }
}
