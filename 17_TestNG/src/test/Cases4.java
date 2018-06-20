package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Cases4 {

	@Test
	public void test1() {
		System.out.println("Cases4.Test1");
	}
	
	@Parameters({"user", "pass"})
	@Test
	public void test2(String user, String pass) {
		System.out.println("Cases4.Test2 " + "USER: " + user + " " + 
							"PASS: " + pass);
	}
	
	@Parameters({"URL"})
	@Test(groups={"group1"})
	public void test3(String url) {
		System.out.println("Cases4.Test3 " + "URL: " + url);
	}
}
