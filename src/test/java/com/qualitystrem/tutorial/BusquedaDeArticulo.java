package com.qualitystrem.tutorial;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v100.input.Input;

public class BusquedaDeArticulo {
    public WebDriver driver;
    public WebDriver driver1;
    By Email = By.id("email");
    By Password = By.id("passwd");
    By registerPage = By.xpath("//img[@src='http://automationpractice.com/img/logo.jpg']");

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/Chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php?controller=order");

    }
    
    @Test
    public void BusquedaDeArticulo() {
        WebElement searchbox = driver.findElement(By.name("search_query"));
        searchbox.clear();
        searchbox.sendKeys("Printed Chiffon Dress");
        searchbox.submit();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertEquals("Search - My Store", driver.getTitle());
        JOptionPane.showMessageDialog(null, "Caso de prueba: Busqueda de articulo exitosa");

    }
    
}
