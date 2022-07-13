package pages;

import org.openqa.selenium.chrome.ChromeDriver;

public class FeedbackPage {
    private ChromeDriver driver;
    private HomePage homePage;
    private String faqLinkId = "faq-link";
    private String nameId = "name";
    private String emailId = "email";
    private String subjectId = "subject";
    private String commentBoxId = "comment";
    private String sendMssgBtnId = "input[name = 'submit']";
    private String clearBtnId = "input[name = 'clear']";
    private String feedbackResponseId = "feedback-title";
    private String feedbackResponseMssgId = "/html/body/div[1]/div[2]/div/div/div/text()";

    public FeedbackPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void fillOutFeedbackForm(String name, String email, String subject, String comment){
        visitFeedbackPage();
        driver.findElementById(nameId).sendKeys(name);
        driver.findElementById(emailId).sendKeys(email);
        driver.findElementById(subjectId).sendKeys(subject);
        driver.findElementById(commentBoxId).sendKeys(comment);
    }

    public void submitFeedbackForm(){
        driver.findElementByCssSelector(sendMssgBtnId).click();
    }

    public void clearFeedbackForm(){
        driver.findElementById(clearBtnId).click();
    }

    public boolean getSuccessfulFeedbackResponse(String message){
        return driver.findElementById(feedbackResponseId).getText().contains(message);
    }

    private void visitFeedbackPage(){
        homePage = new HomePage(driver);
        homePage.visitFeedbackPage();
    }
}
