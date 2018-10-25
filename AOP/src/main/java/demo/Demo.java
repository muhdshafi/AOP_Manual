package demo;

class Demo implements DemoI {


	@Override
	public String sayHello(String name) throws Exception {
		System.out.println("Demo.sayHello()");
		//throw new Exception("just an exception!");
		Thread.sleep(100);
		return "Hello "+name;
	}

}
