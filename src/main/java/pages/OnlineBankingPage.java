package pages;

import org.openqa.selenium.chrome.ChromeDriver;

public class OnlineBankingPage {
    private ChromeDriver driver;
    private HomePage homePage;
    private String signInNowLinkId;
    private String acctSummaryLinkId = "account_summary_link";
    private String checkingAcctActivityLinkId = "account_activity_link";
    private String transferFundsLinkId = "transfer_funds_link";
    private String payBillsLinkId = "pay_bills_link";
    private String moneyMapLinkId = "money_map_link";
    private String onlineStatementsLinkId = "online_statements_link";

    public OnlineBankingPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void visitAcctSummaryPage(){
        visitOnlineBankingPage();
        driver.findElementById(acctSummaryLinkId).click();
    }

    public void visitCheckingAcctActivityPage(){
        visitOnlineBankingPage();
        driver.findElementById(checkingAcctActivityLinkId).click();
    }

    public void visitTransferFundsPage(){
        visitOnlineBankingPage();
        driver.findElementById(transferFundsLinkId).click();
    }

    public void visitPayBillsPage(){
        visitOnlineBankingPage();
        driver.findElementById(payBillsLinkId).click();
    }

    public void visitMoneyMapLinkPage(){
        visitOnlineBankingPage();
        driver.findElementById(moneyMapLinkId).click();
    }

    public void visitOnlineStatementsPage(){
        visitOnlineBankingPage();
        driver.findElementById(onlineStatementsLinkId).click();
    }

    private void visitOnlineBankingPage(){
        homePage = new HomePage(driver);
        homePage.visitOnlineBankingPage();
    }
}
