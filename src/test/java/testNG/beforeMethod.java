package testNG;

import org.testng.annotations.*;

public class beforeMethod {

  @BeforeMethod
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



  @AfterMethod
  public void logout() {
	  System.out.println("Logout");
  }

}
