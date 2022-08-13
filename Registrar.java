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




public class Registrar {
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
    driver.get("http://automationpractice.com/index.php");

}

public static String[] generarNombresAleatorios(int cantidad) {
    
   
    String[] nombresAleatorios = new String[cantidad];

    String[] nombres = { "Andrea", "David", "Baldomero", "Balduino", "Baldwin", "Baltasar", "Barry", "Bartolo",
            "Bartolomé", "Baruc", "Baruj", "Candelaria", "Cándida", "Canela", "Caridad", "Carina", "Carisa",
            "Caritina", "Carlota", "Baltazar"};
    String[] apellidos = { "Gomez", "Guerrero", "Cardenas", "Cardiel", "Cardona", "Cardoso", "Cariaga", "Carillo",
            "Carion", "Castiyo", "Castorena", "Castro", "Grande", "Grangenal", "Grano", "Grasia", "Griego",
            "Grigalva" };

    for (int i = 0; i < cantidad; i++) {
        nombresAleatorios[i] = nombres[(int) (Math.floor(Math.random() * ((nombres.length - 1) - 0 + 1) + 0))] + " "
                + apellidos[(int) (Math.floor(Math.random() * ((apellidos.length - 1) - 0 + 1) + 0))];
    }
    return nombresAleatorios;
}
@Test
public void Registrar() {
   
 driver.findElement(By.cssSelector("a.login")).click();
 WebElement EmailBox = driver.findElement(By.name("email_create"));
EmailBox.clear();
EmailBox.sendKeys("scampos@gmail.com");
EmailBox.submit();


WebElement itemBox =driver.findElement(By.name("uniform-id_gender1"));
itemBox.click();
WebElement nameBox = driver.findElement(By.id("customer_firstname"));
    nameBox.clear();
    nameBox.sendKeys("Steven");
WebElement passBox = driver.findElement(By.name("passwd"));
passBox.clear();
passBox.sendKeys("steven12334");

//NO SE HACER MESES
WebElement FirstName =driver.findElement(By.name("firstname"));
FirstName.clear();
FirstName.sendKeys("Steven");
WebElement lastname =driver.findElement(By.name("lastname"));
lastname.clear();
lastname.sendKeys("Campos");

WebElement company =driver.findElement(By.name("company"));
company.clear();
company.sendKeys("UIA");
WebElement address1 =driver.findElement(By.name("address1"));
address1.clear();
address1.sendKeys("moravia");
WebElement city =driver.findElement(By.name("city"));
city.clear();
city.sendKeys("San Jose");
///hacer STATE 
WebElement postcode =driver.findElement(By.name("postcode"));
city.clear();
city.sendKeys("102154");
//HACER COUNTRY
WebElement otherBox =driver.findElement(By.name("other"));
otherBox.clear();
otherBox.sendKeys("other");
WebElement phoneWebElement =driver.findElement(By.name("phone"));
phoneWebElement.clear();
phoneWebElement.sendKeys("87075246");
WebElement phone_mobileWebElement =driver.findElement(By.name("phone_mobile"));
phone_mobileWebElement.clear();
phone_mobileWebElement.sendKeys("87085246");
driver.findElement(By.id("Register")).click();



}

}

