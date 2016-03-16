package client.view;

import javax.swing.*;
import java.awt.*;

public class ToolbarView extends JToolBar{
    private JButton selectForm;
    private JButton fillForm;
    private JButton drawOval;
    private JButton drawRectangle;
    private JButton drawLine;
    private JPanel buttonPanel;
    private JButton foregroundColorChooser;
    private JButton backgroundColorChooser;

    public ToolbarView(){
        super(null, JToolBar.VERTICAL);
        this.setFloatable(true);
        this.setRollover(true);
        this.setBorderPainted(true);
        initButton();
        this.add(selectForm);
        this.addSeparator();
        this.add(fillForm);
        this.addSeparator();
        this.add(drawOval);
        this.addSeparator();
        this.add(drawRectangle);
        this.addSeparator();
        this.add(drawLine);
        this.addSeparator();
        this.add(buttonPanel);
    }

    private void initButton(){
        selectForm = new JButton("Select");
        fillForm = new JButton("Fill");
        drawOval = new JButton("Oval");
        drawRectangle = new JButton("Rectangle");
        drawLine = new JButton("Line");
        buttonPanel = new JPanel();
        foregroundColorChooser = new JButton();
        foregroundColorChooser.setPreferredSize(new Dimension(40,40));
        foregroundColorChooser.setMaximumSize(foregroundColorChooser.getPreferredSize());
        foregroundColorChooser.setMinimumSize(foregroundColorChooser.getPreferredSize());
        foregroundColorChooser.setBackground(Color.BLACK);
        backgroundColorChooser = new JButton();
        backgroundColorChooser.setPreferredSize(new Dimension(40,40));
        backgroundColorChooser.setMaximumSize(backgroundColorChooser.getPreferredSize());
        backgroundColorChooser.setMinimumSize(backgroundColorChooser.getPreferredSize());
        backgroundColorChooser.setBackground(Color.BLACK);
        buttonPanel.add(backgroundColorChooser);
        buttonPanel.add(foregroundColorChooser);
    }
    
    public JButton getSelectForm() { return selectForm; }

    public JButton getFillForm() { return fillForm; }

    public JButton getDrawOval() { return drawOval; }

    public JButton getDrawRectangle() { return drawRectangle; }

    public JButton getDrawLine() { return drawLine; }

    public JButton getForegroundColorChooser() { return foregroundColorChooser; }

    public JButton getBackgroundColorChooser() { return backgroundColorChooser; }
}
