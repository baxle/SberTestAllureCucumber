package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import static org.junit.Assert.assertTrue;

public class MainPage extends BasePageObject {

    public MainPage(){
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }


  /*  Когда курсор наведен на "Ипотека"
    И открылось выпадающее меню
    И выбрано "Ипотека на готовое жилье"*/


    @FindBy(xpath = "//a[.='Условия и требования']")
    public WebElement ipotekaNew;

    @FindBy(xpath = "//*[@class='kit-button__text'][contains(text(), 'Рассчитать ипотеку')]")
    public WebElement ipotekaButton;

    public void selectMenuItem(String menuName){
        Actions action = new Actions(BaseSteps.getDriver());
        action.moveToElement(BaseSteps.getDriver().findElement(By.xpath("//span[@class='lg-menu__text'][contains(text(), '"+menuName+"')]")));
        action.perform();
    }

    public void checkMenuItem(String menu){
        String actualTitle = BaseSteps.getDriver().findElement(By.xpath("//ul[@class='lg-menu__sub-list'][@aria-label='"+menu+"']")).getAttribute("aria-label");
        assertTrue(String.format("Название меню [%s]. Ожидалось - [%s]",
                actualTitle, menu), actualTitle.contains(menu));
    }


    public void selectMenu(String menu) {
        WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 30);
        BaseSteps.getDriver().findElement(By.xpath("//*[@class= 'lg-menu__sub-link'][contains(text(), '"+menu+"')]")).click();

        ipotekaNew.click();

        JavascriptExecutor jse = (JavascriptExecutor)BaseSteps.getDriver();
        jse.executeScript("window.scrollBy(0,900)");


        //Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(ipotekaButton));
        ipotekaButton.click();
    }
}
