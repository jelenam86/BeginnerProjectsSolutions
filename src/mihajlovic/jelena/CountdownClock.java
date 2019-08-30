package mihajlovic.jelena;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

public class CountdownClock {

	/*
	 * Create a program that allows the user to choose a time and date, and then
	 * prints out a message at given intervals (such as every second) that tells the
	 * user how much longer there is until the selected time.
	 * 
	 * Subgoals: If the selected time has already passed, have the program tell the
	 * user to start over. If your program asks for the year, month, day, hour, etc.
	 * separately, allow the user to be able to type in either the month name or its
	 * number.
	 * 
	 * TIP: Making use of built in modules such as time and datetime can change this
	 * project from a nightmare into a much simpler task.
	 */

	private static LocalDateTime ldt;

	public static void main(String[] args) throws InterruptedException {

		Scanner scanner = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String answer = "";

		do {
			LocalDateTime now = LocalDateTime.now();
			ldt = now;
			answer = "no";
			ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
			Runnable task = () -> {
				ldt = ldt.plusSeconds(1L);
			};
			ScheduledFuture<?> scheduledFuture = ses.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);

			System.out.print("Enter date and time in format \"yyyy-MM-dd HH:mm:ss\": ");
			String user = scanner.nextLine();
			try {
				LocalDateTime dateTime = LocalDateTime.parse(user, formatter);
				if (dateTime.isBefore(now))
					System.out.println("The selected time has already passed. Start over.");
				else {
					while (true) {
						LocalDateTime tempDateTime = LocalDateTime.from(ldt);

						long years = tempDateTime.until(dateTime, ChronoUnit.YEARS);
						tempDateTime = tempDateTime.plusYears(years);
						long months = tempDateTime.until(dateTime, ChronoUnit.MONTHS);
						tempDateTime = tempDateTime.plusMonths(months);
						long days = tempDateTime.until(dateTime, ChronoUnit.DAYS);
						tempDateTime = tempDateTime.plusDays(days);
						long hours = tempDateTime.until(dateTime, ChronoUnit.HOURS);
						tempDateTime = tempDateTime.plusHours(hours);
						long minutes = tempDateTime.until(dateTime, ChronoUnit.MINUTES);
						tempDateTime = tempDateTime.plusMinutes(minutes);
						long seconds = tempDateTime.until(dateTime, ChronoUnit.SECONDS);

						System.out.printf("count : %04d-%02d-%02d %02d:%02d:%02d \n", years, months, days, hours,
								minutes, seconds);
						Thread.sleep(1000);
						if (LongStream.of(seconds, minutes, hours, days, months, years).allMatch(num -> num == 0)) {
							System.out.println("Countdown over!");
							break;
						}
					}
				}
			} catch (DateTimeException dte) {
				System.out
						.print("Invalid value for the input. Type \"yes\" to try again, any other character to exit: ");
				answer = scanner.nextLine();
			} finally {
				scheduledFuture.cancel(true);
				ses.shutdown();
			}
		} while (answer.equalsIgnoreCase("yes"));
		scanner.close();
	}
}
