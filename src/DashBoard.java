import java.util.List;


public class DashBoard {

	private List<Task> taskList;
	
	public DashBoard(List<Task> taskList) {
		this.taskList = taskList;			
	}
	
	public List<Task> getTaskList() {
		return taskList;
	}
	
	public void addTask(Task task){
		taskList.add(task);
	}
	
	public void checkCritical(){
		for(Task t : taskList){
			
		}
	}
	
	private void checkSubCritical(Task t){
	for(Task sub : t.getSubTasks()){
				checkSubCritical(sub);
			}
		}
	
	public String subTask(Task t){
		String res="";
		if(t.getSubTasks().size()!=0){
			for (Task ta : t.getSubTasks()){
				res+="\t"+subTask(ta);
			}
		}
		return res;
	}
	
	//TODO A TESTER (on sait pas faire)
	public String toString(){
		String res="";
		for (Task t : taskList) {
			res+=t.toString();
			res+=this.subTask(t);
		}
		return res;
	}
	
}
