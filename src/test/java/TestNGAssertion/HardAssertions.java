package TestNGAssertion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertions {
	
	@Test
	void test() {
		
		int x =100;
		int y = 15;
		
		/*if(x==y) {
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test failed");
		}*/
		
		//Assert.assertEquals(actual,expected,description/message)
		Assert.assertEquals(x>y,true,"x is not greater than y"); //Assert.assertEquals(false,true)
		
		
		String s1 = "abc";
		String s2 = "abc1";
		
		//Assert.assertEquals(s1,s2,"s1 is not equal to s2");
		
		//Assert.assertNotEquals(s1,s2);
		
		if(false) {
			Assert.assertTrue(true);
		}
		else {
			Assert.fail();
		}
		
		
	}

}
