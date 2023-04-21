package TestNGAssertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVsSoftAssertions {
	
/*	@Test
	void test_hardAssertions() {
		
		System.out.println("Testting.....");
		System.out.println("Testting.....");
		System.out.println("Testting.....");
		System.out.println("Testting.....");
		System.out.println("Testting.....");
		
		Assert.assertEquals(1, 2);
		
		System.out.println("Hard Assertion completed");
		
		Assert.assertEquals(1, 1);
	}
	*/
	@Test
	void test_softAssertions() {
		
		System.out.println("Testting.....");
		System.out.println("Testting.....");
		System.out.println("Testting.....");
		System.out.println("Testting.....");
		System.out.println("Testting.....");
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(1, 2);
		
		System.out.println("Soft Assertion completed");
		
		sa.assertAll();//mandatory
	}

}
