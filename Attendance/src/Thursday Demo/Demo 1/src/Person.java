
public class Person {

	private String name;
	private String gender;
	private double weight;
	private int jowa;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getJowa() {
		return jowa;
	}

	public void setJowa(int jowa) {
		this.jowa = jowa;
	}

	public Person(String name, String gender, double weight, int jowa) {
		super();
		this.name = name;
		this.gender = gender;
		this.weight = weight;
		this.jowa = jowa;
	}

}
