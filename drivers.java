package test.java.com.account;

//import static org.junit.Assert.fail;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class drivers {

    public HashMap<String, String> data = new HashMap<>();

    public RemoteWebDriver driver;

    //variables for use throughout testing
    protected String baseURL = "http://qalab.chroma.software/";
    public int runId;
    public int caseId;
    protected String fromWhence;
    protected String passedResults = "";
    protected String failedResults = "";
    protected String compareResults = "";
    protected String failedCompareResults = "";
    protected String passedResultsInsurance = "";
    protected String failedResultsInsurance = "";
    protected String hoverAndClick;
    protected String returnURL;
    protected String portalUser = "jim@cmeintegrations.com";
    protected String password ="NicVoacurkEtyo9";
    protected String portalTestType = "";

    //thread sleep function
    public void threadSleep(int threadDefault) {

        try {

            Thread.sleep(threadDefault);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void threadSleep() {

        threadSleep(1000);
    }

    /**
     * hover
     *
     * @param driver
     * @param element
     */

    public static void hover(WebDriver driver, WebElement element) {

        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    /**
     * hover and click
     *
     * @param driver
     * @param elementToHover
     * @param elementToClick
     */

    public static void hoverAndClick(WebDriver driver,WebElement elementToHover,WebElement elementToClick) {
        Actions action = new Actions(driver);
        action.moveToElement(elementToHover).click(elementToClick).build().perform();
    }

    static String username = "jim%40chroma-solutions.com"; // Your username
    static String authkey = "uf2a230a16358fa4";  // Your authkey
    String testScore = "unset";

    /**
     *The primary test procedure (extended by siblings).
     */

    public void Run() {}

    /**
     * functions that declare browser configurations we are testing in 3 major browsers, Chrome, Firefox and Edge
     * setting up some loading management protocols
     */
    public void SetupChrome()
    {

        try {

            DesiredCapabilities caps = new DesiredCapabilities();

            caps.setCapability("name", "Kinetix LIS Portal Chrome Testing" + portalTestType);
            caps.setCapability("build", "1.0");
            caps.setCapability("browserName", "Chrome");
            caps.setCapability("version", "63x64");
            caps.setCapability("platform", "Windows 10");
            caps.setCapability("screenResolution", "1920x1080");
            caps.setCapability("record_video", "true");
            caps.setCapability("record_network", "true");

            driver = new RemoteWebDriver(new URL("http://" + username + ":" + authkey +"@hub.crossbrowsertesting.com:80/wd/hub"), caps);
            System.out.println(driver.getSessionId());

        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
    }
    public void SetupFirefox()
    {

        try {

            DesiredCapabilities caps = new DesiredCapabilities();

            caps.setCapability("name", "Kinetix LIS Portal Firefox Testing");
            caps.setCapability("build", "1.0");
            caps.setCapability("browserName", "Firefox");
            caps.setCapability("version", "57x64");
            caps.setCapability("platform", "Windows 10");
            caps.setCapability("screenResolution", "1920x1080");
            caps.setCapability("record_video", "true");
            caps.setCapability("record_network", "true");

            driver = new RemoteWebDriver(new URL("http://" + username + ":" + authkey +"@hub.crossbrowsertesting.com:80/wd/hub"), caps);
            System.out.println(driver.getSessionId());

        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
    }
    public void SetupEdge()
    {

        try {

            DesiredCapabilities caps = new DesiredCapabilities();

            caps.setCapability("name", "Kinetix LIS Portal Edge Testing");
            caps.setCapability("build", "1.0");
            caps.setCapability("browserName", "MicrosoftEdge");
            caps.setCapability("version", "16");
            caps.setCapability("platform", "Windows 10");
            caps.setCapability("screenResolution", "1920x1080");
            caps.setCapability("record_video", "true");
            caps.setCapability("record_network", "true");

            driver = new RemoteWebDriver(new URL("http://" + username + ":" + authkey +"@hub.crossbrowsertesting.com:80/wd/hub"), caps);
            System.out.println(driver.getSessionId());

        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Creating functions to make life easier when we want to
     * choose what build runs to switch on and off
     */
    public void getChrome() throws Exception{

        try {
            System.out.println("Chrome Starts");
            SetupChrome();
            Run();

            /**
             * Printing out the actual test score to make sure we track our unset value and make sure we see an actual change
             * expected behavior is testScore is unset, testScore is pass
             */
            System.out.print(testScore + "I am chrome passing");
                testScore = "pass";

        } catch (Exception ae) {
            /**
             * If there is a failure want to have status's and messages to help us debug
             * we want to print out the session id
             * we want to send that snapshot to crossbrowswertesting
             * we want to set the description along with a visual snapshot of the point of failure
             * we want to print out i am failing in our IDE console and what browser it failed in
             * we want to set the crossbrowsertesting status to fail
             */
                System.out.print(driver.getSessionId().toString());
                String snapshotHash = takeSnapshot(driver.getSessionId().toString());
                setDescription(driver.getSessionId().toString(), snapshotHash, ae.toString());
                System.out.print(testScore + "I am chrome failing ");
                testScore = "fail";
        }
        finally{
            /**
             * we want to now actually print out that test complete has truly failed
             */
            System.out.println("Test complete:" + testScore);

            //here we make an api call to actually send the score
            setScore(driver.getSessionId().toString(), testScore);

            //and quit the driver
            driver.quit();
        }
    }

    public void getfirefox() throws Exception{
        //String testScore = "unset";
        try {
            System.out.println("Firefox Starts");
            SetupFirefox();
            Run();

            /**
             * Printing out the actual test score to make sure we track our unset value and make sure we see an actual change
             * expected behavior is testScore is unset, testScore is pass
             */
            System.out.print(testScore + "I am Firefox passing");
                testScore = "pass";

        } catch (Exception ae) {
            /**
             * If there is a failure want to have status's and messages to help us debug
             * we want to print out the session id
             * we want to send that snapshot to crossbrowswertesting
             * we want to set the description along with a visual snapshot of the point of failure
             * we want to print out i am failing in our IDE console and what browser it failed in
             * we want to set the crossbrowsertesting status to fail
             */
                System.out.print(driver.getSessionId().toString());
                String snapshotHash = takeSnapshot(driver.getSessionId().toString());
                setDescription(driver.getSessionId().toString(), snapshotHash, ae.toString());
                System.out.print(testScore + "I am Firefox failing ");
                testScore = "fail";
        }
        finally{
            /**
             * we want to now actually print out that test complete has truly failed
             */
            System.out.println("Test complete:" + testScore);

            //here we make an api call to actually send the score
            setScore(driver.getSessionId().toString(), testScore);

            //and quit the driver
            driver.quit();
        }
    }

    public void getEdge() throws Exception{
        try {
            System.out.println("Edge Starts");
            SetupEdge();
            Run();

            /**
             * Printing out the actual test score to make sure we track our unset value and make sure we see an actual change
             * expected behavior is testScore is unset, testScore is pass
             */
                System.out.print(testScore + "I am Edge passing ");
                testScore = "Pass";
        } catch (Exception e) {
            /**
             * If there is a failure want to have status's and messages to help us debug
             * we want to print out the session id
             * we want to send that snapshot to crossbrowswertesting
             * we want to set the description along with a visual snapshot of the point of failure
             * we want to print out i am failing in our IDE console and what browser it failed in
             * we want to set the crossbrowsertesting status to fail
             */
                System.out.print(driver.getSessionId().toString());
                String snapshotHash = takeSnapshot(driver.getSessionId().toString());
                setDescription(driver.getSessionId().toString(), snapshotHash, e.toString());
                System.out.print(testScore + "I am Edge failing ");
                testScore = "fail";
        }
        finally{
            /**
             * we want to now actually print out that test complete has truly failed
             */
            System.out.println("Test complete:" + testScore);

            //here we make an api call to actually send the score
            setScore(driver.getSessionId().toString(), testScore);

            //and quit the driver
            driver.quit();
        }
    }

    /**
     * @throws Exception
     */
    @Test
    public void Handle() throws Exception {

        /**
         * here we actually execute the functions declared earlier in the code.
         * this gives us the ability to easily turn our code on and off.
         */

            getChrome();
            //getfirefox();
            //getEdge();

    }

    /**
     * down here we are doing our configuration to actually send the data we have to the appropraite places.
     */
    public JsonNode setScore(String seleniumTestId, String score) throws UnirestException
    {
        // Mark a Selenium test as Pass/Fail
        HttpResponse<JsonNode> response = Unirest.put("http://crossbrowsertesting.com/api/v3/selenium/{seleniumTestId}")
                .basicAuth(username, authkey)
                .routeParam("seleniumTestId", seleniumTestId)
                .field("action","set_score")
                .field("score", score)
                .asJson();
        return response.getBody();
    }

    public String takeSnapshot(String seleniumTestId) throws UnirestException
    {
        /*
         * Takes a snapshot of the screen for the specified test.
         * The output of this function can be used as a parameter for setDescription()
         */
        HttpResponse<JsonNode> response = Unirest.post("http://crossbrowsertesting.com/api/v3/selenium/{seleniumTestId}/snapshots")
                .basicAuth(username, authkey)
                .routeParam("seleniumTestId", seleniumTestId)
                .asJson();
        // grab out the snapshot "hash" from the response
        String snapshotHash = (String) response.getBody().getObject().get("hash");

        return snapshotHash;
    }

    public JsonNode setDescription(String seleniumTestId, String snapshotHash, String description) throws UnirestException
    {
        /*
         * sets the description for the given seleniemTestId and snapshotHash
         */
        HttpResponse<JsonNode> response = Unirest.put("http://crossbrowsertesting.com/api/v3/selenium/{seleniumTestId}/snapshots/{snapshotHash}")
                .basicAuth(username, authkey)
                .routeParam("seleniumTestId", seleniumTestId)
                .routeParam("snapshotHash", snapshotHash)
                .field("description", description)
                .asJson();
        return response.getBody();
    }
}
