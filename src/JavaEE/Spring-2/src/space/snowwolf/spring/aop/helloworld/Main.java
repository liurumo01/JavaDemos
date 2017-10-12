package space.snowwolf.spring.aop.helloworld;

public class Main {
	public static void main(String[] args) {
		//ArithmeticCalculator calculator = new ArithmeticCalculatorLoggingImpl();
		ArithmeticCalculator calculator = new ArithmeticCalculatorImpl();
		ArithmeticCalculator proxy = new ArithmeticCalculatorLoggingProxy(calculator).getLoggingProxy();
		System.out.println(proxy.add(1, 2));
		System.out.println(proxy.div(4, 2));
	}
}
