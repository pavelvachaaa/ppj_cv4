package app.assignments.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("pingMessageReply")
public class ReplyMessage implements Message {

    private final Message original;
    private final String reply;

    @Autowired
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
