package client.view;

import client.model.OvalComponent;

public class OvalComponentView extends DrawingComponentView {
    private OvalComponent oval;

    public OvalComponentView(OvalComponent oval) {
        super(oval);
        this.oval = oval;
        setOpaque(false);
        update();
    }

    @Override
    public void update() {
        super.update();
    }

    public OvalComponent getOval() {
        return oval;
    }

    public void setOval(OvalComponent oval) {
        this.oval = oval;
    }
}
