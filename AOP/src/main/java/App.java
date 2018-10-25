
import demo.DemoI;
import demo.HelloFactory;
import demo.HelloFactoryI;

public class App {

	public static void main(String[] args) throws Exception {
		HelloFactoryI factory = new HelloFactory();
		DemoI demo = factory.getInstance();
		demo.sayHello("Shafi");
	}
}
