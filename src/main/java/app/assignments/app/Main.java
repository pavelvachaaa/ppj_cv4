package app.assignments.app;

import app.assignments.message.CustomMessage;
import app.assignments.message.Message;
import app.assignments.message.PingMessage;
import app.assignments.writer.ListWriter;
import app.assignments.writer.StdoutWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("app.assignments")
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        Message ping = context.getBean(PingMessage.class);
        Message hello = context.getBean("helloMessage", Message.class);
        Message pingReply = context.getBean("pingMessageReply", Message.class);

        StdoutWriter stdoutWriter = context.getBean(StdoutWriter.class);
        ListWriter listWriter = context.getBean(ListWriter.class);

        stdoutWriter.write(ping);
        stdoutWriter.write(hello);
        stdoutWriter.write(pingReply);

        listWriter.write(ping);
        listWriter.listWrittenMessages().forEach(stdoutWriter::write);
    }
}