package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class CalculatorPage extends BasePageObject {

/*    Когда заполнено поле Стоимость недвижимости - "5180000"
    Когда заполнено поле Первоначальный взнос - "3058000"
    Когда заполнено поле Срок кредита - "30"*/


    @FindBy(xpath = "//input[@id='estateCost']")
    public WebElement estateCost;
    @FindBy(xpath = "//input[@id='initialFee']")
    public WebElement initialFee;
    @FindBy(xpath = "//input[@id='creditTerm']")
    public WebElement creditTerm;
    @FindBy(xpath = "//div[contains(@class, 'discounts')]//label[contains(@class, 'switch_checked')]")
    public WebElement salaryCard;
    @FindBy(xpath = "//div[@class='dcCalc_frame__discounts']/div[3]//span[@class='dcCalc_switch__control']")
    public WebElement referenceButton;
    @FindBy(xpath = "//div[@class='dcCalc_frame__discounts']/div[5]//span[@class='dcCalc_switch__control']")
    public WebElement youngFamily;

    @FindBy(xpath = "//*[contains(@data-test-id, 'amountOfCredit')]")
    static
    public WebElement creditSum;
    @FindBy(xpath = "//*[contains(@data-test-id, 'monthlyPayment')]")
    public WebElement monthlyPayment;
    @FindBy(xpath = "//*[contains(@data-test-id, 'requiredIncome')]")

    public WebElement requiredIncome;
    @FindBy(xpath = "//*[contains(@data-test-id, 'rate')]")
    public WebElement interestRate;

    public CalculatorPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }







}
