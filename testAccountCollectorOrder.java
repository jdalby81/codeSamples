package test.java.com.account;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedHashMap;
import java.util.Map;
/**
 * drivers.java is the parent class. the objective of this file is to test order creation on the account.
 * we are going to declare out functions so we can segment these into groups for easier editing and readability
 * @author James Dalby
 *Kinetix LIS Regression Test Revised 2/27/18
 */

public class testAccountCollectorOrder extends drivers
{
    public testAccountCollectorOrder(){
        portalTestType = "Portal Order";
    }

	public String cssFirst; //creating variables so we can check against them when validating fields 
	public String cssEdit;

	public void Run() {

        /**
         * Maximizing the window to full size
         */
		driver.manage().window().maximize();

        /**
         * configuration for use throughout test
         * for use when moving browser windows
         */
		JavascriptExecutor jse = (JavascriptExecutor)driver;

        /**
         * Faker for random data
         */
		Faker faker = new Faker();

        /**
         * Hash maps start here
         */
		Map<String, String> map = new LinkedHashMap<String, String>();

        /**
         * Alternative ID's as well as comments section
         */
		map.put("alt_req_id", "2");
		map.put("comments", faker.gameOfThrones().quote());
        map.put("necessity", faker.gameOfThrones().quote());

        /**
         * Begin test here
         */
        driver.get(baseURL + "login"); //login to lis
	    
	    threadSleep(8000);
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys(portalUser);
	    
	    threadSleep(4000);
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys(password);
	    
	    threadSleep(4000);
	    driver.findElement(By.className("core_button")).submit();
	 
	    /**
	     * clicking on create new order
	     * wait for application to be fully loaded
         * creating a wait variable with xpath of button
	     */
	    threadSleep();
	    WebElement findOrderLink = (new WebDriverWait(driver, 10)).until(new ExpectedCondition<WebElement>(){
	    	public WebElement apply(WebDriver d){
	    		return d.findElement(By.xpath("//*[@id='core_page']/div[2]/div[3]/div/a[1]"));
	    	}
	    });
	    
	    findOrderLink.click(); //execute find order click

	    threadSleep(2000);
	    driver.findElement(By.xpath("//*[@id='doctors_auto']")).click(); //requesting physician
	    driver.findElement(By.xpath("//*[@id='order_default']/div[2]/div/div[1]/div[1]/div[5]/select/option[1]")).click(); //selecting the doctor

        /**
         * filling in the alternative id order comments, medical neceesity.
         */
        for (Map.Entry<String, String> entry : map.entrySet())
		{
			threadSleep(2000);
		    driver.findElement(By.id(entry.getKey())).clear();
		    driver.findElement(By.id(entry.getKey())).sendKeys(entry.getValue());
		}
		
	    jse.executeScript("window.scrollBy(0,550)", ""); //move page down 350px

		/**
		 * Finding and clicking on the panel selection
		 */
		threadSleep(2000);
		driver.findElement(By.xpath("//*[@id='test_selection_auto']")).click();
		driver.findElement(By.xpath("//*[@id='order_default']/div[2]/div/div[2]/div[1]/select/option[1]")).click();


		/**
         * finding and clicking on the patient
         */
        threadSleep(2000);
	    driver.findElement(By.xpath("//*[@id='patient_auto']")).click(); //Patient
	    driver.findElement(By.xpath("//*[@id='order_default']/div[3]/div[1]/div/div/div[1]/select/option[1]")).click();

        /**
         * Clicking the next buttons to move along the form
         */
	    threadSleep(2000);
	    driver.findElement(By.xpath("//*[@id='lightbox_controls_0']/a")).click(); //finding the first next
	   
	    threadSleep(2000);
	    driver.findElement(By.xpath("//*[@id='lightbox_controls_1']/a[2]")).click(); //2nd next

        /**
         * Clicking the checkbox disable this when running through crossbrowsertesting
         */
        //driver.findElement(By.xpath("//*[@id='sig_capture']")).click();

        /**
         * Submit the form
         */
        threadSleep(2000);
        jse.executeScript("window.scrollBy(0,350)", ""); //move page down 350px
	    driver.findElement(By.xpath("//*[@id='lightbox_controls_2']/a[2]")).submit(); //submit

        /**
         * Navigate to the base url
         */
        //threadSleep(2000);
	    //driver.get(baseURL);

        /**
         * Click the logout
         */
	    //threadSleep(2000);
	    //driver.findElement(By.xpath("//*[@id='logout_form']/a")).click(); //log out
	   
	}
}