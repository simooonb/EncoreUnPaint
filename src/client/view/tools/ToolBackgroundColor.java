package client.view.tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBackgroundColor extends Tool{
    private Color selectedColorBackground;

    public ToolBackgroundColor(){
        super();
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getDrawingContainerView().setCurrentStatus("backgroundColor");
                selectedColorBackground = JColorChooser.showDialog(null, "Choose a color", selectedColorBackground);
                getDrawingContainerView().setCurrentColorBackground(selectedColorBackground);
                setBackground(selectedColorBackground);
                getStatusAreaView().editStatus("Background Color");
            }
        });
    }
}
