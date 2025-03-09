package app.assignments.writer;

import app.assignments.message.Message;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component("listWriter")
public class ListWriter implements Writer {

    private List<Message> buffer = new ArrayList<>();

    public void init() {
        buffer = new ArrayList<>();
        System.out.println("ListWriter initialized with an empty buffer.");
    }


    public void write(Message message) {
        buffer.add(message);
    }

    public List<Message> listWrittenMessages() {
        return Collections.unmodifiableList(buffer);
    }
}
