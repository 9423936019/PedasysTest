package StepDefinitionfile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactPage {
	WebDriver driver;
	
	@Given("User open growth engineering url")
	public void user_open_growth_engineering_url() {
		System.setProperty("webdriver.chrome.driver","‪‪‪‪‪D:\\chrome91\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.growthengineering.co.uk/");
		driver.manage().window().maximize();
	}

	@Then("user is on home page")
	public void user_is_on_home_page() throws InterruptedException {
		
		System.out.println("Title of this Page is : "+driver.getTitle());
		Thread.sleep(2000);
	}

	@Then("validate url of this page")
	public void validate_url_of_this_page() throws InterruptedException {
	   
		String ActualUrl = driver.getCurrentUrl();
		String ExpectedUrl = "https://www.growthengineering.co.uk/";
		
		if(ActualUrl.equals(ExpectedUrl))	{
			System.out.println("Test case is passed");
		}
		else	{
			System.out.println("Test case is failed");
		}
			
		System.out.println("Url of this page is : "+driver.getCurrentUrl());
		Thread.sleep(2000);
	}

	@Then("click on the Get In Touch")
	public void click_on_the_get_in_touch() throws InterruptedException {

		WebElement touchButton = driver.findElement(By.xpath("//a[@id='contact-button']"));
		Actions act = new Actions(driver);
		act.moveToElement(touchButton).build().perform();
		
		driver.findElement(By.id("contact-button")).click();
		Thread.sleep(1000);
		
	}

	@Then("user is on contact page and Test Contact page")
	public void user_is_on_contact_page_and_test_contact_page() {
	
		String ActualUrl = driver.getCurrentUrl();
		String ExpectedUrl = "https://www.growthengineering.co.uk/contact/";
		
		if(ActualUrl.equals(ExpectedUrl))	{
			System.out.println("Succesfully validate page");
		}
		else	{
			System.out.println("Unsuccesfull validate page");
		}
	}

	@When("we can create new user")
	public void we_can_create_new_user() {

		driver.findElement(By.name("full_name")).sendKeys("Mahendra Chavan");
		driver.findElement(By.name("email")).sendKeys("mschavan1818@gmail.com");
		driver.findElement(By.name("phone")).sendKeys("7234859382");
		driver.findElement(By.name("company")).sendKeys("xyz");
		
		WebElement country = driver.findElement(By.name("country_"));
		Select sel = new Select(country);
		
		sel.selectByVisibleText("Please Select");
		sel.selectByValue("India");
		
		WebElement Role = driver.findElement(By.name("role_description"));
		Select sel1 = new Select(Role);
		sel.selectByIndex(2);
		
		WebElement enquiry = driver.findElement(By.name("what_is_the_purpose_of_your_enquiry_"));
		Select sel2 = new Select(enquiry);
		sel.selectByIndex(1);
	    
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	}

	@Then("validate newly created user")
	public void validate_newly_created_user() throws InterruptedException {
	    
		Thread.sleep(2000);
		driver.close();
	}

}
