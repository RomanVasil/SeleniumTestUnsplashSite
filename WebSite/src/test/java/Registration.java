import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;


public class Registration extends Data {
    WebDriver driver = new ChromeDriver();
    Data getDate = new Data();
    private By btnSignUp = By.xpath("//*[@id=\"app\"]/div/header/nav/div[2]/div[2]/div[3]/a[2]");
    private By inputFirstName = By.xpath("//div[@class='row']//input[@id='user_first_name']");
    private By inputLastName = By.xpath("//div[@class='row']//input[@id='user_last_name']");
    private By inputEmail = By.xpath("//div[@class='form-group']//input[@id='user_email']");
    private By inputUserName = By.xpath("//div[@class='form-group']//input[@id='user_username']");
    private By inputPassword = By.xpath("//div[@class='form-group']//input[@id='user_password']");
    private By btnJoin = By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[4]/form/div[5]/input[2]");


    @Test
    public void registration() throws InterruptedException {

        driver.get(getDate.getUrl);
 //       driver.manage().window().maximize();

        driver.findElement(btnSignUp).click();
        driver.findElement(inputFirstName).sendKeys(getDate.firstName);
        driver.findElement(inputLastName).sendKeys(getDate.lastName);
        driver.findElement(inputEmail).sendKeys(getDate.email);
        driver.findElement(inputUserName).sendKeys(getDate.userName);
        driver.findElement(inputPassword).sendKeys(getDate.password);
        driver.findElement(btnJoin).click();

        sleep(30000);
       // driver.quit();
    }

}
