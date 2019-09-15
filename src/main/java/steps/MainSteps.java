package steps;

import io.qameta.allure.Step;
import pages.MainPage;

public class MainSteps {
    @Step("выбран пункт меню {0}")
    public void selectMenuItem(String menuItem){
        new MainPage().selectMenuItem(menuItem);
    }

    public void checkMenuItem(String menu) {
        new MainPage().checkMenuItem(menu);
    }

    public void selectMenu(String menu) {
        new MainPage().selectMenu(menu);
    }


}
