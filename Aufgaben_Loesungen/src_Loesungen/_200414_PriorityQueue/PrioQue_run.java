package _200414_PriorityQueue;

import java.time.LocalDate;
import java.util.Date;
import java.util.PriorityQueue;

import _200414_PriorityQueue.Task.Priority;

public class PrioQue_run {

	public static void main(String[] args) {
		PriorityQueue<Task> q = new PriorityQueue<>();
		q.add(new Task("Autowäsche", Priority.LOW, LocalDate.of(2020, 04, 20)));
		q.add(new Task("Rechnungen bezahlen", Priority.HIGH, LocalDate.of(2020, 04, 20)));
		q.add(new Task("Einkaufen", Priority.NORMAL, LocalDate.of(2020, 04, 20)));
		q.add(new Task("Garten arbeit", Priority.LOW, LocalDate.of(2020, 04, 21)));
		q.add(new Task("Oma anrufen", Priority.HIGH, LocalDate.of(2020, 04, 21)));
		
		while(!q.isEmpty())
			System.out.println(q.poll());
	}
}
