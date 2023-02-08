package Naukari1;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class login extends utilityclass {
	WebDriver  driver;

	@BeforeClass
	public void browserlogin() {
		System.setProperty(browser, path);
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void Naukarilogin() throws InterruptedException {
		driver.get(URL);
		driver.findElement(By.xpath("//input[@id='usernameField']")).sendKeys(username1);
		driver.findElement(By.xpath("//input[@id='passwordField']")).sendKeys(password1);
		driver.findElement(By.xpath("//button[@type='submit']//parent::div//child::button[1]")).click();
		
	}

	@Test
	public void Test() throws InterruptedException {
		Thread.sleep(10000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='nI-gNb-drawer__icon']")).click();
		driver.findElement(By.xpath("//a[@class='nI-gNb-info__sub-link']")).click();
		driver.findElement(By.xpath("//span[@class='edit icon']//parent::div//child::span[2]")).click();
		String ele = driver.findElement(By.xpath("//textarea[@id='resumeHeadlineTxt']")).getText();
		System.out.println(ele);
		String ele1 = "Software Test Engineer seeking roles in Automation Testing,Manual Testing,Selenium RC,Test Complete,Software Testing,Test Engineering,Bug Reporting,Black Box Testing,Regression Testing,GUI Testing,Defect Life Cycle,White Box Testing.AEM Tester";
		if (ele.equals(ele1)) {

			driver.findElement(By.xpath("//textarea[@id='resumeHeadlineTxt']")).clear();
			driver.findElement(By.xpath("//textarea[@id='resumeHeadlineTxt']")).sendKeys(Testdata);
		}

		else {
			driver.findElement(By.xpath("//textarea[@id='resumeHeadlineTxt']")).clear();
			driver.findElement(By.xpath("//textarea[@id='resumeHeadlineTxt']")).sendKeys(
					"Software Test Engineer seeking roles in Automation Testing,Manual Testing,Selenium RC,Test Complete,Software Testing,Test Engineering,Bug Reporting,Black Box Testing,Regression Testing,GUI Testing,Defect Life Cycle,White Box Testing.AEM Tester");

		}

		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
	}
	 @AfterMethod
	 public void logoutNaukari() {
		 System.out.println("Logout sucessfully");
	 }
	 
	 @AfterClass
	 public void logoutBrowser() {
		 driver.close();
		 System.out.println("close sucessfully");
	 }

}
