import java.util.ArrayList;
import java.util.List;


//Implements Comparable 
public class Task implements Comparable<Task>{
	// nom
	private String name;
	// description
	private String description;
	private State state;
	private List<Task> subTasks = new ArrayList<>();
	//Priority
	private Priority priority;
	
	// constructeur
	public Task(String name, String description) {
		this.name = name;
		this.description = description;
		this.state = State.TODO;
		this.priority = Priority.MAJOR;
	}

	public State getState() {
		return state;
	}
	//TODO ordre dans les states
	public void setState(State state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void nextState() {
		switch(state) {
		case DONE:
			state = State.DONE;
			break;
		case IN_PROGRESS:
			state = State.DONE;
			break;
		case TODO:
			state = State.IN_PROGRESS;
			break;
		default:
			throw new RuntimeException("State not handled");
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString(){
		return "Name: "+name
				+"\tState: "+state;
	}
	
	public String tolongString(){
		return toString()
				+"\tDescription: "+description;
	}

	public List<Task> getSubTasks() {
		return subTasks;
	}

	public void setSubTasks(List<Task> subTasks) {
		this.subTasks = subTasks;
	}

	public void addSubTask(Task task) {
		this.subTasks.add(task);
	}
	
	public boolean isFinished() {
		boolean subTasksFinished = true;
		for(Task t: subTasks) {
			if (! t.isFinished()) subTasksFinished = false;
		}
		return state == State.DONE && subTasksFinished;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	@Override
	public int compareTo(Task o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
