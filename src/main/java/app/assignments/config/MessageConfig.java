package app.assignments.config;

import app.assignments.message.CustomMessage;
import app.assignments.message.Message;
import app.assignments.message.PingMessage;
import app.assignments.message.ReplyMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MessageConfig {

    @Bean
    @Scope("prototype")
    public PingMessage pingMessage() {
        return new PingMessage();
    }

    @Bean(name = "helloMessage")
    @Scope("singleton")
    public CustomMessage customMessage() {
        CustomMessage message = new CustomMessage();
        message.setSender("Pavel");
        message.setRecipient("Lukáš");
        message.setText("Proč si to dělám");
        return message;
    }

    @Bean(name = "pingMessageReply")
    public ReplyMessage replyMessage() {
        return new ReplyMessage(pingMessage(), "Odpověď jak se patřís");
    }
}