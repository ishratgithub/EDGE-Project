import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class MyJUnit {
    WebDriver driver;
    @BeforeAll
  public void setup(){
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
  }
  @DisplayName("Get website title")
  @Test
  public void getTitle(){
      driver.get("https://codenboxautomationlab.com/registration-form/");
      String titleActual = driver.getTitle();
      System.out.println(titleActual);
      //String titleExpected="CodenBoxAutomationLab";
      //Assertions.assertTrue(titleActual.contains(titleExpected));
      //Assertions.assertEquals(titleExpected,titleActual);
  }
  @Test
  public void submitForm(){
        driver.get("https://codenboxautomationlab.com/registration-form/");
     List<WebElement> fromControls = driver.findElements(By.className("ninja-forms-field"));
     fromControls.get(1).sendKeys("Ishrat");
     fromControls.get(2).sendKeys("jahan");
     fromControls.get(3).sendKeys("ijahan321@gmail.com");
     fromControls.get(4).sendKeys("01764857213");

     WebElement dropdownElem = driver.findElement(By.id("nf-field-22"));
     dropdownElem.click();
      WebElement dropdownElem2 = driver.findElement(By.id("nf-field-24"));
      dropdownElem2.click();
      Actions actions = new Actions(driver);
      actions.keyDown(Keys.ARROW_DOWN).perform();
      actions.sendKeys(Keys.ENTER).perform();

      driver.findElement(By.id("nf-label-class-field-23-5")).click();
      driver.findElement(By.id("nf-field-15")).click();

     scroll();
  }
  public void scroll(){
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("window.scrollBy(0,500)");
  }

  //@AfterAll
  public void closeBrowser(){
         // driver.close();
        driver.quit();
  }

}
