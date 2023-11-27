import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {

		ArrayList<Book> books = new ArrayList<>();

		Book book1 = new Book();
		book1.name = "System Analysis and Design";
		book1.author = "Gary B. Shelly";
		book1.copy = 2;

		Book book2 = new Book();
		book2.name = "Android Application";
		book2.author = "Corine Hoisington";
		book2.copy = 3;

		Book book3 = new Book();
		book3.name = "Programming Concepts and Logic Formulation";
		book3.author = "Rosauro E. Manuel";
		book3.copy = 4;

		books.add(book1);
		books.add(book2);
		books.add(book3);

		System.out.println("ELECTRONIC BOOK RENTAL SYSTEM");
		System.out.println("-----------------------------");

		for (int i = 0; i < books.size(); i++) {
			System.out.print(i);
			System.out.print(" " + books.get(i).getName() + ", " + books.get(i).getAuthor());
			System.out.println();
		}

		boolean end = false;

		while (!end) {
			try {
				Scanner scan = new Scanner(System.in);
				System.out.print("\nChoose a number to rent a book: ");
				int choice = scan.nextInt();

				Book book = books.get(choice);
				int copy = book.getCopy();
				if (copy > 0) {
					System.out.println("You rented : " + books.get(choice).getName());
					book.setCopy(copy -= 1);
				} else {
					System.out.println("No copies available");
				}

				System.out.print("\nRent again? [Y/N]");
				String ask = scan.next();
				if (ask.equalsIgnoreCase("N")) {
					end = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: Input must number");
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Error: Input must be within the choices");
			}
		}
	}
}
