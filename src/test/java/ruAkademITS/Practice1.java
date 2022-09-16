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
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Practice1 {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void checkRadioButtonTest() {
        driver.get("https://academ-it-school.ru/payment?course=java_begin");
        driver.manage().window().maximize();

        WebElement testingRadioButton = driver.findElement(By.cssSelector("input[name='CourseType'][value='Testing']"));
        testingRadioButton.click();

        Assertions.assertEquals("true", testingRadioButton.getAttribute("checked"));
    }

    @Test
    public void selectHerokuTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        WebElement selectDropdown = driver.findElement(By.cssSelector("[id='dropdown']"));
        Select select = new Select(selectDropdown);

        select.selectByVisibleText("Option 2");
//        select.selectByIndex(1);
//        List<WebElement> allOptions = select.getOptions();
        Assertions.assertEquals("2", selectDropdown.getAttribute("value"));

    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
