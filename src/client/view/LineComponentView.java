package client.view;

import client.model.LineComponent;

import java.awt.*;

public class LineComponentView extends DrawingComponentView {
    private LineComponent line;

    public LineComponentView(LineComponent line) {
        super(line);
        this.line = line;
        update();
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
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
