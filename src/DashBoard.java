import java.util.List;


public class DashBoard {

	private List<Task> taskList;
	
	public DashBoard(List<Task> taskList) {
		this.taskList = taskList;			
	}
	
	
	public void addTask(Task task){
		taskList.add(task);
	}
	
}
