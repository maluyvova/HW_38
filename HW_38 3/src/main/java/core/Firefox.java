package core;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.logging.*;

public class Firefox {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.OFF);
		
		String driverPath = "";

		String url = "http://facebook.com/";
		String email_address = "bryanwick77@gmail.com";
		String password = "maluyvova1995";

	     if (System.getProperty("os.name").toUpperCase().contains("MAC"))     driverPath = "./resources/webdrivers/mac/geckodriver.sh";
	else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS")) driverPath = "./resources/webdrivers/pc/geckodriver.exe";
	else throw new IllegalArgumentException("Unknown OS");
			
			System.setProperty("webdriver.gecko.driver", driverPath);
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		
			WebDriverWait wait = new WebDriverWait (driver,15);
			driver.get(url);

			wait.until(ExpectedConditions.titleIs("Facebook - Log In or Sign Up")); // Pause in milleseconds (1000 – 1 sec)
			
			String title = driver.getTitle();
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.textToBePresentInElement(By.xpath("//*[@id=\'pageFooter\']/div[3]/div/span"),"Facebook © 2017"));
			
			
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys(email_address);
			System.out.println("Size of Email field " + (Dimension) driver.findElement(By.id("email")).getSize());
			System.out.println("Located of Email field " + (Point) driver.findElement(By.id("email")).getLocation());
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			
			wait.until(ExpectedConditions.presenceOfElementLocated (By.id("pass"))).sendKeys(password);
			System.out.println("Size of Password field " + (Dimension) driver.findElement(By.id("pass")).getSize());
			System.out.println("Location of Password field"  + (Point) driver.findElement(By.id("pass")).getLocation());
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	        
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginbutton"))).click();
	        
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	        
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='u_0_a']/div[1]/div[1]/div/a/span"))).click();
	        System.out.println("Size of TimeLine" + (Dimension) driver.findElement(By.xpath("//*[@id='u_0_a']/div[1]/div[1]/div/a/span")).getSize());
	        System.out.println("Location of TimeLine" + (Point) driver.findElement(By.xpath("//*[@id='u_0_a']/div[1]/div[1]/div/a/span")).getLocation());
	        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	        
	        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	        
	        String friends = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[2]/ul/li[3]/a/span[1]"))).getText();
	        System.out.println("Size of Friends " + (Dimension) driver.findElement(By.xpath("//div[2]/ul/li[3]/a/span[1]")).getSize());
	        System.out.println("Location of Friends" + (Point) driver.findElement(By.xpath("//div[2]/ul/li[3]/a/span[1]")).getLocation());
	       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	        
	       driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	       
	       wait.until(ExpectedConditions.elementToBeClickable(By.id("userNavigationLabel"))).click();
	       System.out.println("Size of Setting Button" + (Dimension) driver.findElement(By.id("userNavigationLabel")).getSize());
	       System.out.println("Location of Setting Button" + (Point) driver.findElement(By.id("userNavigationLabel")).getLocation());
	       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	       
	       driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	       System.out.println("Size of Log out Button" + (Dimension) driver.findElement(By.id("userNavigationLabel")).getSize());
	       System.out.println("Location of Log out Button" + (Point) driver.findElement(By.id("userNavigationLabel")).getLocation());
	       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[8]/div/div/div/div/div[1]/div/div/ul/li[14]/a/span/span"))).click();

	       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.quit();
	        
			System.out.println("Browser is: FireFox");
	        System.out.println("Title of the page: " + title);
	       
	        System.out.println("You have " + friends + " friends");
		}
}