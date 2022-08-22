package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    private WebDriver driver;




    @BeforeClass
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/aspatariu/Downloads/LoginPage.xml");
        driver.manage().window().maximize();



    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();

    }


}
