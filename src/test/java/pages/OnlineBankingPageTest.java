package pages;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

class OnlineBankingPageTest {
    private ChromeDriver driver;
    private OnlineBankingPage onlineBankingPage;
    private LoginPage loginPage;
    private String loginUrl = "http://zero.webappsecurity.com/login.html";


    @BeforeEach
    void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");

        driver = new ChromeDriver();
        driver.get(loginUrl);
        driver.manage().window().maximize();

        onlineBankingPage = new OnlineBankingPage(driver);
        loginPage = new LoginPage(driver);
        loginPage.loginUser("username","password");

    }

    @Test
    public void testToVerifyOutcomeWhen_LoggedInUserClicksAccountSummaryPage() throws InterruptedException {
        onlineBankingPage.visitAcctSummaryPage();

        String expectedUrl = "http://zero.webappsecurity.com/bank/account-summary.html";
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }


    @Test
    public void testToVerifyOutcomeWhen_LoggedInUserClicksCheckingAccountActivityLink() throws InterruptedException {

        onlineBankingPage.visitCheckingAcctActivityPage();

        String expectedUrl = "http://zero.webappsecurity.com/bank/account-activity.html";
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }



    @Test
    public void testToVerifyOutcomeWhen_LoggedInUserClicksTransferFundsLink() throws InterruptedException {
    onlineBankingPage.visitTransferFundsPage();

        String expectedUrl = "http://zero.webappsecurity.com/bank/transfer-funds.html";
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }
    @Test
    public void testToVerifyOutcomeWhen_LoggedInUserClicksPayBillsLink() throws InterruptedException {
        onlineBankingPage.visitPayBillsPage();

        String expectedUrl = "http://zero.webappsecurity.com/bank/pay-bills.html";
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }
    @Test
    public void testToVerifyOutcomeWhen_LoggedInUserClicksMyMoneyMapLink() throws InterruptedException {
        onlineBankingPage.visitMoneyMapLinkPage();

        String expectedUrl = "http://zero.webappsecurity.com/bank/money-map.html";
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @Test
    public void testToVerifyOutcomeWhen_LoggedInUserClicksOnlineStatementsLink() throws InterruptedException {
        onlineBankingPage.visitOnlineStatementsPage();

        String expectedUrl = "http://zero.webappsecurity.com/bank/online-statements.html";
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }
    @AfterEach
    void tearDown() {
        driver.quit();
    }
}