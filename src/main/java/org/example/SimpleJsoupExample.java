package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class SimpleJsoupExample {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
//        System.setProperty("webdriver.chrome.driver","C:\\Users\\saifm\\Downloads\\chrome-win64\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.0.0 Safari/537.36");
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver(options);

        // Open the webpage
        driver.get("https://www.amazon.com/sp?seller=A3469ZEJ0ZUWXU");

        WebElement parentElement = driver.findElement(By.id("page-section-detail-seller-info"));
        WebElement childElement = parentElement.findElement(By.cssSelector(".a-box-inner.a-padding-medium"));
        List<WebElement> divElements = childElement.findElements(By.tagName("div"));

        for(WebElement div:divElements){
            List<WebElement> spanElements = div.findElements(By.tagName("span"));

            for (WebElement span:spanElements){
                String spanText = span.getText();
                if (!spanText.equals("Business Name:") && !spanText.equals("Business Address:")) {
                    System.out.println(spanText);
                }
            }
        }
//        List<WebElement> elementList = element.findElements(By.tagName("span"));
//
//        for(WebElement span:elementList){
//            String classAttribute = span.getAttribute("class");
//            if(classAttribute == null || !classAttribute.contains("a-text-bold")){
//                System.out.println(span.getText());
//            }
//        }
    }
}