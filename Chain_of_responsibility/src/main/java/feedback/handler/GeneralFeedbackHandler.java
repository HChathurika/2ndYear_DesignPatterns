package feedback.handler;

import feedback.model.Message;
import feedback.model.MessageType;

public class GeneralFeedbackHandler extends FeedbackHandler {

    @Override
    protected boolean canHandle(Message message) {
        return message.getType() == MessageType.GENERAL_FEEDBACK;
    }

    @Override
    protected String process(Message message) {
        return "General feedback from " + message.getSenderEmail()
                + " was analyzed and a thank-you response was prepared.";
    }
}