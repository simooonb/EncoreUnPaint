package client.view;

import client.model.RectangleComponent;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class RectangleComponentView extends DrawingComponentView {
    private RectangleComponent rectangle;

    public RectangleComponentView(RectangleComponent rectangle) {
        super(rectangle);
        this.rectangle = rectangle;
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
            System.out.println("rect view");
            Graphics2D g2d = (Graphics2D) g;
            g2d.setPaint(rectangle.getBackgroundColor());
            if(rectangle.isSelected()){
                System.out.println("rectangle selected");
                g2d.setStroke(new BasicStroke(10));
            } else {
                g2d.setStroke(new BasicStroke(3));
            }
            Rectangle boundingBox = rectangle.getBoundingBox();
            g2d.fill(new Rectangle2D.Float(0,0, boundingBox.width-1, boundingBox.height-1));
            g2d.setPaint(rectangle.getForegroundColor());
            g2d.draw(new Rectangle2D.Float(0,0,boundingBox.width-2, boundingBox.height-2));
        }
    }

    public RectangleComponent getRectangle() {
        return rectangle;
    }

    public void setRectangle(RectangleComponent rectangle) {
        this.rectangle = rectangle;
    }
}
