package client.model.action;

public interface Action {
    void invoke();
    void undo();
}