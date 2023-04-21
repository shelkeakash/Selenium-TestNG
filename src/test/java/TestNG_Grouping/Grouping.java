package TestNG_Grouping;

import org.testng.annotations.Test;

/*
 
 loginByEmail - Sanity & Regression
 loginByFacebook - Sanity
 loginByTwitter - Sanity
 
 signupByEmail - Sanity & Regression
 signupByFacebook - Regression
 signupByTwitter - Regression
 
 paymentinRupees - Sanity & Regression
 paymentinDollar - Sanity
 paymentReturnbyBank - regression
 
 */

public class Grouping {
	
	@Test(priority = 1,groups= {"Sanity","Regression"})
	void loginByEmail() {
		System.out.println("Login by email");
	}
	
	@Test(priority = 2,groups= {"Sanity"})
	void loginByFacebook() {
		System.out.println("Login by facebook");
	}
	
	@Test(priority = 3,groups= {"Sanity"})
	void loginByTwitter() {
		System.out.println("Login by twitter");
	}
	
	@Test(priority = 4,groups= {"Sanity","Regression"})
	void signupByEmail() {
		System.out.println("Signup by email");
	}
	
	@Test(priority = 5,groups= {"Regression"})
	void signupByFacebook() {
		System.out.println("Signup by facebook");
	}
	
	@Test(priority = 6,groups= {"Regression"})
	void signupByTwitter() {
		System.out.println("Signup by twitter");
	}
	
	@Test(priority = 7,groups= {"Sanity","Regression"})
	void paymentinRupees() {
		System.out.println("Payment in rupees");
	}
	
	@Test(priority = 8,groups= {"Sanity"})
	void paymentinDollar() {
		System.out.println("Payment in Dollar");
	}
	
	@Test(priority = 9,groups= {"Regression"})
	void paymentReturnbyBank() {
		System.out.println("paymentReturnbyBank");
	}

}
