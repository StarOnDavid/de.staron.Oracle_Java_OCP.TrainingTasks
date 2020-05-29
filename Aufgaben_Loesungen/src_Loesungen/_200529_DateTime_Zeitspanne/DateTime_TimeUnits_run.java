package _200529_DateTime_Zeitspanne;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class DateTime_TimeUnits_run {
	private static int year = 2019;
	private static int month = 4;
	private static int dayOfMonth = 29;
	private static int hour = 11;
	private static int minute = 0, second = 0, nanoOfSecond = 0;

	public static void main(String[] args) {
//		a1();
//		a2();
		a3();
	}

	private static void a3() {
		year = 2018; month = 3; dayOfMonth = 25; hour = 1;
		
//		Set<String> tz = ZoneId.getAvailableZoneIds();
//		List<String> tzList = tz.stream().filter(s -> s.contains("Europe")).collect(Collectors.toList());
//		tzList.sort((a,b) -> a.compareTo(b));
//		tzList.forEach(System.out::println);
		
		ZoneId zone = ZoneId.of("Europe/Berlin");
		ZonedDateTime start = ZonedDateTime.of(year, month, dayOfMonth, hour, minute, second, nanoOfSecond, zone);
		hour = 4;
		ZonedDateTime end = ZonedDateTime.of(year, month, dayOfMonth, hour, minute, second, nanoOfSecond, zone);
		
		printStartEnd(start, end, "Begin", "End");
		
		long hours = ChronoUnit.HOURS.between(start, end);
		System.out.println("Duration: " + hours + "h");
		
		System.out.println("\nThe reason is that on 25 March 2018 in Germany the time was changed from winter to summer time.");
	}

	private static void a2() {
		System.out.println("*** A2 ");
		
		hour = 8;
		ZoneId zone = ZoneId.of("UTC+2");
		ZonedDateTime depature = ZonedDateTime.of(year, month, dayOfMonth, hour, minute, second, nanoOfSecond, zone);
		
		Duration d = Duration.of(3, ChronoUnit.HOURS);
		
		zone = ZoneId.of("UTC+1");
		ZonedDateTime arival = depature.plusHours(3).withZoneSameInstant(zone);
		
		
		printStartEnd(depature, arival, "Depature", "Arival");
	}

	private static void a1() {
		System.out.println("*** A1 ");
		
		hour = 12;
		ZoneId zone = ZoneId.of("UTC+1");
		ZonedDateTime depature = ZonedDateTime.of(year, month, dayOfMonth, hour, minute, second, nanoOfSecond, zone);
		
		hour = 16;
		zone = ZoneId.of("UTC+2");
		ZonedDateTime arival = ZonedDateTime.of(year, month, dayOfMonth, hour, minute, second, nanoOfSecond, zone);
		
		printStartEnd(depature, arival, "Depature", "Arival");
		
		long hours = ChronoUnit.HOURS.between(depature, arival);
		System.out.println("Duration: " + hours + "h");
		
	}

	private static void printStartEnd(ZonedDateTime start, ZonedDateTime end, String startMsg, String endMsg) {
		System.out.printf(startMsg + ": %02d:%02d / UTC%s \n" + endMsg + ":   %02d:%02d / UTC%s\n" ,
				start.getHour(), start.getMinute(), start.getOffset(),
				end.getHour(), end.getMinute(), end.getOffset());
	}
}
