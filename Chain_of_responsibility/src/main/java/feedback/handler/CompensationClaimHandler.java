package feedback.handler;

import feedback.model.Message;
import feedback.model.MessageType;

public class CompensationClaimHandler extends FeedbackHandler {

    @Override
    protected boolean canHandle(Message message) {
        return message.getType() == MessageType.COMPENSATION_CLAIM;
    }

    @Override
    protected String process(Message message) {
        return "Compensation claim from " + message.getSenderEmail()
                + " was reviewed and forwarded for approval.";
    }
}