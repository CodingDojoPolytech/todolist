import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class DashBoardTest {

	@Test
	public void testConstructor() {
		DashBoard db = new DashBoard(null);
		assertNull(db.getTaskList());
	}
	
	@Test 
	public void testCriticalMessage() {
		DashBoard db = new DashBoard(new ArrayList<Task>());
		MessageSender ms = db.getMessageSender();
		
		assertEquals(0, ms.getSentMessages());
		
		Task critical = new Task("critical", "task");
		critical.setPriority(Priority.BLOCKING);
		db.addTask(critical);
		db.sendCriticalTasksMessage();
		assertEquals(1, ms.getSentMessages());
	}

}
