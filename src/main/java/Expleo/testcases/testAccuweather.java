package Expleo.testcases;

import Expleo.pageobjects.accuWeatherPageObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class testAccuweather
{
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    @Before
    public void setUp() throws Exception {

        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
        String baseUrl = "http://www.accuweather.com/";
        String expectedURL = "https://www.accuweather.com/";
        driver.get(baseUrl);
        // String actualTitle = driver.getTitle();
        String actualURL = driver.getCurrentUrl();
        System.out.println("Actual URL is: " + actualURL);
        Assert.assertEquals(actualURL, expectedURL);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testAccWeather() throws Exception {
        accuWeatherPageObject weather = PageFactory.initElements(driver, accuWeatherPageObject.class);

        //get min and max temps
        driver.findElement(By.xpath("./html/body/div/div[1]/div[2]/div[1]/form/input")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("query")).sendKeys("Pretoria");
        driver.findElement(By.name("query")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("./html/body/div/div[5]/div/div[1]/div[1]/div[1]/a[1]")).click();
        driver.findElement(By.xpath("./html/body/div/div[4]/div/div/div[3]/a[4]/span")).click();

        String Acc1MaxTemp = driver.findElement(By.xpath("./html/body/div/div[5]/div/div[1]/div/div[1]/a[1]/div[2]/span[1]")).getText();
        weather.addMaxTemp(0, Integer.parseInt(Acc1MaxTemp.substring(0, 2)));
        String Acc1MinTemp = driver.findElement(By.xpath("./html/body/div/div[5]/div/div[1]/div/div[1]/a[1]/div[2]/span[2]")).getText();
        weather.addMinTemp(0, Integer.parseInt(Acc1MinTemp.substring(1,3)));

        String Acc2MaxTemp = driver.findElement(By.xpath("./html/body/div/div[5]/div/div[1]/div/div[1]/a[2]/div[2]/span[1]")).getText();
        weather.addMaxTemp(0, Integer.parseInt(Acc2MaxTemp.substring(0, 2)));
        String Acc2MinTemp = driver.findElement(By.xpath("./html/body/div/div[5]/div/div[1]/div/div[1]/a[2]/div[2]/span[2]")).getText();
        weather.addMinTemp(0, Integer.parseInt(Acc2MinTemp.substring(0,1)));

        String Acc3MaxTemp = driver.findElement(By.xpath("./html/body/div/div[5]/div/div[1]/div/div[1]/a[3]/div[2]/span[1]")).getText();
        weather.addMaxTemp(0, Integer.parseInt(Acc3MaxTemp.substring(0, 2)));
        String Acc3MinTemp = driver.findElement(By.xpath("./html/body/div/div[5]/div/div[1]/div/div[1]/a[3]/div[2]/span[2]")).getText();
        weather.addMinTemp(0, Integer.parseInt(Acc3MinTemp.substring(0,1)));

        String Acc4MaxTemp = driver.findElement(By.xpath("./html/body/div/div[5]/div/div[1]/div/div[1]/a[4]/div[2]/span[1]")).getText();
        weather.addMaxTemp(0, Integer.parseInt(Acc4MaxTemp.substring(0, 2)));
        String Acc4MinTemp = driver.findElement(By.xpath("./html/body/div/div[5]/div/div[1]/div/div[1]/a[4]/div[2]/span[2]")).getText();
        weather.addMinTemp(0, Integer.parseInt(Acc4MinTemp.substring(0,1)));

        String Acc5MaxTemp = driver.findElement(By.xpath("./html/body/div/div[5]/div/div[1]/div/div[1]/a[5]/div[2]/span[1]")).getText();
        weather.addMaxTemp(0, Integer.parseInt(Acc5MaxTemp.substring(0, 2)));
        String Acc5MinTemp = driver.findElement(By.xpath("./html/body/div/div[5]/div/div[1]/div/div[1]/a[5]/div[2]/span[2]")).getText();
        weather.addMinTemp(0, Integer.parseInt(Acc5MinTemp.substring(0,1)));

        weather.printBothTemps();

    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
