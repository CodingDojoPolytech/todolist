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
	
	@Test
	public void testStateTodo(){
		Task t = new Task("name", "description");
		assertEquals(t.getState(), State.TODO);
	}
	
	@Test
	public void testStateInProgress(){
		Task t = new Task("name", "description");
		t.setState(State.IN_PROGRESS);
		assertEquals(t.getState(), State.IN_PROGRESS);
	}
	

}
