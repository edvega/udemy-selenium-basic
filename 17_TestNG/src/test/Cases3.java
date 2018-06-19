package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Cases3 {

	@BeforeClass
	public void beforeClass() {
		System.out.println("BEFORE CLASS");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("AFTER CLASS");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod()");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod(");
	}
	
	@Test
	public void webLogin() {
		System.out.println("Logged in by web");
	}
	
	@Test
	public void mobileLogin() {
		System.out.println("Logged in by mobile app");
	}
	
	@Test
	public void apiLogin() {
		System.out.println("Logged in by API");
	}
	
	@Test
	public void webLoginOk() {
		System.out.println("Web Log in OK");
	}
	
	@Test
	public void webLoginFail() {
		System.out.println("Web log in Failed");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("BeforeTest()");
	}
	
	@Test(groups={"group1"})
	public void test5() {
		System.out.println("Cases3.Test5");
	}
	
	@Test(groups={"group1"})
	public void test6() {
		System.out.println("Cases3.Test6");
	}
}
