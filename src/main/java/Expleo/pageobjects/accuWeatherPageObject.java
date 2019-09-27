package Expleo.pageobjects;

public class accuWeatherPageObject {
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

    public void printBothTemps()
    {
        for(int i =0; i <5; i++) {
            System.out.println("AccuWeather - Day" + (i + 1) + " Maximum Temperature: " + maxTemp[i] + " Minimum Temperature: " + minTemp[i]);
        }
    }
}
