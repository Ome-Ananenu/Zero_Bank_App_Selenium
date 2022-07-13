package pages;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

class HomePageTest {
    private ChromeDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;

    private String loginUrl = "http://zero.webappsecurity.com/login.html";

    @BeforeEach
    void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");

        driver = new ChromeDriver();
        driver.get(loginUrl);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);


    }

    @Test
    public void testToVerifyOutcomeWhen_LoggedInUserClicksMoreServices() throws InterruptedException {
        loginUser();

        homePage.visitOnlineBankingPage();

        String expectedUrl = "http://zero.webappsecurity.com/online-banking.html";
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @Test
    public void testToVerifyOutcomeWhen_NotLoggedInUserClicksMoreServices() throws InterruptedException {
        homePage.clickZeroBankLogo();

        homePage.visitOnlineBankingPage();

        String expectedUrl = "http://zero.webappsecurity.com/online-banking.html";
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @Test
    public void testToVerifyOutcomeWhen_LoggedInUserClicksCheckingAccountLink() throws InterruptedException {
        loginUser();

        homePage.visitCheckingAcctActivityPage();

        String expectedUrl = "http://zero.webappsecurity.com/bank/account-activity.html";
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @Test
    public void testToVerifyOutcomeWhen_NotLoggedInUserClicksCheckingAccountLink() throws InterruptedException {
        homePage.clickZeroBankLogo();

        homePage.visitCheckingAcctActivityPage();

        String expectedUrl = loginUrl;
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @Test
    public void testToVerifyOutcomeWhen_LoggedInUserClicksTransferFundsLink() throws InterruptedException {
       loginUser();

        homePage.visitTransferFundsPage();

        String expectedUrl = "http://zero.webappsecurity.com/bank/transfer-funds.html";
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @Test
    public void testToVerifyOutcomeWhen_NotLoggedInUserClicksTransferFundsLink() throws InterruptedException {
        homePage.clickZeroBankLogo();

        homePage.visitTransferFundsPage();

        String expectedUrl = loginUrl;
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @Test
    public void testToVerifyOutcomeWhen_LoggedInUserClicksMyMoneyMapLink() throws InterruptedException {
        loginUser();

        homePage.visitMoneyMapPage();

        String expectedUrl = "http://zero.webappsecurity.com/bank/money-map.html";
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @Test
    public void testToVerifyOutcomeWhen_NotLoggedInUserClicksMyMoneyMapLink() throws InterruptedException {
        homePage.clickZeroBankLogo();

        homePage.visitMoneyMapPage();

        String expectedUrl = loginUrl;
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    private void loginUser() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.fillLoginForm("username", "password");
        driver.navigate().back();
        Thread.sleep(2000);

    }
}