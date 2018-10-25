package logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

public class LoggerDemo implements InvocationHandler {
	final static Logger logger = Logger.getLogger(LoggerDemo.class);
	private Object target;
	
	public LoggerDemo(Object target){
		this.target =  target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		logger.error("Entry ->"+method.getName());
		Object result = null;
		try {
			long start = System.currentTimeMillis();
			result = method.invoke(target, args);
			long end = System.currentTimeMillis();
			logger.error("Exit ->"+method.getName() +"() : "+"Time taken:"+(end-start)+" milli seconds");
		}catch (Exception e) {
			logger.error("Exception ->"+method.getName() +"() : "+e.getCause());
		}
		
		return result;
	}

}
