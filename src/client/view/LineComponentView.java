package client.view;

import client.model.LineComponent;

import java.awt.*;

public class LineComponentView extends DrawingComponentView {
    private LineComponent line;

    public LineComponentView(LineComponent line) {
        super(line);
        this.line = line;
        setOpaque(false);
        update();
    }

    @Override
    public void update() {
        System.out.println("lineview update");
        super.update();
        repaint();
        revalidate();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("lineview paintcomponent");
        g.setColor(line.getColor());
        g.drawLine(line.getFirstPoint().x, line.getFirstPoint().y, line.getSecondPoint().x, line.getSecondPoint().y);
    }

    public LineComponent getLine() {
        return line;
    }

    public void setLine(LineComponent line) {
        this.line = line;
    }
}
