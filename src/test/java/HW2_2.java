import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;

public class HW2_2 extends BaseTest{

    public static void main(String[] args) {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        goToLoginPage(driver);
        login(driver, wait);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("employee_avatar_small")));

        List <WebElement> menuItems = driver.findElements(By.cssSelector("li.maintab"));

        for (int i = 1; i <= menuItems.size(); i++) {
            WebElement menuItem = driver.findElement(By.xpath("//ul/li[contains(@class, 'maintab') or contains(@class, 'levelone')][" + i + "]"));
            menuItem.click();
            String title = driver.findElement(By.cssSelector("h2")).getText();
            System.out.println(title);
            driver.navigate().refresh();
            String titleAfterReload = driver.findElement(By.cssSelector("h2")).getText();
            Assert.assertEquals(titleAfterReload, title);
        }
        driver.quit();
    }
}
