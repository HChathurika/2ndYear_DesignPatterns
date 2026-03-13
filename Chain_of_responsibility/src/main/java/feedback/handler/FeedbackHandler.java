package feedback.handler;

import feedback.model.Message;

public abstract class FeedbackHandler {
    protected FeedbackHandler nextHandler;

    public void setNextHandler(FeedbackHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public String handle(Message message) {
        if (canHandle(message)) {
            return process(message);
        } else if (nextHandler != null) {
            return nextHandler.handle(message);
        }
        return "No handler found for message type: " + message.getType();
    }

    protected abstract boolean canHandle(Message message);

    protected abstract String process(Message message);
}