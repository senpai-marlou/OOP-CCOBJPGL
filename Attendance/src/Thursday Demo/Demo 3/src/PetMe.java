
public class PetMe {

	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.color = "blue";
		cat.age = 1;

		cat.meow();
		cat.eat();

		Dog dog = new Dog();
		dog.color = "green";
		dog.breed = "aspin";

		dog.bark();
		dog.eat();
	}

}
