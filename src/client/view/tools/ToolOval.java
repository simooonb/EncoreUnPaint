package client.view.tools;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolOval extends Tool{
    private String status = "oval";

    public ToolOval(){
        super("Oval");
        addActionListener(e -> {
            getDrawingContainerView().setCurrentStatus(status);
            getStatusAreaView().editStatus("Oval");
        });
    }
}
