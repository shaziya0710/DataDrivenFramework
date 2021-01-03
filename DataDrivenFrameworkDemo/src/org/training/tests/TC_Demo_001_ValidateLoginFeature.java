package org.training.tests;

import org.testng.annotations.Test;

import org.training.POMfiles.LoginPagePOM;
import org.training.base.DriverInstance;
import org.training.excel.Datagenerator;

public class TC_Demo_001_ValidateLoginFeature extends DriverInstance {

	@Test(dataProvider="Excel",dataProviderClass=Datagenerator.class)
	public void checklogin(String un,String pw) throws Exception
	{
		
			LoginPagePOM signin=new LoginPagePOM(driver);
			signin.enteremail(un);
			signin.enterpassword(pw);
			Thread.sleep(3000);
			signin.clicksignin();
	}
}
