package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePageObject;
import pages.CalculatorPage;

import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class CalculatorSteps extends BasePageObject {

    static CalculatorPage calculatorPage = new CalculatorPage();
    WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(),
            20);

    private String income;
    Function<? super WebDriver, Object> valueChanged = new ExpectedCondition<Object>() {
        @Override
        public Boolean apply(WebDriver webDriver) {
            return !getRequiredIncome().equals(income);
        }
    };


    @Step("выбрана стоимость недвижимости – {count}")
    public void selectEstateCost(String count) {

        waitAndFill(calculatorPage.estateCost, count);

    }

    @Step("выбран первоначальный взнос – {count}")
    public void selectInitialFee(String count) {

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitAndFill(calculatorPage.initialFee, count);
        calculatorPage.initialFee.sendKeys(Keys.TAB);
    }


    @Step("выбран срок кредита – {count}")
    public void selectCreditTerm(String count) {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitAndFill(calculatorPage.creditTerm, count);

    }

    @Step("снимаем метку с наличия зарплатной карты сбербанка")
    public void turnOffSalaryCard() {

        waitAndClick(calculatorPage.salaryCard);

    }

    @Step("проверяем появление поля - {text}")
    public void checkField(String text) {
        (new WebDriverWait(BaseSteps.getDriver(), 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.xpath("//div[contains(text(), '" + text + "')]")).isDisplayed();
            }
        });

    }

    public void turnOffReference() {

        waitAndClick(calculatorPage.referenceButton);
    }

    public void turnOnYoungFamily() {

        waitAndClick(calculatorPage.youngFamily);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Step("сверка суммы кредита со значением {creditSumVal}")
    public void checkCreditSum(String creditSumVal) {

        assertEquals("Сумма кредита не соотвествует ожидаемой сумме", creditSumVal, calculatorPage.creditSum.getText());
    }

    @Step("сверка ежемесячного платежа со значением {monthlyPaymentVal}")
    public void checkMonthlyPayment(String monthlyPaymentVal) {
        assertEquals("Ежемесячный платеж не соотвествует ожидаемому платежу", monthlyPaymentVal, calculatorPage.monthlyPayment.getText());
    }

    @Step("сверка необходимого дохода со значением {requiredIncomeVal}")
    public void checkRequiredIncome(String requiredIncomeVal) {
        assertEquals("Необходимый доход не соотвествует ожидаемому доходу", requiredIncomeVal, calculatorPage.requiredIncome.getText());
    }

    @Step("сверка процентной ставки со значением {interestRateVal}")
    public void checkInterestRate(String interestRateVal) {
        assertEquals("Процентная ставка не соотвествует ожидаемой ставке", interestRateVal, calculatorPage.interestRate.getText());
    }


    public static String getRequiredIncome() {
        return calculatorPage.requiredIncome.getText();
    }


    private void waitAndFill(WebElement element, String string) {
        income = getRequiredIncome();
        element.clear();
        element.sendKeys(string);
        wait.until(valueChanged);
    }

    private void waitAndClick(WebElement element) {
        income = getRequiredIncome();
        element.click();
        wait.until(valueChanged);
    }
}
