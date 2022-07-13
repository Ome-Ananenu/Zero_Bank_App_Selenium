package pages;

import org.openqa.selenium.chrome.ChromeDriver;

public class OnlineBankingPage {
    private ChromeDriver driver;
    private String signInNowLinkId;
    private String acctSummaryLinkId = "account_summary_link";
    private String acctActivityLinkId = "account_activity_link";
    private String transferFundsLinkId = "transfer_funds_link";
    private String payBillsLinkId = "pay_bills_link";

    public OnlineBankingPage(ChromeDriver driver) {
        this.driver = driver;
    }

    private String moneyMapLinkId = "money_map_link";
    private String onlineStatementsLinkId = "online_statements_link";
}
