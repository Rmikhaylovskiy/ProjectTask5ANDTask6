package steps;
import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

import static steps.BaseSteps.baseUrl;
public class MainSteps {

    @Step ("Осуществлен переход на страницу Яндекса")
    public void stepTransferToYandex(){
        BaseSteps.getDriver().get(baseUrl);
    }

    @Step("Выбран пунк меню {0}")
    public void stepSelectMainMenu(String menuItem){
        MainPage mainPage = new MainPage();
        mainPage.selectMainMenu(menuItem);
    }
}
