package testNGTest;

import org.testng.annotations.*;

public class Class1 {
	
	@Test
	void abc() {
		
		System.out.println("This is abc from Class 1");
	}
	
	@BeforeTest
	void m() {
		
		System.out.println("This is before test method");
	}

}
