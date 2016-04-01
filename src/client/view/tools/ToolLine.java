package client.view.tools;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolLine extends Tool{
    private String status = "line";

    public ToolLine(){
        super("Line");
        addActionListener(e -> {
            getDrawingContainerView().setCurrentStatus(status);
            getStatusAreaView().editStatus("Line");
        });
    }
}
