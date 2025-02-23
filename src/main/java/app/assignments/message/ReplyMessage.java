package app.assignments.message;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ReplyMessage implements Message {

    private Message original;
    private String reply;

    public ReplyMessage(@Qualifier("pingMessage") Message original,@Value("Reply message") String reply) {
        this.original = original;
        this.reply = reply;
    }

    public String getSender() {
        return original.getRecipient();
    }

    public String getRecipient() {
        return original.getSender();
    }

    public String getText() {
        return "ORIGINAL:\n" + original.getText() + "\nREPLY:\n" + reply;
    }
}
