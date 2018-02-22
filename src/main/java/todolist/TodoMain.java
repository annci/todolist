package todolist;

import java.util.NoSuchElementException;
import java.util.Scanner;

import todolist.Task.Prio;

public class TodoMain {
	private static Scanner scanner;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		TodoList todoList = new TodoList();
		boolean quit = true;
		System.out.println("Welcome to a todo list");
		while (quit) {
			System.out.println("Choose what to do.");
			System.out.println("a to add a task, d to delete, s to sort, q to quit");
			try {
				String cmd = scanner.next("[a, d, s, q]");
				switch (cmd) {
				case "a": 
					System.out.println("Description of activity:");
					Scanner actScan = new Scanner(System.in);
					String activity = actScan.nextLine();
					System.out.println("Prio? l = low, m = medium, h = high");
					String prio = scanner.next("[l, m, h]");
					switch (prio) {
					case "l": 
						todoList.add(new Task(activity, Prio.LOW));
						break;
					case "m":
						todoList.add(new Task(activity, Prio.MEDIUM));
						break;
					case "h":
						todoList.add(new Task(activity, Prio.HIGH));
						break;
					}
					break;
				case "d":
					System.out.println("Id to delete?");
					int id = scanner.nextInt();
					todoList.delete(id);
					break;
				case "s":
					todoList.sort();
					break;
				case "q":
					quit = false;
					break;
				default:
					System.out.println("Don't recognize command");
				}
			}
			catch (NoSuchElementException ne) {
				System.out.println("Don't recognize command");
			}
			todoList.print();
		}

		System.out.println("End");	
	}
}
