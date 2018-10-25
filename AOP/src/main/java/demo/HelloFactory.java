package demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Proxy;
import java.util.Properties;
import logger.LoggerDemo;

public class HelloFactory implements HelloFactoryI {

	@Override
	public DemoI getInstance() {
		Properties prop = new Properties();
		try {
			prop.load(getClass().getClassLoader().getResourceAsStream("system.properties"));
			boolean isDebugMode = Boolean.parseBoolean(prop.getProperty("debug"));
			
			if(isDebugMode) {//debug mode
				DemoI demo =  new Demo();
				LoggerDemo logger = new LoggerDemo(demo);
				ClassLoader cl = HelloFactory.class.getClassLoader();
				DemoI proxy = (DemoI)Proxy.newProxyInstance(cl, new Class[] {DemoI.class}, logger);
				return proxy; 
				
			}else {//production
				return new Demo();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
