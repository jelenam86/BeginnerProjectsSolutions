package mihajlovic.jelena.flames_game;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

	Scanner scanner = new Scanner(System.in);
	System.out.println("***FLAMES game***\n\nEnter first person name: ");
	String person1 = scanner.nextLine();
	System.out.println("Enter second person name: ");
	String person2 = scanner.nextLine();
	scanner.close();

	new FlamesGame(person1, person2).play();
    }
}
