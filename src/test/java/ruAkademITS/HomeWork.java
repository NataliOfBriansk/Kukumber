package ruAkademITS;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeWork {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriver driver = null;

        String browser = System.getProperty("browser");

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
    }

    @Test
    public void MyTestPracticeForm() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 30, 500);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".practice-form-wrapper")));

        WebElement xInput = driver.findElement(By.cssSelector("#firstName"));
        xInput.sendKeys("Diana");

        xInput = driver.findElement(By.cssSelector("#lastName"));
        xInput.sendKeys("Maria");

        Thread.sleep(10000);

//        SoftAssertions softAssert = new SoftAssertions();
//
//        softAssert.assertThat(driver.findElement(By.id("test")).getText()).isEqualTo("t");
//        softAssert.assertThat(driver.findElement(By.id("text")).isDisplayed());
//        softAssert.assertAll();
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
