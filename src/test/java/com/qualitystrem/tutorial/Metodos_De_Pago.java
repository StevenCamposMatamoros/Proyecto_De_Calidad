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

public class Metodos_De_Pago {

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
    public void Metodo_De_Pago_Transferencia_Bancaria() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.className("login")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Thread.sleep(2000);
        if (driver.findElement(registerPage).isDisplayed()) {
            WebElement Passwordbox = driver.findElement(By.id("passwd"));
            Passwordbox.clear();
            Passwordbox.sendKeys("Apodemio1");
            WebElement EmailBox = driver.findElement(By.id("email"));
            EmailBox.clear();
            EmailBox.sendKeys("sebastianhernandezj1@gmail.com");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.id("SubmitLogin")).click();
        }
        WebElement searchbox = driver.findElement(By.name("search_query"));
        searchbox.clear();
        searchbox.sendKeys("Blouse");
        searchbox.submit();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertEquals("Search - My Store", driver.getTitle());
        driver.findElement(By.id("list")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        if (driver.findElement(registerPage).isDisplayed()) {
            driver.findElement(By.xpath("//*[@id='center_column']/ul/li/div/div/div[3]/div/div[2]/a[1]/span")).click();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")).click();
        driver.findElement(By.xpath("//*[@id='center_column']/p[2]/a[1]/span")).click();
        driver.findElement(By.xpath("//*[@id='center_column']/form/p/button/span")).click();
        driver.findElement(By.id("cgv")).click();
        driver.findElement(By.xpath("//*[@id='form']/p/button/span")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id='HOOK_PAYMENT']/div[1]/div/p/a")).click();
        driver.findElement(By.xpath("//*[@id='cart_navigation']/button/span")).click();
        JOptionPane.showMessageDialog(null, "Caso de prueba: Metodo de pago Transferencia Bancaria exitoso");

    }

    @Test
    public void Metodo_De_Pago_Cheque() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.className("login")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Thread.sleep(2000);
        if (driver.findElement(registerPage).isDisplayed()) {
            WebElement Passwordbox = driver.findElement(By.id("passwd"));
            Passwordbox.clear();
            Passwordbox.sendKeys("Apodemio1");
            WebElement EmailBox = driver.findElement(By.id("email"));
            EmailBox.clear();
            EmailBox.sendKeys("sebastianhernandezj1@gmail.com");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.id("SubmitLogin")).click();
        }
        WebElement searchbox = driver.findElement(By.name("search_query"));
        searchbox.clear();
        searchbox.sendKeys("Blouse");
        searchbox.submit();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertEquals("Search - My Store", driver.getTitle());
        driver.findElement(By.id("list")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        if (driver.findElement(registerPage).isDisplayed()) {
            driver.findElement(By.xpath("//*[@id='center_column']/ul/li/div/div/div[3]/div/div[2]/a[1]/span")).click();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")).click();
        driver.findElement(By.xpath("//*[@id='center_column']/p[2]/a[1]/span")).click();
        driver.findElement(By.xpath("//*[@id='center_column']/form/p/button/span")).click();
        driver.findElement(By.id("cgv")).click();
        driver.findElement(By.xpath("//*[@id='form']/p/button/span")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id='HOOK_PAYMENT']/div[2]/div/p/a")).click();
        driver.findElement(By.xpath("//*[@id='cart_navigation']/button/span")).click();
        JOptionPane.showMessageDialog(null, "caso de prueba: Metodo de pago Cheque exitoso");
    }
}
