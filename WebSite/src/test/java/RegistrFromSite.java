import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class RegistrFromSite {


    private By btnSignUp = By.xpath("//*[@id=\"app\"]/div/header/nav/div[2]/div[2]/div[3]/a[2]");
    private By inputFirstName = By.xpath("//div[@class='row']//input[@id='user_first_name']");
    private By inputLastName = By.xpath("//div[@class='row']//input[@id='user_last_name']");
    private By inputEmail = By.xpath("//div[@class='form-group']//input[@id='user_email']");
    private By inputUserName = By.xpath("//div[@class='form-group']//input[@id='user_username']");
    private By inputPassword = By.xpath("//div[@class='form-group']//input[@id='user_password']");
    private By btnJoin = By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[4]/form/div[5]/input[2]");
    private By btnCopyEmail = By.xpath("//*[@id=\"pre_copy\"]");

    @Test
    public void registration() throws InterruptedException {
//        WebDriver driver = new ChromeDriver();

        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("--remote-allow-origins=*");
        //     opts.setExperimentalOption("debuggerAddress", "127.0.0.1:" + browserDebuggingPort);
        WebDriver driver = new ChromeDriver(opts);
        driver.get("https://www.unsplash.com/");
//        sleep(30000);

        //       driver.manage().window().maximize();

        driver.findElement(btnSignUp).click();
        driver.findElement(inputFirstName).sendKeys("rom");
        driver.findElement(inputLastName).sendKeys("VAS");

        driver.switchTo().newWindow(WindowType.TAB).get("https://tempmail.plus/ru/#!");
        driver.findElement(btnCopyEmail).click();
        sleep(2000);

        ArrayList<String> newTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(0));


        driver.findElement(inputEmail).sendKeys(Keys.LEFT_CONTROL+"v");

        driver.findElement(inputUserName).sendKeys("rom");
        driver.findElement(inputPassword).sendKeys("12345678rom");
        driver.findElement(btnJoin).click();

        sleep(3000);
         driver.quit();


        
    }


}
