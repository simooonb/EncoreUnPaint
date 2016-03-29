package client.model;

public interface Action {
    void invoke();
    void undo();
}