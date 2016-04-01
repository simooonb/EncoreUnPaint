package client.view.tools;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolOval extends Tool{
    public ToolOval(){
        super("Oval");
        addActionListener(e -> {
            getDrawingContainerView().setCurrentStatus("oval");
            getStatusAreaView().editStatus("Oval");
        });
    }
}
