package client.view.tools;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolRectangle extends Tool{
    private String status = "rectangle";

    public ToolRectangle(){
        super("Rectangle");
        addActionListener(e -> {
            getDrawingContainerView().setCurrentStatus(status);
            getStatusAreaView().editStatus("Rectangle");
        });
    }
}
