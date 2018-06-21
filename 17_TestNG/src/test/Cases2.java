package test;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Cases2 {

	@Test
	public void DemoTest3() {
		System.out.println("See you");
	}
	
	@Test
	public void DemoTest4() {
		System.out.println("MyTest!");
		Assert.assertTrue(false);
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest()");
	}
	
	@BeforeSuite
	public void BeforeSt() {
		System.out.println("beforeSuite() method!");
	}
}
