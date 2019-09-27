package Expleo.testcases;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import Expleo.pageobjects.weather24PageObject;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.fail;

public class testWeather24 {


        private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();

        @Before
        public void setUp() throws Exception {

            System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
            String baseUrl = "http://weather.news24.com";
            String expectedURL = "http://weather.news24.com/";
            driver.get(baseUrl);
            // String actualTitle = driver.getTitle();
            String actualURL = driver.getCurrentUrl();
            System.out.println("Actual URL is: " + actualURL);
            Assert.assertEquals(actualURL, expectedURL);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        @Test
        public void testWeather() throws Exception {
            weather24PageObject weather = PageFactory.initElements(driver, weather24PageObject.class);

            driver.findElement(By.xpath(".//*[@id='ctl00_WeatherContentHolder_ddlCity']")).click();
            driver.findElement(By.xpath(".//*[@id='ctl00_WeatherContentHolder_ddlCity']/option[73]")).click();
            driver.findElement(By.xpath(".//*[@id='ctl00_WeatherContentHolder_btnGo']")).click();
            driver.findElement(By.xpath(".//*[@id='ext-gen28']")).click();

            String currentMaxTemp = driver.findElement(By.xpath(".//*[@id='forecastContent']/table/tbody/tr[3]/td[4]")).getText();
            weather.addMaxTemp(0, Integer.parseInt(currentMaxTemp.substring(0, 2)));
            String currentMinTemp = driver.findElement(By.xpath(".//*[@id='forecastContent']/table/tbody/tr[3]/td[5]")).getText();
            weather.addMinTemp(0, Integer.parseInt(currentMinTemp.substring(0,1)));

            String Day2MaxTemp = driver.findElement(By.xpath(".//*[@id='forecastContent']/table/tbody/tr[4]/td[4]")).getText();
            weather.addMaxTemp(1, Integer.parseInt(Day2MaxTemp.substring(0, 2)));
            String Day2MinTemp = driver.findElement(By.xpath(".//*[@id='forecastContent']/table/tbody/tr[4]/td[5]")).getText();
            weather.addMinTemp(1, Integer.parseInt(Day2MinTemp.substring(0, 1)));

            String Day3MaxTemp = driver.findElement(By.xpath(".//*[@id='forecastContent']/table/tbody/tr[5]/td[4]")).getText();
            weather.addMaxTemp(2, Integer.parseInt(Day3MaxTemp.substring(0, 2)));
            String Day3MinTemp = driver.findElement(By.xpath(".//*[@id='forecastContent']/table/tbody/tr[5]/td[5]")).getText();
            weather.addMinTemp(2, Integer.parseInt(Day3MinTemp.substring(0, 2)));

            String Day4MaxTemp = driver.findElement(By.xpath(".//*[@id='forecastContent']/table/tbody/tr[6]/td[4]")).getText();
            weather.addMaxTemp(3, Integer.parseInt(Day4MaxTemp.substring(0, 2)));
            String Day4MinTemp = driver.findElement(By.xpath(".//*[@id='forecastContent']/table/tbody/tr[6]/td[5]")).getText();
            weather.addMinTemp(3, Integer.parseInt(Day4MinTemp.substring(0, 2)));

            String Day5MaxTemp = driver.findElement(By.xpath(".//*[@id='forecastContent']/table/tbody/tr[7]/td[4]")).getText();
            weather.addMaxTemp(4, Integer.parseInt(Day5MaxTemp.substring(0, 2)));
            String Day5MinTemp = driver.findElement(By.xpath(".//*[@id='forecastContent']/table/tbody/tr[7]/td[5]")).getText();
            weather.addMinTemp(4, Integer.parseInt(Day5MinTemp.substring(0, 2)));



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
