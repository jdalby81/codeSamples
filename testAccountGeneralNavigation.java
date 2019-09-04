package test.java.com.account;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * drivers.java is the parent class. the objective of this file is to test general navigation.
 * we are going to declare out functions so we can segment these into groups for easier editing and readability
 * @author James Dalby
 *Kinetix LIS Regression Test Revised 2/27/18
 */
public class testAccountGeneralNavigation extends drivers{

    public testAccountGeneralNavigation(){
        portalTestType = "Portal General Navigation";
    }

    public void Run(){
        driver.manage().window().maximize();

        driver.get(baseURL + "login"); //setting login to lis
        /**
         * entering the email address
         */
        threadSleep(4000); //thread sleeps default to 1000ms
        driver.findElement(By.id("email")).clear(); //email field clear
        driver.findElement(By.id("email")).sendKeys(portalUser); //email address entry

        /**
         * entering the password
         */
        threadSleep(2000);
        driver.findElement(By.id("password")).clear(); //password field clear
        driver.findElement(By.id("password")).sendKeys(password); //password enter

        /**
         * Submitting the form
         */
        threadSleep(2000);
        driver.findElement(By.className("core_button")).submit(); //submitting to log in

        /**
         * Submitted
         */
        threadSleep();
        driver.findElement(By.xpath("//*[@id='core_page']/div[2]/div[1]/div/div[1]/a[1]")).click();

        /**
         * In transit
         */
        threadSleep();
        driver.findElement(By.xpath("//*[@id='core_page']/div[2]/div[1]/div/div[1]/a[2]")).click();

        /**
         * Received
         */
        threadSleep();
        driver.findElement(By.xpath("//*[@id='core_page']/div[2]/div[1]/div/div[1]/a[3]")).click();

        /**
         * Released
         */
        threadSleep();
        driver.findElement(By.xpath("//*[@id='core_page']/div[2]/div[1]/div/div[1]/a[4]")).click();

        /**
         * Actions required
         *
         * On Hold
         */
        threadSleep();
        driver.findElement(By.xpath("//*[@id='core_page']/div[2]/div[1]/div/div[2]/a[1]")).click();

        /**
         * Rejected
         */
        threadSleep();
        driver.findElement(By.xpath("//*[@id='core_page']/div[2]/div[1]/div/div[2]/a[2]")).click();

        /**
         * Account Management
         *
         * Users
         */
        threadSleep();
        driver.findElement(By.xpath("//*[@id='core_page']/div[2]/div[1]/div/div[3]/a[1]")).click();

        /**
         * Locations
         */
        threadSleep();
        driver.findElement(By.xpath("//*[@id='core_page']/div[2]/div[1]/div/div[3]/a[2]")).click();

        /**
         * Doctors
         */
        threadSleep();
        driver.findElement(By.xpath("//*[@id='core_page']/div[2]/div[1]/div/div[3]/a[3]")).click();

        /**
         * Patients
         */
        threadSleep();
        driver.findElement(By.xpath("//*[@id='core_page']/div[2]/div[1]/div/div[3]/a[4]")).click();

        /**
         * Right navigation
         *
         * Create New Order
         */
        threadSleep();
        driver.findElement(By.xpath("//*[@id='core_page']/div[2]/div[3]/div/a[1]")).click();

        /**
         * Close the lightbox
         */
        threadSleep();
        driver.findElement(By.xpath("//*[@id='lightbox_close']/a/i")).click();

        /**
         * Create new patient
         */
        threadSleep();
        driver.findElement(By.xpath("//*[@id='core_page']/div[2]/div[3]/div/a[2]")).click();

        /**
         * Close the lightbox
         */
        threadSleep();
        driver.findElement(By.xpath("//*[@id='lightbox_close']/a/i")).click();

        /**
         * View All Orders
         */
        threadSleep();
        driver.findElement(By.xpath("//*[@id='core_page']/div[2]/div[3]/div/a[3]")).click();

        /**
         * Close the lightbox
         */
        threadSleep();
        driver.findElement(By.xpath("//*[@id='lightbox_close']/a/i")).click();

        /**
         * View All Patients
         */
        threadSleep();
        driver.findElement(By.xpath("//*[@id='core_page']/div[2]/div[3]/div/a[4]")).click();

        /**
         * Close the lightbox
         */
        threadSleep();
        driver.findElement(By.xpath("//*[@id='lightbox_close']/a/i")).click();

        /**
         * Visit Reporting Center
         */
        threadSleep();
        driver.findElement(By.xpath("//*[@id='core_page']/div[2]/div[3]/div/a[5]")).click();

        /**
         * Close the lightbox
         */
        threadSleep();
        driver.findElement(By.xpath("//*[@id='lightbox_close']/a/i")).click();

        /**
         * Main Navigation
         *
         * Administration
         */
        threadSleep();
        driver.findElement(By.xpath("//*[@id='menu_admin']/a")).click();

        /**
         * Return Home
         */
        threadSleep();
        driver.findElement(By.xpath("//*[@id='core_logo']")).click();

        /**
         * Reports
         */
        threadSleep();
        driver.findElement(By.xpath("//*[@id='core_navigation']/div[4]/a")).click();

        /**
         * Return Home
         */
        threadSleep();
        driver.findElement(By.xpath("//*[@id='core_logo']")).click();

        /**
         * User Preferences
         */
        threadSleep();
        driver.findElement(By.xpath("//*[@id='core_navigation']/div[5]/a")).click();

        /**
         * Laboratory Settings
         */
        threadSleep();
        driver.findElement(By.xpath("//*[@id='laboratory_settings_top']/a[3]")).click();

        /**
         * Account Settings
         */
        threadSleep();
        driver.findElement(By.xpath("//*[@id='laboratory_settings_top']/a[4]")).click();

        /**
         * System Settings
         */
        threadSleep();
        driver.findElement(By.xpath("//*[@id='laboratory_settings_top']/a[5]")).click();

        /**
         * Return Home
         */
        threadSleep();
        driver.findElement(By.xpath("//*[@id='core_logo']")).click();

        /**
         * Messages
         */
        threadSleep();
        driver.findElement(By.xpath("//*[@id='core_navigation']/div[6]/a")).click();

        /**
         * Return Home
         */
        threadSleep();
        driver.findElement(By.xpath("//*[@id='core_logo']")).click();

        /**
         * Help
         */
        //threadSleep();
        //driver.findElement(By.xpath("//*[@id=\"core_navigation\"]/div[7]/a")).click();

        /**
         * Return Home
         */
        //threadSleep();
        //driver.findElement(By.xpath("//*[@id=\"core_logo\"]")).click();
        /**
         * Logout
         */
        threadSleep();
        driver.findElement(By.xpath("//*[@id='logout_form']/a")).click();

    }
}