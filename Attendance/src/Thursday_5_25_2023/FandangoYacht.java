/* Create a subclass of Boat class and name it Fandango Yacht,
 * which has the following properties and methods (MainSail color and method float());
 */
package Thursday_5_25_2023;


public class FandangoYacht extends Vehicle { // Subclass

	private String yachtName;
	private String MainSailColor;

	public FandangoYacht(String yachtName, String MainSailColor, int speed, String color, double price) {
		super(speed, color, price);
		this.yachtName = yachtName;
		this.MainSailColor = MainSailColor;
	}

	void Float() {
		System.out.println("Fandango Yacht is Sailing");
	}

	@Override
	public void stop() {
		System.out.println("Fandango Yacht port.");
//		super.stop();
	}

	public String getYachtName() {
		return yachtName;
	}

	public String getMainSailColor() {
		return MainSailColor;
	}

}
