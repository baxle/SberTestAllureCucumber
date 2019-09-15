package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioSteps {

    MainSteps mainPageSteps = new MainSteps();
    CalculatorSteps calculatorSteps = new CalculatorSteps();

    @When("^курсор наведен на \"(.+)\"$")
    public void selectMenuItem(String menuName){
        mainPageSteps.selectMenuItem(menuName);
    }

    @When("^открылось выпадающее меню \"(.+)\"$")
    public void checkMenu(String menu){
        mainPageSteps.checkMenuItem(menu);
    }

    @When("^выбрано \"(.+)\"$")
    public void selectMenu(String menu){
        mainPageSteps.selectMenu(menu);
    }


    @When("^заполнено поле Стоимость недвижимости \"(.+)\"$")
    public void selectEstateCost(String count){
        calculatorSteps.selectEstateCost(count);
    }

    @When("^заполнено поле Первоначальный взнос \"(.+)\"$")
    public void selectInitialFee(String count){
        calculatorSteps.selectInitialFee(count);
    }

    @When("^заполнено поле Срок кредита \"(.+)\"$")
    public void selectCreditTerm(String count){
        calculatorSteps.selectCreditTerm(count);
    }

    @When("снята галочка с наличия зарплатной карты")
    public void turnOffSalaryCard(){
        calculatorSteps.turnOffSalaryCard();
    }

    @When("^появилось поле \"(.+)\"$")
    public void checkField(String text){
        calculatorSteps.checkField(text);
    }

    @When("снята галочка с возможности подтвердить доход справкой")
    public void turnOffRefeerence(){
        calculatorSteps.turnOffReference();
    }

    @When("поставлена галочка Молодая семья")
    public void turnOnYoungFamily(){
        calculatorSteps.turnOnYoungFamily();
    }

    @Then("^значение поля Сумма кредита \"(.+)\"$")
    public void check1(String creditSumVal) {
        calculatorSteps.checkCreditSum(creditSumVal);

    }

    @Then("^значение поля Ежемесячный платеж \"(.+)\"$")
    public void check2(String monthlyPaymentVal) {
        calculatorSteps.checkMonthlyPayment(monthlyPaymentVal);

    }

    @Then("^значение поля Необходимый доход \"(.+)\"$")
    public void check3(String requiredIncomeVal) {
        calculatorSteps.checkRequiredIncome(requiredIncomeVal);

    }

    @Then("^значение поля Процентная ставка \"(.+)\"$")
    public void check4(String interestRateVal) {
        calculatorSteps.checkInterestRate(interestRateVal);

    }
}
