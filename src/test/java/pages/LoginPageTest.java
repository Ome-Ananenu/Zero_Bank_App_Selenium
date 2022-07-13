package pages;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

class LoginPageTest {
    private ChromeDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");

        driver = new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/login.html");
        driver.manage().window().maximize();
    }

    @Test
    public void testToVerifyOutcome_WhenUserLogsInWithValidPayload() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.fillLoginForm("username","password");

        driver.navigate().back();
        Thread.sleep(2000);
        String expectedUrl = "http://zero.webappsecurity.com/index.html";
        assertEquals(expectedUrl,driver.getCurrentUrl());
    }

    @Test
    public void  testToVerifyOutcomeWhen_UserLogsInWithInValidPayload() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.fillLoginForm("user","pass");

        String errorMssg = loginPage.checkErrorMssg();
        String expectedUrl = "http://zero.webappsecurity.com/index.html";

        assertEquals(errorMssg,"Login and/or password are wrong.");
        assertNotEquals(expectedUrl,driver.getCurrentUrl());
    }

    @Test
    public void  testToVerifyOutcomeWhen_UserLogsInWithBlankPayload() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.fillLoginForm("","");

        String errorMssg = loginPage.checkErrorMssg();
        String expectedUrl = "http://zero.webappsecurity.com/index.html";

        assertEquals(errorMssg,"Login and/or password are wrong.");
        assertNotEquals(expectedUrl,driver.getCurrentUrl());
        Thread.sleep(2000);
    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }
}