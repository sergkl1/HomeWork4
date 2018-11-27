import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HW2_1 extends BaseTest{

    public static void main(String[] args) {

        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        goToLoginPage(driver);
        login(driver, wait);
        logout(driver);

        driver.quit();

    }
}
