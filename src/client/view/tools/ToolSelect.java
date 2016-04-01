package client.view.tools;

public class ToolSelect extends Tool{
    private String status = "selection";

    public ToolSelect(){
        super("Select");
        addActionListener(e -> {
            getDrawingContainerView().setCurrentStatus(status);
            getStatusAreaView().editStatus("Selection form");
        });
    }
}
