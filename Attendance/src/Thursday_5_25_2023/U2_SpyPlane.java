/* Create a subclass of Plane class and name it U-2 Spy Plane,
 * which has the following properties and methods (wing span and method fly());
 */
package Thursday_5_25_2023;


public class U2_SpyPlane extends Vehicle { // Subclass

	private String planeName;
	private String wingspan;

	public U2_SpyPlane(String planeName, String wingspan, int speed, String color, double price) {
		super(speed, color, price);
		this.planeName = planeName;
		this.wingspan = wingspan;
	}

	public void fly() {
		System.out.println("Take off");
	}

	@Override
	public void stop() {
		System.out.println("The airplane has landed.");
//		super.stop();
	}

	public String getPlaneName() {
		return planeName;
	}

	public String getWingspan() {
		return wingspan;
	}
}
