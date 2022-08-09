package com.qualitystrem.tutorial;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifBusqueda {
    public WebDriver driver;
    By WomenBtnLocator = By.className("sf-with-ul");
    By WomenPageLocator = By.xpath("//img[@src = \"http://automationpractice.com/modules/blockbanner/img/sale70.png\"]");
    By TopsLocator = By.linkText("TOPS");
    By TopsCategoryLocator = By.className("cat_desc");
    By TshirtsLocator = By.xpath("//img[@src=\"http://automationpractice.com/img/c/5-medium_default.jpg\"]");
    By TShirtCategoryLocator = By.className("content_scene_cat_bg");
    By ReturnTopsLocator = By.linkText("Tops");
    By BlousesLocator = By.linkText("BLOUSES");
    By BlousesCategoryLocator = By.className("content_scene_cat_bg");

    By DressesBtnLocator = By.linkText("DRESSES");
    By DressesPageLocator = By.className("content_scene_cat");
    By CasualLocator = By.linkText("CASUAL DRESSES");
    By CasualCategoryLocator = By.className("content_scene_cat_bg");
    By EveningLocator = By.linkText("EVENING DRESSES");
    By EveningCategoryLocator = By.className("content_scene_cat_bg");
    By SummerLocator = By.linkText("SUMMER DRESSES");
    By SummerCategoryLocator = By.className("content_scene_cat_bg");

    By HomeLocator = By.id("header_logo");
    By HomePageLocator = By.xpath("//img[@src=\"http://automationpractice.com/modules/themeconfigurator/img/banner-img6.jpg\"]");
    By PopularLocator = By.className("homefeatured");
    By BestSellersLocator = By.className("blockbestsellers");
    By TopTrendsLocator = By.xpath("//img[@src=\"http://automationpractice.com/modules/themeconfigurator/img/banner-img1.jpg\"]");
    By MensLocator = By.xpath("//img[@src=\"http://automationpractice.com/modules/themeconfigurator/img/banner-img2.jpg\"]");
    By WomensLocator = By.xpath("//img[@src=\"http://automationpractice.com/modules/themeconfigurator/img/banner-img3.jpg\"]");
    By GlassesLocator = By.xpath("//img[@src=\"http://automationpractice.com/modules/themeconfigurator/img/banner-img4.jpg\"]");
    By TrendsLocator = By.xpath("//img[@src=\"http://automationpractice.com/modules/themeconfigurator/img/banner-img5.jpg\"]");

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
    public void VerifBusquedaWomen() throws Exception {
        driver.findElement(WomenBtnLocator).click();
        Thread.sleep(2000);
        if (driver.findElement(WomenPageLocator).isDisplayed()) {
            driver.findElement(TopsLocator).click();
            if (driver.findElement(TopsCategoryLocator).isDisplayed()) {
                driver.findElement(TshirtsLocator).click();
                if (driver.findElement(TShirtCategoryLocator).isDisplayed()) {
                    System.out.print("Categoría T Shirt testeada correctamente");
                }
                driver.findElement(ReturnTopsLocator).click();
                if (driver.findElement(TopsCategoryLocator).isDisplayed()) {
                    driver.findElement(BlousesLocator).click();
                    if (driver.findElement(BlousesCategoryLocator).isDisplayed()) {
                        System.out.print("Categoría Blouses testeada correctamente");
                    }
                }

            }

        }
    }

    public void VerifBusquedaDresses() throws Exception {
        driver.findElement(DressesBtnLocator).click();
        Thread.sleep(2000);
        if (driver.findElement(DressesPageLocator).isDisplayed()) {
            driver.findElement(CasualLocator).click();
            if (driver.findElement(CasualCategoryLocator).isDisplayed()) {
                System.out.print("Categoría Casual Dresses testeada correctamente");
            }
            driver.findElement(DressesBtnLocator).click();
            if (driver.findElement(DressesPageLocator).isDisplayed()) {
                driver.findElement(EveningLocator).click();
                if (driver.findElement(EveningCategoryLocator).isDisplayed()) {
                    System.out.print("Categoría Evening Dresses testeada correctamente");
                }

            }
            driver.findElement(DressesBtnLocator).click();
            if (driver.findElement(DressesPageLocator).isDisplayed()) {
                driver.findElement(SummerLocator).click();
                if (driver.findElement(SummerCategoryLocator).isDisplayed()) {
                    System.out.print("Categoría Summer Dresses testeada correctamente");
                }

            }
        }

    }

    public void VerifBusquedasRandom() throws Exception {
        driver.findElement(HomeLocator).click();
        Thread.sleep(2000);
        if (driver.findElement(HomePageLocator).isDisplayed()) {
            driver.findElement(PopularLocator).click();
            driver.findElement(BestSellersLocator).click();

        } else {
            System.out.print("Error al testear categorías");
        }
        driver.findElement(HomeLocator).click();
        if (driver.findElement(HomePageLocator).isDisplayed()) {
            driver.findElement(TopTrendsLocator).click();
            driver.navigate().back(); // no funciona por el error de la versión de Chrome y driver.
        }

        driver.findElement(HomeLocator).click();
        if (driver.findElement(HomePageLocator).isDisplayed()) {
            driver.findElement(MensLocator).click();
        }
        driver.findElement(HomeLocator).click();
        if (driver.findElement(HomePageLocator).isDisplayed()) {
            driver.findElement(WomensLocator).click();

        }
        driver.findElement(HomeLocator).click();
        if (driver.findElement(HomePageLocator).isDisplayed()) {
            driver.findElement(GlassesLocator).click();

        }
        driver.findElement(HomeLocator).click();
        if (driver.findElement(HomePageLocator).isDisplayed()) {
            driver.findElement(TrendsLocator).click();
        } else {
            System.out.print("Error al testear categorías");
        }
    }
}


