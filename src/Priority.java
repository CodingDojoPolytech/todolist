
public enum Priority {
	MINOR(1), MAJOR(2), BLOCKING(3), TRIVIAL(0);
	int prior;
	Priority(int i) {
		prior = i;
	}
}
