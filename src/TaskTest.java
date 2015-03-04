import static org.junit.Assert.*;

import org.junit.Test;


public class TaskTest {
	
	@Test
	public void testConstructor() {
		Task t = new Task("name", "description");
		assertTrue(t!=null);
		assertTrue(t.getName().equals("name"));
		assertTrue(t.getDescription().equals("description"));
	}

}
