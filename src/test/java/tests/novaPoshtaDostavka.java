package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class novaPoshtaDostavka {

    @Test

    public void terminDostavki() throws Exception {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://novaposhta.ua/onlineorder/estimatedate");
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

        String expectedResult = "16 вересня 2017";

        driver.findElement(By.id("EstimateDateForm_ServiceType")).click();
        driver.findElement(By.cssSelector("#EstimateDateForm_ServiceType")).click();
        driver.findElement(By.xpath(".//input[@id='EstimateDateForm_ServiceType']")).click();
        driver.findElement(By.xpath(".//input[@id='EstimateDateForm_ServiceType']/following-sibling::div//*[text()='Відділення-Відділення']")).click();
        driver.findElement(By.xpath(".//*[@id='EstimateDateForm_senderCity']")).sendKeys("Тернопіль");
        driver.findElement(By.xpath(".//input[@id='EstimateDateForm_senderCity']/following-sibling::div//*[text()='Тернопіль']")).click();
        driver.findElement(By.xpath(".//*[@id='EstimateDateForm_recipientCity']")).sendKeys("Ковель");
        driver.findElement(By.xpath(".//input[@id='EstimateDateForm_recipientCity']/following-sibling::div//*[text()='Ковель']")).click();
        driver.findElement(By.xpath(".//input[@class='btn submit']")).click();

        String actualResult = driver.findElement(By.xpath(".//div[@class='response']//b")).getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();


    }

}
