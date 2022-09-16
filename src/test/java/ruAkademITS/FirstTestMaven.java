package ruAkademITS;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTestMaven {
    @Test
    public void simpleTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://ya.ru");
        driver.quit();
    }

    @Test
    public void openBrowser() {
        WebDriver driver = null;

        String browser = System.getProperty("browser");

        String url = "https://ru.any-notes.com/piano-music/piano-notes-for-beginner/notes/bethoven-l-k-elize.pdf";

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

        driver.get(url);
        driver.manage().window().maximize();

        Assertions.assertEquals(url, driver.getCurrentUrl());

        driver.quit();
    }
}
