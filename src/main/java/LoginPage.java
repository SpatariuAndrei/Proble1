import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPage {

    private WebDriver driver;
    private By usernameField = By.id("username");
    private By passField = By.id("password");
    private By loginButton = By.id("kc-login");
    private By successLogin = By.id("success");
    private By wrongEmailMessage = By.id("invalid email");
    private By enterCorrectEmail = By.id("enterCorrectEmail");



    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);



    }
    public void setPassword(String pass){

        driver.findElement(passField).sendKeys(pass);

    }
    public LoginPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return  new LoginPage(driver);

    }
    public String getSuccessLoginText(){
    return driver.findElement(successLogin).getText();


    }
    public String getInvalidEmailText(){
        return driver.findElement(wrongEmailMessage).getText();

    }
    public String getEnterCorrectEmailText(){
        return driver.findElement(enterCorrectEmail).getText();


    }

    @Test
    public void testSuccesfullLogin(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.setUsername("spatariuandrei@yahoo.com");
    loginPage.setPassword("correctPass");
    loginPage.clickLoginButton();
    Assert.assertEquals(loginPage.getSuccessLoginText(),"success" ,"LogIn not succesfull");
    }

    @Test
    public void testWrongEmailLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("sss@yahoo.com");
        loginPage.setPassword("correctPass");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getInvalidEmailText(),"invalid email", "Wrong email inserted");



    }

    @Test
    public void testEnterCorrectEmail(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("sss@yahoo.com");
        loginPage.setPassword("blablapass");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getEnterCorrectEmailText(),"enter correct email","emailNotCorrect");


    }






}
