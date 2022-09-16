package ruAkademITS;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PracticeWait {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void s7TestExplicit() throws InterruptedException {
        driver.get("https://news.s7.ru/news?id=13441");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 30, 500);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".comments-block-wrapper")));

        WebElement nameInput = driver.findElement(By.cssSelector("#author"));
        nameInput.sendKeys("name");

        Thread.sleep(3000);
        Assertions.assertEquals("name", nameInput.getAttribute("value"));
    }

    @Test
    public void s7TestImplicit() throws InterruptedException {
        driver.get("https://news.s7.ru/news?id=13441");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement nameInput = driver.findElement(By.cssSelector("#author"));
        nameInput.sendKeys("name");

        Thread.sleep(3000);
        Assertions.assertEquals("name", nameInput.getAttribute("value"));

    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
