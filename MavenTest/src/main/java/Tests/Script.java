package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Script {
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		driver =new ChromeDriver();
	}
	
	@Test
	@Ignore
	public void registration() {
		driver.get("http://localhost:8090/FlyAway/");
		driver.findElement(By.linkText("Login/Signup")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Not a member? Signup")).click();
		driver.findElement(By.name("email_id")).sendKeys("abcd@gmail.com");
		driver.findElement(By.name("pwd")).sendKeys("12345");
		driver.findElement(By.name("pwd2")).sendKeys("12345");
		driver.findElement(By.name("name")).sendKeys("Ravi");
		driver.findElement(By.name("address")).sendKeys("Naroda");
		driver.findElement(By.name("city")).sendKeys("Ahmedabad");
		driver.findElement(By.tagName("button")).click();
	}
	
	@Test
	@Ignore
	public void failLogin() {
		driver.get("http://localhost:8080/FlyAway/");
		driver.findElement(By.linkText("Login/Signup")).click();
		driver.findElement(By.name("email_id")).sendKeys("abxd@gmail.com");
		driver.findElement(By.name("pwd")).sendKeys("12345");
		driver.findElement(By.tagName("button")).click();
	}
	
	@Test(priority=1)
	public void passLogin() {
		driver.get("http://localhost:8090/FlyAway/");
		driver.findElement(By.linkText("Login/Signup")).click();
		driver.findElement(By.name("email_id")).sendKeys("abcd@gmail.com");
		driver.findElement(By.name("pwd")).sendKeys("12345");
		driver.findElement(By.tagName("button")).click();
	}
	
	@Test
	@Ignore
	public void flightBooking() {
		driver.findElement(By.linkText("Home")).click();
		driver.findElement(By.name("source")).sendKeys("Bangalore");
		driver.findElement(By.name("destination")).sendKeys("Chennai");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.linkText("Book Flight")).click();
		driver.findElement(By.linkText("Click to complete booking")).click();
	}
	
	@Test(priority=2)
	public void changePassword() {
		driver.findElement(By.linkText("Edit Profile")).click();
		driver.findElement(By.name("pwd")).sendKeys("54321");
		driver.findElement(By.name("pwd2")).sendKeys("54321");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

}
