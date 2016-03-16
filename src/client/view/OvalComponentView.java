package client.view;

import client.model.OvalComponent;

public class OvalComponentView extends DrawingComponentView {
    private OvalComponent oval;

    public OvalComponentView() {

    }

    public OvalComponent getOval() {
        return oval;
    }

    public void setOval(OvalComponent oval) {
        this.oval = oval;
    }
}
