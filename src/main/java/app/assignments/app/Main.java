package app.assignments.app;

import app.assignments.message.CustomMessage;
import app.assignments.message.Message;
import app.assignments.message.PingMessage;
import app.assignments.writer.ListWriter;
import app.assignments.writer.StdoutWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

    public static void main(String[] args) {


        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/application-context.xml");

        Message ping =applicationContext.getBean(PingMessage.class);
        Message hello =  applicationContext.getBean(CustomMessage.class);
        Message pingReply = applicationContext.getBean(PingMessage.class);

        StdoutWriter stdoutWriter =  applicationContext.getBean(StdoutWriter.class);
        ListWriter listWriter =  applicationContext.getBean(ListWriter.class);
        stdoutWriter.write(ping);
        stdoutWriter.write(hello);
        stdoutWriter.write(pingReply);

        listWriter.write(ping);
        listWriter.listWrittenMessages().forEach(stdoutWriter::write);

    }

}
