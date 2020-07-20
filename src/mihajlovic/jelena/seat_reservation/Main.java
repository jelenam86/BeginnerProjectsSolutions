package mihajlovic.jelena.seat_reservation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

	Scanner scanner = new Scanner(System.in);
	Stadium concert = new Stadium(3, 3);

	concert.reserveSeat(scanner);
	scanner.close();
    }

}
