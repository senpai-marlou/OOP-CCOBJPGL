
public class MyClasslist {

	public static void main(String[] args) {
		Person me = new Person("Marlou", "Male", 50, 1);

		me.setName("Marlou");
		me.setGender("Male");
		me.setWeight(50);
		me.setJowa(1);

		System.out.println(me.getName());
		System.out.println(me.getGender());
		System.out.println(me.getWeight());
		System.out.println(me.getJowa());
	}
}
