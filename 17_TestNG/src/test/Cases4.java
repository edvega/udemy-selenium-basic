package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Cases4 {

	@Test(dataProvider="getData")
	public void test1(String username, String pass) {
		System.out.println("Cases4.Test1");
		System.out.println("USER: " + username + " PASS: " + pass);
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
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		
		data[0][0] = "firstUserName";
		data[0][1] = "password";

		data[1][0] = "2ndSetUsername";
		data[1][1] = "2ndPass";
		
		data[2][0] = "3rdSetUsername";
		data[2][1] = "3rdPass";
		
		return data;
	}
}
