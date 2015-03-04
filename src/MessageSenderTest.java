import static org.junit.Assert.*;

import org.junit.Test;


public class MessageSenderTest {

	@Test
	public void test() {
		MessageSender sender = new MessageSender();
		assertEquals(sender.getSentMessages(), 0);
		sender.sendMessage("this is a message");
		assertEquals(sender.getSentMessages(), 1);
	}

}
