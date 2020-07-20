package mihajlovic.jelena.seat_reservation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Stadium {

    private final int numberOfRows;
    private final int numberOfSeatsPerRow;
    private final List<Seat> seats;
    private List<Available> availability;

    public Stadium(int numberOfRows, int numberOfSeatsPerRow) {
	this.numberOfRows = numberOfRows;
	this.numberOfSeatsPerRow = numberOfSeatsPerRow;
	this.seats = new ArrayList<Stadium.Seat>();
	for (int i = 1; i <= numberOfRows; i++) {
	    for (int j = 1; j <= numberOfSeatsPerRow; j++) {
		seats.add(new Seat(String.format("%02d", i) + String.format("%02d", j)));
	    }
	}
	this.availability = new ArrayList<Stadium.Available>();
	seats.forEach(seat -> this.availability.add(new Available(seat)));
    }

    public int getNumberOfRows() {
	return numberOfRows;
    }

    public int getNumberOfSeatsPerRow() {
	return numberOfSeatsPerRow;
    }

    public boolean reserveSeat(String seatNumber) {
	Seat seat = new Seat(seatNumber);
	int found = Collections.binarySearch(seats, seat);
	if (found >= 0) {
	    return seats.get(found).reserve();
	} else {
	    System.out.println("There is no seat " + seatNumber);
	    return false;
	}
    }

    public List<Character> getAvailability() {
	List<Character> chars = new ArrayList<Character>();
	availability.forEach(item -> chars.add(availability.indexOf(item), item.getAvailable()));
	return chars;
    }

    public void printChairs() {
	printHeader();
	for (int i = 1; i <= numberOfRows; i++) {
	    String row = startLine(i);
	    for (int j = 1; j <= numberOfSeatsPerRow; j++) {
		for (Available item : availability) {
		    if (item.getSeat().getNumberOfRow() == i && item.getSeat().getNumberInRow() == j) {
			row += " " + item.getAvailable() + getSufix(String.valueOf(j).length());
			break;
		    }
		}
	    }
	    System.out.println(row);
	}
    }

    private void printHeader() {
	String header = "row/column";
	for (int i = 1; i <= numberOfSeatsPerRow; i++) {
	    header += " " + i + " ";
	}
	System.out.println(header);
    }

    private String startLine(int row) {
	int length = "row/column".length() - String.valueOf(row).length() - 1;
	return " " + row + getSufix(length);
    }

    private String getSufix(int value) {
	String sufix = "";
	for (int i = 0; i < value; i++) {
	    sufix += " ";
	}
	return sufix;
    }

    public boolean hasAvailableSeats() {
	return getAvailability().contains('-');
    }

    public void reserveSeat(Scanner scanner) {
	System.out.println("Welcome to the reservation program.");
	String answer = "yes";
	while (hasAvailableSeats() && answer.equalsIgnoreCase("yes")) {
	    System.out.println("Below is the list of available seats (the ones with \"-\").");
	    printChairs();
	    System.out.println(
		    "Enter the seat number in format XXXX (XX - row, XX - column) to reserve seat or \"quit\" to exit program.");
	    String seat = scanner.next();
	    if (seat.equalsIgnoreCase("quit"))
		break;
	    this.reserveSeat(seat);
	    if (hasAvailableSeats()) {
		System.out.println("Do you want to reserve another seat?");
		answer = scanner.next();
	    }
	}
	if (!hasAvailableSeats())
	    System.out.println("Unfortunately, there are no more available seats.");
    }

    class Seat implements Comparable<Seat> {

	private final String seatNumber;
	private boolean isReserved = false;

	Seat(String seatNumber) {
	    this.seatNumber = seatNumber;
	}

	boolean isReserved() {
	    return isReserved;
	}

	String getSeatNumber() {
	    return seatNumber;
	}

	boolean reserve() {
	    if (!this.isReserved) {
		isReserved = true;
		availability.get(Collections.binarySearch(availability, new Available(this))).setAvailable();
		System.out.println("Seat " + seatNumber + " reserved.");
		return true;
	    }
	    System.out.println("Seat " + seatNumber + " is not available.");
	    return false;
	}

	int getNumberOfRow() {
	    return Integer.valueOf(seatNumber.substring(0, 2));
	}

	int getNumberInRow() {
	    return Integer.valueOf(seatNumber.substring(2));
	}

	@Override
	public int compareTo(Seat o) {
	    return this.getSeatNumber().compareToIgnoreCase(o.getSeatNumber());
	}

    }

    // to use list as result instead of map
    class Available implements Comparable<Available> {

	private final Seat seat;
	private char available;

	Available(Seat seat) {
	    this.seat = seat;
	    setAvailable();
	}

	public Seat getSeat() {
	    return seat;
	}

	public char getAvailable() {
	    return available;
	}

	void setAvailable() {
	    this.available = seat.isReserved ? 'X' : '-';
	}

	@Override
	public int compareTo(Available o) {
	    return this.getSeat().compareTo(o.getSeat());
	}

    }
}
