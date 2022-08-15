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
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import org.openqa.selenium.devtools.v100.input.Input;



public class Registrar {
    public WebDriver driver;
    public WebDriver driver1;
    By Email = By.id("email");
    By Password = By.id("passwd");
    By registerPage = By.xpath("//img[@src='http://automationpractice.com/img/logo.jpg']");
    By createUser= By.id("customer_firstname");
    By RegisterButtom=By.id("submitAccount");


    @Before
public void SetUp() {
    System.setProperty("webdriver.chrome.driver", "./src/test/resources/Chromedriver/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("http://automationpractice.com/index.php");

}

@Test
public void Registrar() {
   
 driver.findElement(By.cssSelector("a.login")).click();
 //Thread.sleep(2000);
 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   if (driver.findElement(registerPage).isDisplayed()) {
    WebElement EmailBox = driver.findElement(By.name("email_create"));
    EmailBox.clear();
    EmailBox.sendKeys("scampos@gmail.com");
    EmailBox.submit();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   }

   if (driver.findElement(registerPage).isDisplayed()) {
    WebElement selectBox=driver.findElement(By.id("uniform-id_gender1"));
    selectBox.click();
    driver.findElement(createUser).sendKeys("Steven");;
    
    WebElement lastname =driver.findElement(By.name("customer_lastname"));
    lastname.sendKeys("Campos");

    WebElement passBox = driver.findElement(By.name("passwd"));

    passBox.sendKeys("steven12334");


     //DATE BIRTH
    Select date = new Select(driver.findElement(By.id("days")));
    String option= "31";
    date.selectByValue(option);
    Select month = new Select(driver.findElement(By.id("months")));
    String monthop="7";
    month.selectByValue(monthop);
    Select years = new Select(driver.findElement(By.id("years")));
    String yearsop="2002";
    years.selectByValue(yearsop);

    WebElement selectBox1=driver.findElement(By.id("newsletter"));
    selectBox1.click();
    WebElement selectBox2=driver.findElement(By.id("optin"));
    selectBox2.click();  

    WebElement CompanyBox = driver.findElement(By.name("company"));
    CompanyBox.sendKeys("Fidelitas");

    WebElement AddressBox = driver.findElement(By.name("address1"));
    AddressBox.sendKeys("45 street");

    WebElement AddressBox1 = driver.findElement(By.name("address2"));
    AddressBox1.sendKeys("New York");

    WebElement city = driver.findElement(By.name("city"));
    city.sendKeys("New York Place");

    Select idstateBox = new Select(driver.findElement(By.id("id_state")));
    String idstateop="4";
    idstateBox.selectByValue(idstateop);

    WebElement postcodeBox = driver.findElement(By.name("postcode"));
    postcodeBox.sendKeys("11010");


    WebElement otherBox = driver.findElement(By.name("other"));
    otherBox.sendKeys("45 street lane red house ");

    WebElement phoneBox = driver.findElement(By.name("phone"));
    phoneBox.sendKeys("87078564");


    WebElement mobileBox = driver.findElement(By.name("phone_mobile"));
    mobileBox.sendKeys("84521475");

    WebElement aliasBox = driver.findElement(By.name("alias"));
    aliasBox.clear();
    aliasBox.sendKeys("NewYork Home");
    driver.findElement(RegisterButtom).click();;
    JOptionPane.showMessageDialog(null, "Caso de prueba: Registrar");

}else {
    System.out.print("Register page was not found");

   }

}

}

