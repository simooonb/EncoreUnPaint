package client.view.tools;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolLine extends Tool{
    public ToolLine(){
        super("Line");
        addActionListener(e -> {
            getDrawingContainerView().setCurrentStatus("line");
            getStatusAreaView().editStatus("Line");
        });
    }
}
