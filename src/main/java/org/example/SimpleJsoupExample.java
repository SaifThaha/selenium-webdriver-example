package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SimpleJsoupExample {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
//        System.setProperty("webdriver.chrome.driver","C:\\Users\\saifm\\Downloads\\chrome-win64\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Open the webpage
        driver.get("https://www.amazon.com/sp?seller=A3469ZEJ0ZUWXU");

        WebElement element = driver.findElement(By.id("page-section-detail-seller-info"));
        List<WebElement> elementList = element.findElements(By.tagName("span"));
//        elementList.forEach(webElement -> System.out.println(webElement.getText()));
        for(WebElement span:elementList){
            String classAttribute = span.getAttribute("class");
            if(classAttribute == null || !classAttribute.contains("a-text-bold")){
                System.out.println(span.getText());
            }
        }
    }
}