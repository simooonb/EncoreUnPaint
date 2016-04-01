package client.view.tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolForegroundColor extends Tool{
    private Color selectedColorForeground;

    public ToolForegroundColor(){
        super();
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getDrawingContainerView().setCurrentStatus("foregroundColor");
                selectedColorForeground = JColorChooser.showDialog(null, "Choose a color", selectedColorForeground);
                getDrawingContainerView().setCurrentColorForeground(selectedColorForeground);
                setBackground(selectedColorForeground);
                getStatusAreaView().editStatus("Foreground Color");
            }
        });
    }
}
