package client.view.tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBackgroundColor extends Tool{
    private Color selectedColorBackground;
    private String status = "backgroundColor";

    public ToolBackgroundColor(){
        super();
        addActionListener(e -> {
            getDrawingContainerView().setCurrentStatus(status);
            selectedColorBackground = JColorChooser.showDialog(null, "Choose a color", selectedColorBackground);
            getDrawingContainerView().setCurrentColorBackground(selectedColorBackground);
            setBackground(selectedColorBackground);
            getStatusAreaView().editStatus("Background Color");
        });
    }
}
