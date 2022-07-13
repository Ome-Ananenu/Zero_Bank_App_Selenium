package pages;

import org.openqa.selenium.chrome.ChromeDriver;

public class FeedbackPage {
    private ChromeDriver driver;
    private String faqLinkId = "faq-link";
    private String nameId = "name";
    private String emailId = "email";

    public FeedbackPage(ChromeDriver driver) {
        this.driver = driver;
    }

    private String subjectId = "subject";
    private String commentBoxId = "comment";
    private String sendMssgBtnId = "input[name = 'submit']";
    private String clearBtnId = "input[name = 'clear']";

}
