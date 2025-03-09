import app.assignments.app.Main;
import app.assignments.message.CustomMessage;
import app.assignments.message.Message;
import app.assignments.message.PingMessage;
import app.assignments.message.ReplyMessage;
import app.assignments.writer.ListWriter;
import app.assignments.writer.StdoutWriter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Main.class)
public class SpringConfigurationTest {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private PingMessage pingMessage;

    @Autowired
    @Qualifier("helloMessage")
    private Message customMessage;

    @Autowired
    @Qualifier("pingMessageReply")
    private Message replyMessage;

    @Autowired
    private StdoutWriter stdoutWriter;

    @Autowired
    private ListWriter listWriter;

    @Test
    public void testBeansExistence() {
        Assert.assertNotNull(pingMessage);
        Assert.assertNotNull(customMessage);
        Assert.assertNotNull(replyMessage);
        Assert.assertNotNull(stdoutWriter);
        Assert.assertNotNull(listWriter);
    }

    @Test
    public void testPingMessageScope() {
        PingMessage anotherPing = context.getBean(PingMessage.class);
        Assert.assertNotSame("PingMessage should be prototype scoped", pingMessage, anotherPing);
    }

    @Test
    public void testCustomMessageScope() {
        Message anotherCustom = context.getBean("helloMessage", Message.class);
        Assert.assertSame("CustomMessage should be singleton scoped", customMessage, anotherCustom);
    }

    @Test
    public void testReplyMessage() {
        Assert.assertEquals("pong", replyMessage.getSender());
        Assert.assertEquals("ping", replyMessage.getRecipient());
        Assert.assertTrue(replyMessage.getText().contains("ORIGINAL") && replyMessage.getText().contains("REPLY"));
    }
}