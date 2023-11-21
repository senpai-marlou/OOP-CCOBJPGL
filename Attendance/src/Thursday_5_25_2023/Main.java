package Thursday_5_25_2023;

public class Main {
	public static void main(String[] args) {

		// ------------------------------------------------------------------------------------------

		// Parameterized
		ToyotaVIOS toyotaVIOS = new ToyotaVIOS("Toyota VIOS", "Standard", 120, "Black", 20000.0);

		toyotaVIOS.drive(); // Car Driving
		toyotaVIOS.stop(); // Car Stopped

		// Properties from the ToyotaVIOS class
		System.out.println("\nCar name: " + toyotaVIOS.getCarName());
		System.out.println("Tire type: " + toyotaVIOS.getTireType());

		// Properties from the parent class
		System.out.println("Speed: " + toyotaVIOS.speed + " kph");
		System.out.println("Color: " + toyotaVIOS.color);
		System.out.println("Price: $" + toyotaVIOS.price + "\n");

		// ------------------------------------------------------------------------------------------

		U2_SpyPlane SpyPlane = new U2_SpyPlane("Air Asia", "31 meters", 805, "White && Blue", 5.5);

		SpyPlane.fly();
		SpyPlane.stop();

		// Properties from the U2_SpyPlane class
		System.out.println("\nPlane name: " + SpyPlane.getPlaneName());
		System.out.println("Plane wingspan: " + SpyPlane.getWingspan());

		// Properties from the parent class
		System.out.println("Speed: " + SpyPlane.speed + " kph");
		System.out.println("Color: " + SpyPlane.color);
		System.out.println("Price: $" + SpyPlane.price + " M\n");

		// ------------------------------------------------------------------------------------------

		FandangoYacht Yacht = new FandangoYacht("Fandango Yacht", "White", 21, "White && Blue", 2.3);

		Yacht.Float();
		Yacht.stop();

		// Properties from the FandangoYacht class
		System.out.println("\nYacht name: " + Yacht.getYachtName());
		System.out.println("Main Sail Color: " + Yacht.getMainSailColor());

		// Properties from the parent class
		System.out.println("Speed: " + Yacht.speed + " kn");
		System.out.println("Color: " + Yacht.color);
		System.out.print("Price: $" + Yacht.price + " M");

	}
}
