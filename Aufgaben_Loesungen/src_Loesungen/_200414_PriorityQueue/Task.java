package _200414_PriorityQueue;

import java.time.LocalDate;

public class Task implements Comparable<Task>{
	private LocalDate date;
	private Priority priority;
	private String discription;
	
	public Task(String discription, Priority prio, LocalDate date) {
		this.discription = discription;
		this.priority = prio;
		this.date = date;
	}

	

	@Override
	public int compareTo(Task t) {
		if(!this.date.isEqual(t.date)) {
			if(this.date.isBefore(t.date))
				return -1;
			if(this.date.isAfter(t.date))
				return 1;
		} else {
			switch (priority) {
			case LOW:
				return 1;
			case NORMAL:
				return 0;
			case HIGH:
				return -1;
			}
		}
		return 0;
	}
	
	
	
	@Override
	public String toString() {
		return date + " Task: " + discription + " " +  priority.toString() ;
	}



	public static enum Priority {
		LOW, NORMAL, HIGH;
	} 
}
