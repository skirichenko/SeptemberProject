package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class sepClass {

    @Test

    public void testName() throws Exception {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://novaposhta.ua/delivery");
        //driver.manage().window().maximize();

        String expectedResult = "Разом: 65.00 грн *";


        driver.findElement(By.id("DeliveryForm_senderCity")).sendKeys("Київ");
        driver.findElement(By.xpath("//input[@id='DeliveryForm_senderCity']/following-sibling::div//*[text()='Київ']")).click();
        driver.findElement(By.id("DeliveryForm_recipientCity")).sendKeys("Одеса");
        driver.findElement(By.xpath("//input[@id='DeliveryForm_recipientCity']/following-sibling::div//*[text()='Одеса']")).click();

        driver.findElement(By.className("option_select")).click();
        driver.findElement(By.xpath("//*[text()='Адреса-Адреса']")).click();
        driver.findElement(By.xpath("//*[text()='Вантажі']")).click();
        driver.findElement(By.xpath("//div[@class='select cargo_type pallets_discs tp_this open']//*[text()='Документи']")).click();
        driver.findElement(By.xpath("//*[text()='Виберіть вагу']")).click();
        driver.findElement(By.xpath("//div[@class='select weight del_type open']//*[text()='0.5']")).click();
        driver.findElement(By.xpath(".//*[@id='DeliveryForm_publicPrice']")).sendKeys("100");
        driver.findElement(By.xpath(".//input[@class='btn submit']")).click();

        String actualResult = driver.findElement(By.className("final")).getText();

        Assert.assertEquals(expectedResult, actualResult);


    }


}
