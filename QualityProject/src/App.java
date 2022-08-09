import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Stopwatch;

import io.opentelemetry.api.trace.SpanContext;

//----------------------------------------------------------------
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.interactions.WheelInput;



public class App {
    public static void main(String[] args) throws Exception {
       
        objetosMasVendidos();
        //searchBar();

    }

    @Test
    public static void objetosMasVendidos(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\XLight\\Documents\\Calidad del Software\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
        //          VAR
        String WebPath = "http://automationpractice.com/index.php"; 
        String Tittle;


        try{       
                        //ABRIR GOOGLE CHROME                        
            driver.get(WebPath);

                                   //TITTLE ASSERT
                                   Tittle = driver.getTitle();
                                   assertEquals("My Store", Tittle);
                                   System.out.println("\n"+"Web tittle -> "+Tittle+"\n");

                        //CLICK AL BOTON "BEST SELLERS"
            driver.findElement(By.className("blockbestsellers")).click();
                        
 

            driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul[2]/li[1]/div/div[2]/div[2]/a[1]")).click();

            /*WebElement iframe = driver.findElement(By.id("blockbestsellers"));
            WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(iframe);

            new Actions(driver)
                    .scrollFromOrigin(scrollOrigin, 200, 200)
                    .pause(Duration.ofSeconds(1))
                    .doubleClick()
                    .pause(Duration.ofSeconds(1))
                    .perform();*/
                    
                    
                        //CERRAR LA VENTANA DEL EXPLORADOR
           //driver.quit();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }



    @Test
    public static void searchBar(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\XLight\\Documents\\Calidad del Software\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String WebPath = "http://automationpractice.com/index.php";
        String Tittle;

        try{
            driver.get(WebPath);
            WebElement search_bar = driver.findElement(By.id("searchbox"));
            Actions actions = new  Actions(driver);
            actions.clickAndHold(search_bar)
                .sendKeys("Blouse")                
                .perform();         

            driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[2]/form/button")).click();

           
                                               //TITTLE ASSERT
                                               Tittle = driver.getTitle();
                                               assertEquals("Search - My Store", Tittle);
                                               System.out.println("Web tittle -> "+Tittle);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
