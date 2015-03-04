import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
	public void testPriorityMinor(){
		Task t = new Task("name", "desc");
		assertEquals(t.getPriority(), Priority.MAJOR);

		t.setPriority(Priority.MINOR);
		assertEquals(t.getPriority(), Priority.MINOR);
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
	@Test
	public void testCompareTo(){
		Task t = new Task("finir ogl", "avant dimanche");
		t.setPriority(Priority.MAJOR);
		Task t2 = new Task("finir ogl", "avant dimanche");
		t2.setPriority(Priority.MINOR);
		assertTrue(t.compareTo(t2)>0);
	}
	public void testToString(){
		Task t = new Task("finir ogl", "avant dimanche");
		t.setState(State.DONE);
		
		assertEquals(t.toString(),"Name: finir ogl \tState: DONE");
	}
	@Test
	public void getListCriticalTest(){
		List<Task> t = new ArrayList<Task>();
		Task t1 = new Task("block", "avant dimanche");
		t1.setPriority(Priority.BLOCKING);
		Task t2 = new Task("ffff", "block");
		t.add(t1);
		t.add(t2);
		DashBoard d = new DashBoard(t);
		assertEquals(d.getListCriticalTasks().get(0).getName(), "block");
		
	}
}
