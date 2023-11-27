
import java.util.Scanner;

public class EBookRentalSystem {

	static int[] copies = { 2, 3, 4 };

	public static void main(String[] args) {
		System.out.println("Electronic Book Rental System");
		System.out.println("------------------------------");
		rent();
	}

	public static void rent() {
		Scanner scan = new Scanner(System.in);
		String[] books = { "System Analysis and Design by Gary B. Shelly", "Android Application by Corine Hoisington",
				"Programming Concepts and Logic Formulation by Rosauro E. Manuel" };
		String[] years = { "2012", "2014", "2015" };

		boolean stop = true;

		while (stop) {
			System.out.println("\nAvailable Books:\n");
			for (int i = 0; i < books.length; i++) { // print available books
				System.out.println(
						(i + 1) + ". " + books[i] + " (" + years[i] + ")\n   - Copies Available: " + copies[i]);
			}

			System.out.print("\nEnter the index of the book you want to rent: ");
			int index = scan.nextInt();

			if (index < 1 || index > books.length) {
				System.out.println("INDEX DOES NOT EXIST, Try Again!");
			} else if (copies[index - 1] == 0) {
				System.out.println("No copies available for " + books[index - 1]);
			} else {
				System.out.println("You rented " + books[index - 1]);
				copies[index - 1]--;

				System.out.print("\nYou want to rent again? [Y/N]: ");
				String choice = scan.next();

				if (choice.equalsIgnoreCase("Y") && copies[0] == 0 && copies[1] == 0 && copies[2] == 0) {
					System.out.println("\nNo books available!");
					stop = false;
				}
				if (choice.equalsIgnoreCase("Y")) {
					// Do nothing, REPEAT.
				} else {
					stop = false;
				}
			}
		}
		System.out.println("Thank you for using the Electronic Book Rental System!");
	}
}
