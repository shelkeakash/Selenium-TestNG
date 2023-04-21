package testNG;

import org.testng.annotations.*;

public class beforeClass {

  @BeforeClass
  public void login() {
	  
	  System.out.println("Login");
  }
  
  @Test
  public void search() {
	  
	  System.out.println("Search Test");
  }
  
  @Test
  public void advancedSearch() {
	  
	  System.out.println("Adv search");
  }



  @AfterClass
  public void logout() {
	  System.out.println("Logout");
  }

}
