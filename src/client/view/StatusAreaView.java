package client.view;

import javax.swing.*;

public class StatusAreaView extends JTextArea {
    private String currentTool = "None";
    public StatusAreaView() {
        super();
        setText("[" + currentTool + "] " + "Tool selected");
        setEditable(false);
    }

    public void editStatus(String tool){
        currentTool = tool;
        setText("[" + currentTool + "] " + "Tool selected");
    }
}
