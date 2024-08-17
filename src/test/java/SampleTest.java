
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class SampleTest {

   // private static WebDriver driver;
    private static RemoteWebDriver driver;


    @BeforeAll
    public static void setup() throws MalformedURLException {
        System.out.println("Setup web-driver");
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\ms515\\IdeaProjects\\Sample\\src\\test\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--selenium-manager=true");
        //local driver
        //driver = new ChromeDriver();

        //remote url
        driver = new RemoteWebDriver(new URL("http://localhost:4444"),options);

        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        driver.get("https://www.selenium.dev/documentation/overview/");
    }

//    @Tags({@Tag("smoke"), @Tag("regression")})
//    @Test
//    public void test(){
//        assertNotEquals("abc", "def");
//    }

    @Tag("regression")
    @Test
    public void test2(){
        assertEquals("Selenium Overview",driver.findElement(By.xpath("//h1[contains(text(),'Overview')]")).getText());
    }

    @AfterAll
    public static void close(){
        System.out.println("close web-driver connection");
        driver.quit();
    }
}
