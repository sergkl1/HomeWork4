import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;

    public static WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//resources//chromedriver");
        return new ChromeDriver();
    }

    public static void goToLoginPage(WebDriver driver) {
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/index.php?controller=AdminLogin&token=d251f363cceb5a849cb7330938c64dea");
    }

    public static void login(WebDriver driver, WebDriverWait wait) {
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("webinar.test@gmail.com");
        WebElement passwordField = driver.findElement(By.id("passwd"));
        passwordField.sendKeys("Xcg7299bnSmMuRLp9ITw");
        WebElement submitButton = driver.findElement(By.name("submitLogin"));
        submitButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("employee_avatar_small")));
    }

    public static void logout(WebDriver driver) {
        WebElement employeeProfile = driver.findElement(By.className("employee_avatar_small"));
        employeeProfile.click();
        WebElement logout = driver.findElement(By.id("header_logout"));
        logout.click();
    }

}
