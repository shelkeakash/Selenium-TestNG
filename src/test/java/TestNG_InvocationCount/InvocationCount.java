package TestNG_InvocationCount;

import org.testng.annotations.Test;

public class InvocationCount {
	 
	//useful for exhaustive testing
	
	@Test(invocationCount=10)
	void test() {
		
		System.out.println("testing...");
		
	}

}
