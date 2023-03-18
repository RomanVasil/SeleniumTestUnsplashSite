import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static java.lang.Thread.sleep;

public class Authorization extends Data {

    //    WebDriver driver = new ChromeDriver();
    Data getDate = new Data();

    private By btnLogIn = By.xpath("/html/body/div/div/header/nav/div[2]/div[2]/div[3]/a[1]");
    private By inputEmail = By.xpath("//div[@class='form-group']//input[@id='user_email']");
    private By inputPassword = By.xpath("//div[@class='form-group']//input[@id='user_password']");
    private By btnLogin = By.xpath("/html/body/div[2]/div/div/div/div/form/div[3]/input");
    private By getErrorText = By.xpath("//div[@class='flash flash--alert animated js-flash js-flash-alert']//div[@class='col-xs-10 col-sm-6 center-block flash__message']");


    @Test
    public void login() throws InterruptedException {

        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("--remote-allow-origins=*");
        //     opts.setExperimentalOption("debuggerAddress", "127.0.0.1:" + browserDebuggingPort);
        WebDriver driver = new ChromeDriver(opts);


        driver.get(getDate.getUrl);
        //    driver.manage().window().maximize();

        driver.findElement(btnLogIn).click();
        driver.findElement(inputEmail).sendKeys(getDate.email);
        driver.findElement(inputPassword).sendKeys(getDate.password);
        driver.findElement(btnLogin).click();

        sleep(3000);
        driver.quit();
    }

    @Test
    public void negativeLogin() throws InterruptedException {
        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("--remote-allow-origins=*");
        //     opts.setExperimentalOption("debuggerAddress", "127.0.0.1:" + browserDebuggingPort);
        WebDriver driver = new ChromeDriver(opts);

        driver.get(getDate.getUrl);
        //    driver.manage().window().maximize();

        driver.findElement(btnLogIn).click();
        driver.findElement(inputEmail).sendKeys(getDate.invEmail);
        driver.findElement(inputPassword).sendKeys(getDate.password);
        driver.findElement(btnLogin).click();
        String getError = driver.findElement(getErrorText).getText();

        Assert.assertEquals("Invalid email or password.", getError);
        sleep(3000);
        driver.quit();

    }
}
