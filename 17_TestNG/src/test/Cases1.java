package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Cases1 {
	
	@Test
	public void DemoTest1() {
		System.out.println("Cases1.Test1");
	}
	
	@Test
	public void DemoTest2() {
		System.out.println("Cases1.Test2");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After suite() method");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("afterTest()");
	}
}