package space.snowwolf.effectivejava.four;

//Noninstantiable utility class
public class UtilityClass {
	//Supress default constructor for noninstantiability
	private UtilityClass() {
		throw new AssertionError();
	}
}
