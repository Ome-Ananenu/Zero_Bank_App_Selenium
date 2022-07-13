package pages;

import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {
    private ChromeDriver driver;
    private String zeroBankLogoId = "a[class='brand']";
    private String searchBarId = "searchTerm";
    private String moreServicesBtnId = "online-banking";
    private String checkingAcctActivityLinkId = "account_activity_link";
    private String transferFundsLinkId = "transfer_funds_link";
    private String moneyMapLinkId = "money_map_link";

    public HomePage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void visitOnlineBankingPage(){
        driver.findElementById(moreServicesBtnId).click();
    }

    public void visitCheckingAcctActivityPage(){
        driver.findElementById(checkingAcctActivityLinkId).click();
    }

    public void visitTransferFundsPage(){
        driver.findElementById(transferFundsLinkId).click();
    }

    public void visitMoneyMapPage(){
        driver.findElementById(moneyMapLinkId).click();
    }

    public void clickZeroBankLogo(){
        driver.findElementByCssSelector(zeroBankLogoId).click();
    }
}
