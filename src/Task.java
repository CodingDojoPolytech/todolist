
public class Task {
	// nom
	private String name;
	// description
	private String description;
	private State state;
	
	// constructeur
	public Task(String name, String description) {
		this.name = name;
		this.description = description;
		this.state = State.TODO;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String toString(){
		return "";
	}
}
