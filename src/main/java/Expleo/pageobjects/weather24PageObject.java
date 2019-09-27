package Expleo.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebElement;


public class weather24PageObject
{
    private WebDriver driver;


    private int [] maxTemp = new int [5];
    private int [] minTemp = new int [5];

    public void addMaxTemp(int index, int maxTemp)
    {
        this.maxTemp[index] = maxTemp;
    }

    public void addMinTemp(int index, int minTemp)
    {
        this.minTemp[index] = minTemp;
    }

    public void printMaxTemp()
    {
        for(int i =0; i <5; i++) {
            System.out.println("Weather24 Day" + (i + 1) + ": Maximum Temperature: " + maxTemp[i]);
        }
    }

    public void printMinTemp()
    {
        for(int i =0; i <5; i++) {
            System.out.println("Weather24 - Day" + (i + 1) + ": Minimum Temperature: " + minTemp[i]);
        }
    }

    public void printBothTemps()
    {
        for(int i =0; i <5; i++) {
            System.out.println("Weather24 - Day" + (i + 1) + " Maximum Temperature: " + maxTemp[i] + " Minimum Temperature: " + minTemp[i]);
        }
    }




    @FindBy(how = How.CSS, using = "input[type=\"submit\"]")
    private WebElement Register;




}
