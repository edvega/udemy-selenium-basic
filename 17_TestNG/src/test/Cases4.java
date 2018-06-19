package test;

import org.testng.annotations.Test;

public class Cases4 {

	@Test
	public void test1() {
		System.out.println("Cases4.Test1");
	}
	
	@Test
	public void test2() {
		System.out.println("Cases4.Test2");
	}
	
	@Test(groups={"group1"})
	public void test3() {
		System.out.println("Cases4.Test3");
	}
}
