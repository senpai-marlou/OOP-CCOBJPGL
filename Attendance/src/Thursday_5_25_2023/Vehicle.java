/* Your code should have a Base Class Vehicle class to represent different means of
 * TRANSPORTATION. This class should represent the vehicle SPEED, COLOR, PRICE and has
 * a method STOP. To keep your code shorter, you should apply the Object-Oriented concepts -
 * Inheritance and Overriding method and do the following:
 */
package Thursday_5_25_2023;


public class Vehicle { // Super class | Parent class

	int speed;
	String color;
	double price;

	public Vehicle(int speed, String color, double price) {
		this.speed = speed;
		this.color = color;
		this.price = price;
	}

	public void stop() {
		System.out.println("Override this Method");
	}
}
