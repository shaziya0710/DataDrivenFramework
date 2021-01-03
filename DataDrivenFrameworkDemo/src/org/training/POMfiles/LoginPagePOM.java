package org.training.POMfiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.training.utility.Utility;

public class LoginPagePOM {
	WebDriver driver;
	public  LoginPagePOM(WebDriver driver)
	{
		this.driver=driver;
	}

	public void enteremail(String EM) throws Exception
	{
		driver.findElement(By.id(Utility.fetchlocaterValue("login_email_id"))).sendKeys(EM);
		
	}

	public void enterpassword(String pwd) throws Exception
	{
		driver.findElement(By.name(Utility.fetchlocaterValue("login_password_name"))).sendKeys(pwd);
	}

	public void clicksignin() throws Exception
	{
		driver.findElement(By.xpath(Utility.fetchlocaterValue("login_loginbtn_xpath"))).click();
	}

}
