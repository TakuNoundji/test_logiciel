package org.example.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class Page {
    // commentaire
    protected WebDriver driver;

    private String path = "src/test/resources/driver/chromedriver.exe";

    Page(){
        System.setProperty("webdriver.chrome.driver",this.path);
        this.driver = new ChromeDriver();
        PageFactory.initElements(this.driver,this);
    }
    public void get(String url){
        this.driver.get(url);
    }
}
