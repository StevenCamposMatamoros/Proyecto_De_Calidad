package com.qualitystrem.tutorial;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Modificar {
    public WebDriver driver;
    By CategoryDressesLocator = By.linkText("DRESSES");
    By DressesPageLocator = By.xpath("//img[@src=\"http://automationpractice.com/img/c/9-medium_default.jpg\"]");
    By PrintedDress = By.linkText("Printed Dress");
    By PrintedDressPageLocator = By.xpath("//img[@src=\"http://automationpractice.com/img/p/8/8-large_default.jpg\"]");
    By QuantityLocator = By.name("qty");
    By DropDownListSize = By.id("group_1");
    By AddToCartLocator = By.name("Submit");

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/Chromedriver/chromedriver.exe");// para que
        driver = new ChromeDriver(); // establezco el objeto como Chrome Driver//
        driver.manage().window().maximize(); // maximizar lo ejecutado en ventana utilizando el instanciador de chrome//
        driver.get("http://automationpractice.com/index.php?controller=my-account"); // le envia la URL que debe abrir//
    }

    @After
    public void tearDown() throws Exception {
        // driver.quit(); //para cerrar el browser //
    }

    @Test
    public void ModificarProd() throws InterruptedException {
        driver.findElement(CategoryDressesLocator).click();
        Thread.sleep(2000);
        if (driver.findElement(DressesPageLocator).isDisplayed()) {
            driver.findElement(PrintedDress).click();
            if (driver.findElement(PrintedDressPageLocator).isDisplayed()) {
                driver.findElement(QuantityLocator).clear();
                driver.findElement(QuantityLocator).sendKeys("3");
                Select selectList = new Select(driver.findElement(By.id("group_1")));
                String option = "2";
                selectList.selectByValue(option);
                driver.findElement(AddToCartLocator).click();

            } else {

                System.out.print("No funciona");
            }

        }

    }
}



