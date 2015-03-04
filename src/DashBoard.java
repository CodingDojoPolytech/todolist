import java.util.ArrayList;
import java.util.List;


public class DashBoard {

	private List<Task> taskList;
	private MessageSender sender;
	
	public DashBoard(List<Task> taskList) {
		this.taskList = taskList;
		this.sender = new MessageSender();
	}
	
	public List<Task> getTaskList() {
		return taskList;
	}
	
	public void addTask(Task task){
		taskList.add(task);
	}
	
	public List<Task> getListCriticalTasks(){
		List<Task> critic = new ArrayList<Task>();
		for(Task t : taskList){
			if(t.isCritical()){
				critic.add(t);
			}
		}
		return critic;
	}
	
	public void sendCriticalTasksMessage() {
		List<Task> criticalTasks = getListCriticalTasks();
		if (criticalTasks.size() > 0) {
			StringBuilder sb = new StringBuilder();
			
			for(Task t : criticalTasks) {
				sb.append("Critic task:").append(t.toString());
			}
			
			sender.sendMessage(sb.toString());
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

	public MessageSender getMessageSender() {
		return sender;
	}
	
}
