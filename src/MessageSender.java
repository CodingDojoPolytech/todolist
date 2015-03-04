
public class MessageSender {

	private int sentMessages = 0;
	
	public int getSentMessages() {
		return sentMessages;
	}

	public void sendMessage(String msg) {
		sentMessages++;
		System.out.println("Message sent: "+ msg);
	}
	
}
