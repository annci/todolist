package todolist;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * A todo list
 * @author annci
 *
 */
public class TodoList {
	private PrioComp comp = new PrioComp();
	Map<Integer, Task> todoMap = new HashMap<Integer, Task>();

	
	/**
	 * Adds a task to this todo list
	 * @param task
	 */
	public void add(Task task) {
		todoMap.put(task.getId(), task);
	}
	
	/**
	 * Removes a task from this todo list
	 * @param index
	 */
	public void delete(int index) {
		todoMap.remove(index);		
	}
	
	/**
	 * Sorting this todo list
	 */
	public void sort() {		
		todoMap = todoMap.entrySet().stream()
			.sorted(Map.Entry.comparingByValue(comp))
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}
		
	/**
	 * Prints this todo list on stdout
	 */
    public void print() {
        System.out.println("Todo list:");
        for (Task t : todoMap.values()) {
        	System.out.println(t.getId() + " Activity: "  + t.getActivity() +  " Prio: " + t.getPrio());
        }
    }
    
    /**
     * Comparator to sort this todo list on prio
     * @author annci
     *
     */
	private class PrioComp implements Comparator<Task> {
	    public int compare(Task t1, Task t2) {
	        return (t1.getPrio().compareTo(t2.getPrio()));
	    }
	}

}
