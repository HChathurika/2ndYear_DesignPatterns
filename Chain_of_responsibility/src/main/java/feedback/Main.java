package feedback;

import feedback.handler.CompensationClaimHandler;
import feedback.handler.ContactRequestHandler;
import feedback.handler.DevelopmentSuggestionHandler;
import feedback.handler.FeedbackHandler;
import feedback.handler.GeneralFeedbackHandler;
import feedback.model.Message;
import feedback.model.MessageType;

public class Main {

    public static void main(String[] args) {
        FeedbackHandler compensationHandler = new CompensationClaimHandler();
        FeedbackHandler contactHandler = new ContactRequestHandler();
        FeedbackHandler developmentHandler = new DevelopmentSuggestionHandler();
        FeedbackHandler generalHandler = new GeneralFeedbackHandler();

        compensationHandler.setNextHandler(contactHandler);
        contactHandler.setNextHandler(developmentHandler);
        developmentHandler.setNextHandler(generalHandler);

        Message[] messages = {
                new Message(
                        MessageType.COMPENSATION_CLAIM,
                        "My order arrived damaged and I want compensation.",
                        "alice@example.com"
                ),
                new Message(
                        MessageType.CONTACT_REQUEST,
                        "Please contact me about my subscription issue.",
                        "bob@example.com"
                ),
                new Message(
                        MessageType.DEVELOPMENT_SUGGESTION,
                        "It would be great to add dark mode to the app.",
                        "charlie@example.com"
                ),
                new Message(
                        MessageType.GENERAL_FEEDBACK,
                        "Your service was very easy to use. Thank you.",
                        "diana@example.com"
                )
        };

        for (Message message : messages) {
            System.out.println("----- NEW MESSAGE -----");
            System.out.println("Type: " + message.getType());
            System.out.println("Sender: " + message.getSenderEmail());
            System.out.println("Content: " + message.getContent());
            System.out.println("Result: " + compensationHandler.handle(message));
            System.out.println();
        }
    }
}