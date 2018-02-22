package todolist;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import todolist.Task.Prio;

public class TestTodoList {
	
	private TodoList todoList;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		todoList = new TodoList();
		
		todoList.add(new Task("olle", Prio.HIGH));
		todoList.add(new Task("kalle", Prio.LOW));
		todoList.add(new Task("erik", Prio.MEDIUM));
		todoList.add(new Task("sven", Prio.HIGH));
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		Task.nextId = 0;
	}


	@Test
	public void testSort() {	
		todoList.sort();
		
		assertEquals(todoList.todoMap.size(), 4);
		List<Integer> result = new ArrayList(todoList.todoMap.keySet());
		assertThat(result, CoreMatchers.hasItems(1, 2, 0, 3));
	}
	
	@Test
	public void testDelete() {
		todoList.delete(1);
						
		assertEquals(todoList.todoMap.size(), 3);
	}

	@Test
	public void testAdd() {
		todoList.add(new Task("Greta hoppar", Prio.LOW));
				
		assertEquals(todoList.todoMap.size(), 5);
	}

}
