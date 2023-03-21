import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

import static java.lang.Thread.sleep;

public class CookiesAuthorization {

   // WebDriver driver = new ChromeDriver();
    Data getDate = new Data();

    @Test
    public void login() throws InterruptedException {
        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("--remote-allow-origins=*");
        //     opts.setExperimentalOption("debuggerAddress", "127.0.0.1:" + browserDebuggingPort);
        WebDriver driver = new ChromeDriver(opts);

        driver.get(getDate.getUrl);
        sleep(2000);
//        Cookie getCookie = new Cookie("auth_user_id","12360862");
        Cookie getCookie = new Cookie("IDE","AHWqTUlP-PmPhvxLInCTYj4zFDqp8ozYMYe0ypx5K9e1triVoA-rA2N1XE4CQ1G_X1c");


        driver.manage().addCookie(getCookie);
        driver.navigate().refresh();
    }

}
