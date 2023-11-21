/* Create a subclass of Car class and name it Toyota-VIOS, which has
 * the following properties and methods (tire type and method drive());
 */
package Thursday_5_25_2023;


class ToyotaVIOS extends Vehicle { // Subclass

	// w/ implementation of setters and getters
	private String carName;
	private String tireType;

	public ToyotaVIOS(String carName, String tireType, int speed, String color, double price) {
		super(speed, color, price);
		this.carName = carName;
		this.tireType = tireType;
	}

	public void drive() {
		System.out.println("Toyota VIOS is driving.");
	}

	@Override
	public void stop() {
		System.out.println("Vehicle stopped.");
//		super.stop();
	}

	public String getCarName() {
		return carName;
	}

	public String getTireType() {
		return tireType;
	}
}