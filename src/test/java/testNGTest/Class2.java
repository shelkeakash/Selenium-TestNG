package testNGTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Class2 {
	
	@Test
	void xyz() {
		
		System.out.println("This is xyz from Class 1");
	}
	
	@AfterTest
	void n() {
		
		System.out.println("This is after test method");
	}

}
