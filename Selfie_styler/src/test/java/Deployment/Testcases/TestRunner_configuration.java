package Deployment.Testcases;

import org.testng.TestNG;

public class TestRunner_configuration {
	
	
	static TestNG testNg;

	public static void main(String[] args) {
		
		testNg = new TestNG();
		
		testNg.setTestClasses(new Class[] {Verify_Currentlook.class});
		
		testNg.run();
		

	}

}
