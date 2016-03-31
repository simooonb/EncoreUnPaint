package client.view.drawingComponents;

import client.model.drawingComponents.LineComponent;

import java.awt.*;
import java.awt.geom.Line2D;

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
        super.update();
        repaint();
        revalidate();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(g instanceof Graphics2D){
            Graphics2D g2d = (Graphics2D) g;
            g2d.setPaint(line.getBackgroundColor());
            if(line.isSelected()){
                g2d.setStroke(new BasicStroke(3));
            }
            else
            {
                g2d.setStroke(new BasicStroke(1));
            }
            Point startingPoint;
            Point endingPoint;
            if(line.isInvertHeight() && line.isInvertWidth()){
                startingPoint = new Point(line.getSize().width,line.getSize().height);
                endingPoint = new Point(0,0);
            }
            else if(line.isInvertHeight()){
                startingPoint = new Point(0,line.getSize().height);
                endingPoint = new Point(line.getSize().width,0);
            }
            else if(line.isInvertWidth())
            {
                startingPoint = new Point(line.getSize().width, 0);
                endingPoint = new Point(0,line.getSize().height);
            }
            else
            {
                startingPoint = new Point(0,0);
                endingPoint = new Point(line.getSize().width,line.getSize().height);
            }
            g2d.draw(new Line2D.Float(startingPoint.x,startingPoint.y, endingPoint.x,endingPoint.y ));
        }
        g.dispose();
    }

    public LineComponent getLine() {
        return line;
    }

}
