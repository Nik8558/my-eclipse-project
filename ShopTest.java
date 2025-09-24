package BaseClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ShopTest {

    public WebDriver driver;

    // XPaths 
    By shopNowBtn = By.xpath("//a[normalize-space()='SHOP NOW']");
    By hiddenFlexDiv = By.xpath("//div[@class='hidden small:!flex']");
    By searchInput = By.xpath("//input[@placeholder='Search products...']");
    By firstProductImg = By.xpath("(//img[@alt='Thumbnail'])[1]");
    By addToCartBtn = By.xpath("//button[normalize-space()='Add to cart']");
    By addlog =By.xpath("//img[contains(@alt,'Thumbnail')]");
    By cartLink = By.xpath("//a[@href='/cart']");
    By additem = By.xpath("//button[@type='button'][2]");
    By checkout = By.xpath("//button[normalize-space()='Go to checkout']");
    By addnew = By.xpath("(//button[@class='hover:!bg-gray-200 w-full px-2 h-full rounded-r-[10px] border-l border-gray-200 '])[1]");
    By valuevlidate = By.xpath("(//span[contains(@class,'block text-black-5 text-[22px] font-bold tracking-[-0.33px]')])[1]");
    By shippingcharge = By.xpath("//span[normalize-space()='$0.00']");

    //Setup 
    @BeforeClass
    public void setup() {
        driver = new ChromeDriver(); 
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://rohanqa.deposyt.store/");
        driver.manage().window().maximize();
    }

    //Test Steps

    @Test(priority = 1)
    public void clickShopNow() {
        driver.findElement(shopNowBtn).click();
    }

    @Test(priority = 2)
    public void clickHiddenDiv() {
        driver.findElement(hiddenFlexDiv).click();
    }

    @Test(priority = 3)
    public void searchProduct() {
        driver.findElement(searchInput).sendKeys("Apple watch");
    }

    @Test(priority = 4)
    public void selectFirstProduct() throws InterruptedException {
        driver.findElement(firstProductImg).click();
       // Thread.sleep(1000);
    }

    @Test(priority = 5)
    public void addToCart() {
        driver.findElement(addToCartBtn).click();
        
    }

    @Test(priority = 6)
    public void openCart() throws InterruptedException   {
        driver.findElement(cartLink).click();
        Thread.sleep(1000);
      
    }
    
    
    @Test(priority = 7)
    public void Add() {
        boolean status =driver.findElement(addlog).isDisplayed();
        System.out.println("Logo Displayed"+status);
        
    }
    
    @Test(priority = 8)
    public void check()   {
        driver.findElement(checkout).click();
      
    }
    
    @Test(priority = 9)
    public void newprod()   {
        driver.findElement(addnew).click();
      
    }
    
    @Test(priority = 10)
    public void validate() {
        boolean status =driver.findElement(valuevlidate).isDisplayed();
        System.out.println("correct amount Displayed"+status);
        
    }
    
    @Test(priority = 11)
    public void shipping() {
        boolean status =driver.findElement(shippingcharge).isDisplayed();
        System.out.println("correct amount Displayed"+status);
        
    }
    
    
    

   

    //Teardown 
    @AfterClass
    public void teardown() {
      {
            driver.quit();
        }
    }
}
