package feedback.handler;

import feedback.model.Message;
import feedback.model.MessageType;

public class ContactRequestHandler extends FeedbackHandler {

    @Override
    protected boolean canHandle(Message message) {
        return message.getType() == MessageType.CONTACT_REQUEST;
    }

    @Override
    protected String process(Message message) {
        return "Contact request from " + message.getSenderEmail()
                + " was forwarded to the customer service department.";
    }
}