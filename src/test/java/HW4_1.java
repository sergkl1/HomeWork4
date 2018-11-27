import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by sergey.kliepikov on 11/22/18.
 */
public class HW4_1 extends BaseTest{

    @BeforeTest
    public void setUp(){
        driver = getDriver();
        wait = new WebDriverWait(driver, 10);

    }

    @Test
    public void createProduct(){
        goToLoginPage(driver);
        login(driver, wait);
        WebElement catalogue = driver.findElement(By.id("subtab-AdminCatalog"));
        Actions action = new Actions(driver);
        WebElement goods = driver.findElement(By.id("subtab-AdminProducts"));
        action.moveToElement(catalogue).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("subtab-AdminProducts")));
        goods.click();
        WebElement addNewProduct = driver.findElement(By.id("page-header-desc-configuration-add"));
        addNewProduct.click();
        WebElement productNameField = driver.findElement(By.id("form_step1_name_1"));
        String productName = randomCharacters(10);
        productNameField.sendKeys(productName);
        WebElement numberOfProductsField = driver.findElement(By.id("form_step1_qty_0_shortcut"));
        Random rnd = new Random();
        Integer numberOfProducts = rnd.nextInt(101);
        numberOfProductsField.clear();
        numberOfProductsField.sendKeys(numberOfProducts.toString());
        WebElement priceField = driver.findElement(By.id("form_step1_price_shortcut"));
        Double price = 0.1 + (100 - 0.1) * rnd.nextDouble();
        priceField.clear();
        priceField.sendKeys(price.toString());
        WebElement productActivator = driver.findElement(By.className("switch-input "));
        productActivator.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.className("growl-close")));
        WebElement closeActivatorPopup = driver.findElement(By.className("growl-close"));
        closeActivatorPopup.click();
        WebElement saveButton = driver.findElement(By.cssSelector(".btn.btn-primary.js-btn-save"));
        saveButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='growl growl-notice growl-medium']/div[1]")));
        driver.findElement(By.xpath("//div[@class='growl growl-notice growl-medium']/div[1]")).click();

        driver.get("http://prestashop-automation.qatestlab.com.ua/ru/");
        driver.findElement(By.cssSelector(".all-product-link.pull-xs-left.pull-md-right.h4")).click();
        driver.findElement(By.xpath("//li/a[contains(text(), '3')]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("thumbnail-container")));
        driver.findElement(By.xpath("//a[contains (text(), '" + productName + "')]"));
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    private static final String CHARACTERS_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String randomCharacters(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*CHARACTERS_STRING.length());
            builder.append(CHARACTERS_STRING.charAt(character));
        }
        return builder.toString();
    }


}
