package client.view.tools;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolRectangle extends Tool{

    public ToolRectangle(){
        super("Rectangle");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getDrawingContainerView().setCurrentStatus("rectangle");
                getStatusAreaView().editStatus("Rectangle");
            }
        });
    }
}
