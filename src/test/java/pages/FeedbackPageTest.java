package pages;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

class FeedbackPageTest {
    private ChromeDriver driver;
    private FeedbackPage feedbackPage;
    private LoginPage loginPage;
    private String loginUrl = "http://zero.webappsecurity.com/login.html";

    @BeforeEach
    void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");

        driver = new ChromeDriver();
        driver.get(loginUrl);
        driver.manage().window().maximize();

        feedbackPage = new FeedbackPage(driver);
        loginPage = new LoginPage(driver);
        loginPage.loginUser("username", "password");

    }

    @Test
    public void  testToVerifyOutcomeWhen_UserFillsFeedbackFormWithValidPayload() throws InterruptedException {
        String name = "Lesi";

        feedbackPage.fillOutFeedbackForm(name,"lesimary@gmail.com","My Acoount was debited","On April 3rd my account was debited..I don't like this bank");
        feedbackPage.submitFeedbackForm();

        String expectedUrl = "http://zero.webappsecurity.com/sendFeedback.html";

        assertEquals(expectedUrl,driver.getCurrentUrl());
        assertTrue(feedbackPage.getSuccessfulFeedbackResponse("Feedback"));
    }



    @AfterEach
    void tearDown() {
        driver.quit();
    }


}