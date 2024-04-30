package org.example.Test;

import java.security.SecureRandom;
import java.math.BigInteger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Page {
    private static final String URL = "https://ztrain-web.vercel.app/en/home";
    private static final String CHROME_DRIVER_PATH = "src/test/resources/driver/chromedriver.exe";
    private static final String EMAIL_PRE_VALUE = "emmaunel";
    private static final String EMAIL_POST_VALUE = "@yahoo.fr";
    private static final String PASSWORD_VALUE = generateRandomPassword();

    private WebDriver driver;

    @FindBy(id = "style_avatar_wrapper__pEGIQ")
    private WebElement avatar;

    @FindBy(id = "email_login")
    private WebElement formEmailLogin;

    @FindBy(id = "password_login")
    private WebElement formPasswordLogin;

    @FindBy(id = "btn_login")
    private WebElement btnSubmitLogin;

    @FindBy(id = "email_register")
    private WebElement formEmailSignUp;

    @FindBy(id = "password_register")
    private WebElement formPasswordSignUp;

    @FindBy(id = "confirm_password_register")
    private WebElement formConfirmPasswordSignUp;

    @FindBy(id = "btn_register")
    private WebElement btnSubmitSignUp;

    @FindBy(id = "logout")
    private WebElement btnLogout;

    private By sectionSignIn = By.cssSelector("main>div:nth-child(2)>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>button:nth-child(1)");
    private By sectionSignUp = By.cssSelector("main>div:nth-child(2)>div:nth-child(2)>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)>button:nth-child(2)");

    public HomePage() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
    }

    public void inscription() {
        navigateToHomePage();
        avatar.click();
        driver.findElement(sectionSignUp).click();
        fillSignUpForm();
        System.out.println("Vous êtes désormais enregistré");
        System.out.println("Identifiants => Login : " + generateEmail() + ", Mot de Passe " + PASSWORD_VALUE);
    }

    public void deconnexion() {
        avatar.click();
        btnLogout.click();
        System.out.println("Vous n'avez plus accès au site");
    }

    public void connexion() {
        avatar.click();
        driver.findElement(sectionSignIn).click();
        fillLoginForm();
        System.out.println("Vous êtes à présent connecté ");
    }

    public void navigateToHomePage() {
        driver.get(URL);
    }

    private void fillSignUpForm() {
        formEmailSignUp.sendKeys(generateEmail());
        formPasswordSignUp.sendKeys(PASSWORD_VALUE);
        formConfirmPasswordSignUp.sendKeys(PASSWORD_VALUE);
        btnSubmitSignUp.click();
    }

    private void fillLoginForm() {
        formEmailLogin.sendKeys(generateEmail());
        formPasswordLogin.sendKeys(PASSWORD_VALUE);
        btnSubmitLogin.click();
    }

    private String generateEmail() {
        long milliseconds = System.currentTimeMillis();
        return EMAIL_PRE_VALUE + milliseconds + EMAIL_POST_VALUE;
    }

    private static String generateRandomPassword() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32); // 130 bits, base 32
    }
}