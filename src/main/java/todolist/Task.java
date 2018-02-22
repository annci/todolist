package todolist;

/**
 * A todo task
 * @author annci
 *
 */
public class Task {
	static int nextId;
	
	private Prio prio;
	private String activity;
	private final int id;
	
	/**
	 * Todo task
	 * 
	 * @param activity
	 * @param prio
	 */
	public Task(String activity, Prio prio) {
		this.prio = prio;
		this.activity = activity;
		this.id = nextId++;
	}

	/**
	 * Get this task's prio
	 * @return
	 */
	Prio getPrio() {
		return prio;
	}

	/**
	 * Set this task's prio
	 * @param prio
	 */
	void setPrio(Prio prio) {
		this.prio = prio;
	}

	/**
	 * Get what this task is about
	 * @return String
	 */
	String getActivity() {
		return activity;
	}

	/**
	 * Set what this task is about
	 * @param activity
	 */
	void setActivity(String activity) {
		this.activity = activity;
	}

	/**
	 * Get this task's id
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * The priority a task can have
	 * @author annci
	 *
	 */
	enum Prio {
		LOW,
		MEDIUM,
		HIGH
	}
}
