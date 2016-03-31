package client.model.action;

import java.util.Objects;
import java.util.Stack;

public class ActionStack {
    private Stack<Action> actionStack = new Stack<>();
    private Stack<Action> redoStack = new Stack<>();

    public void push(Action action) {
        if (!isRedoStackEmpty() && !Objects.equals(action, redoStack.peek())) {
            redoStack = new Stack<>();
        }

        actionStack.push(action);
        action.invoke();
    }

    public Action pop() {
        if (!isActionStackEmpty()) {
            Action action = actionStack.pop();
            redoStack.push(action);
            action.undo();
            return action;
        } else {
            return null;
        }
    }

    public Action redo() {
        if (!isRedoStackEmpty()) {
            Action action = redoStack.pop();
            actionStack.push(action);
            action.invoke();
            return action;
        } else {
            return null;
        }
    }

    public Action peek() {
        return actionStack.peek();
    }

    private boolean isActionStackEmpty() {
        return actionStack.isEmpty();
    }

    private boolean isRedoStackEmpty() {
        return redoStack.isEmpty();
    }
}