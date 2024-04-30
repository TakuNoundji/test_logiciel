import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTest {
    private WebDriver driver;

    private String path="src/test/resources/driver/chromedriver.exe";


    private By gestCompte = By.id("style_avatar_wrapper__pEGIQ");
    private By email_login= By.id("email_login");
    private By password_login= By.id("password_login");

    private By btn_login = By.id("btn_login");


    // Inscription
    private By btn_inscription = By.id("mui-p-97553-T-2");
    private By email_register = By.id("email_register");
    private By password_register = By.id("password_register");
    private By confirm_password_register = By.id("confirm_password_register");
    private By btn_register = By.id("btn_register");


    @BeforeTest()
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",this.path);

        this.driver= new ChromeDriver();
    }

    @Test()
    public void navigateToHomePage(){

        // get element by id
//        this.driver.get("https://www.msn.com/en-xl?ocid=wispr&pc=u477");
                this.driver.get("https://ztrain-web.vercel.app/en/home");
//                this.driver.findElement(By.id("style_avatar_wrapper__pEGIQ")).click();
//                this.driver.findElement(By.id("email_login")).sendKeys("test42@test.com");
//                this.driver.findElement(By.id("password_login")).sendKeys("123456789");
//                this.driver.findElement(By.id("btn_login"));

        // get element by Class ou css
       //  this.driver.findElement(new By.ByCssSelector("nav>div:nth-child(4)"));

    // signup

    }


    @Test()
    public void Inscription(){
        this.driver.get("https://ztrain-web.vercel.app/en/home");
        this.driver.findElement(gestCompte).click();
        this.driver.findElement(By.cssSelector(".MuiTabs-scroller>div>button:nth-child(2)")).click();
        this.driver.findElement(email_register).sendKeys("mengataf@gmail.com");
        this.driver.findElement(password_register).sendKeys("123456789");
        this.driver.findElement(confirm_password_register).sendKeys("123456789");
        this.driver.findElement(btn_register).click();
    }

    @Test()
    public void connexion(){
        this.driver.get("https://ztrain-web.vercel.app/en/home");
        this.driver.findElement(gestCompte).click();
        this.driver.findElement(email_login).sendKeys("mengataf@gmail.com");
        this.driver.findElement(password_login).sendKeys("123456789");
        this.driver.findElement(btn_login).click();
    }
//    @AfterTest()
//    public void closnavigater(){
//        this.driver.quit();
//    }
}
