package _200409_Set_Abfahrtzeiten;

import java.util.TreeSet;

public class Departures {

	public static TreeSet<String> generateAsString(int startHour, int startMinute, int endHour, int endMinute, int intervalInMinutes) {
		TreeSet<String> departures = new TreeSet<>();
		while(startHour < endHour || (startHour==endHour && startMinute < endMinute+1 )) {
			departures.add(String.format("%02d:%02d", startHour, startMinute));
			startMinute += intervalInMinutes;
			if(startMinute >= 60) {
				startHour++;
				startMinute -= 60;
			}
		}
		return departures;
	}
}
