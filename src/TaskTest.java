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
	
	@Test
	public void testStatesProgress() {
		Task t = new Task("name", "description");
		t.nextState();
		assertEquals(t.getState(), State.IN_PROGRESS);
		t.nextState();
		assertEquals(t.getState(), State.DONE);
		t.nextState();
		assertEquals(t.getState(), State.DONE);
	}
	
	@Test
	public void testSubTasks() {
		Task t = new Task("name", "description");
		
		assertNotNull(t.getSubTasks());
		t.addSubTask(new Task("abc", "def"));
		
		assertEquals(t.getSubTasks().size(), 1);
	}
	
	public void testTaskFinished() {
		Task t = new Task("finir ogl", "avant dimanche");
		assertFalse(t.isFinished());
		
		t.setState(State.DONE);
		assertTrue(t.isFinished());
		
		Task rootTask = new Task("root", "rootDescription");
		Task subTask1 = new Task("sub1", "sub1 desc");
		Task subTask2 = new Task("sub2", "sub2 desc");
		
		assertFalse(rootTask.isFinished());
		rootTask.setState(State.DONE);
		assertFalse(rootTask.isFinished());
		subTask1.setState(State.DONE);
		assertFalse(rootTask.isFinished());
		subTask2.setState(State.DONE);
	
		assertTrue(rootTask.isFinished());	
	}
	
	public void testToString(){
		Task t = new Task("finir ogl", "avant dimanche");
		t.setState(State.DONE);
		
		assertEquals(t.toString(),"Name: finir ogl \tState: DONE");
	}
}
