package steps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MarketPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class MarketSteps {
    MarketPage marketPage = new MarketPage( BaseSteps.getDriver());

    @Step("Выбрано меню Электроника")
    public void stepClickElectronika() {
        marketPage.electronica.click();
    }


    @Step("Выбрано меню Телевизоры")
    public void stepClickMenuTV() {
        marketPage.televizor.click();
    }


    @Step("Выбран чек бокс Samsung")
    public void stepClickSamsung() {
        marketPage.clickSamsung.click();
    }

    @Step("Выбран чек бокс LG")
    public void stepClickLG() {
        marketPage.clickLG.click();
    }


    @Step("Выполнено нажатие на кнопку Применить")
    public void stepButtonPrimenit() {
        marketPage.clickButtonPrimenit.click();
    }

    @Step("Выполнена проверка Элиментов на форме = 12")
    public void stepCheckCountOfEliments() {
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 5, 1000);
        wait.until( ExpectedConditions.visibilityOf(
                BaseSteps.getDriver().findElement( By.xpath("(//div[@class='n-snippet-card2__title'])"))));
        assertEquals( 12,  BaseSteps.getDriver().findElements( By.xpath( "(//div[@class='n-snippet-card2__title'])" ) ).size() );
    }

    @Step("Запомнили значение 1ого элимента")
    public String stepFoundFirstEliment() {
        String s =  BaseSteps.getDriver().findElement( By.xpath( "(//div[@class='n-snippet-card2__title'])[1]" ) ).getText();
        return s;
    }

    @Step("Вводим значение первого элимента в поисковую строку")
    public void stepInputFirstElimentToSearch(String d) {
        BaseSteps.getDriver().findElement( By.xpath( "//INPUT[@id='header-search']" ) ).sendKeys( d );
    }

    @Step("Нажатие на кнопку - Поиск")
    public void stepClickToSearch() {
        BaseSteps.getDriver().findElement( By.xpath( "(//BUTTON[@role='button'])[1]" ) ).click();
    }

    @Step("Проверяем текстовку наденного элимента")
    public void stepCheckText(String d) {
        Assert.assertTrue(  BaseSteps.getDriver().findElement( By.xpath( "//H1[@class='title title_size_28 title_bold_yes']" ) ).getText().contains( d ) );
    }

    @Step("Нажатие на меню Наушники")
    public void stepClickMenuHeadphones() {
        marketPage.headphones.click();
    }

    @Step("Выбран чек бокс Beats")
    public void stepClickBeats() {
        marketPage.clickBeats.click();
    }

    @Step("Выполнена проверка Элиментов на форме = 12")
    public void stepCheckCountOfHeadphonesEliments() {
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 5, 1000);
        wait.until( ExpectedConditions.visibilityOf(
                BaseSteps.getDriver().findElement( By.xpath("(//DIV[@class='n-snippet-cell2__title'])"))));
        assertEquals( 12,  BaseSteps.getDriver().findElements( By.xpath( "(//DIV[@class='n-snippet-cell2__title'])" ) ).size() );
    }

    @Step("Запомнили значение 1ого элимента")
    public String stepFoundFirstHeadphonesEliment() {
        String k =  BaseSteps.getDriver().findElement( By.xpath( "(//DIV[@class='n-snippet-cell2__title'])[1]" ) ).getText();
        return k;
    }

    @Step("Вводим значение первого элимента в поисковую строку")
    public void stepInputFirstElimentOfHeadphonesToSearch(String l) {
        BaseSteps.getDriver().findElement( By.xpath( "//INPUT[@id='header-search']" ) ).sendKeys( l );
    }

    @Step("Проверяем текстовку найденного элимента")
    public void stepCheckTextOfHeadphones(String l) {
        Assert.assertTrue(  BaseSteps.getDriver().findElement( By.xpath( "//LI[@class='n-breadcrumbs__item n-breadcrumbs__item_type_text']" ) ).getText().contains( l ) );
    }

    @Step("Поле {0} заполняется значенем {1}")
    public void stepFillField(String field, String value) {
        new MarketPage( BaseSteps.getDriver()).fillField( field, value );
    }

    @Step("Заполняются поля: ")
    public void stepFillFields(HashMap<String, String> fields) {
        fields.forEach( this::stepFillField );
    }
    @Step("поле {0} заполнено значением {1}")
    public void stepCheckFillField(String field, String value){
        String actual = new MarketPage( BaseSteps.getDriver()).getFillField(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }

    @Step("поля заполнены верно")
    public void stepCheckFillFields(HashMap<String, String> fields){
        fields.forEach((k, v)-> stepCheckFillField(k,v));
    }
}
