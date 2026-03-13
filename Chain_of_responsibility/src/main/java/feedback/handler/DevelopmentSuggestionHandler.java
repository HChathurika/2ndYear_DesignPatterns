package feedback.handler;

import feedback.model.Message;
import feedback.model.MessageType;

public class DevelopmentSuggestionHandler extends FeedbackHandler {

    @Override
    protected boolean canHandle(Message message) {
        return message.getType() == MessageType.DEVELOPMENT_SUGGESTION;
    }

    @Override
    protected String process(Message message) {
        return "Development suggestion from " + message.getSenderEmail()
                + " was logged and marked for product team review.";
    }
}