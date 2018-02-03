package steps;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;
import pages.MarketPage;
import static org.junit.Assert.assertEquals;
import static steps.BaseSteps.baseUrl;
public class ScenarioSteps {
    MainSteps mainSteps = new MainSteps();
    MarketSteps marketSteps = new MarketSteps();
    MarketPage marketPage = new MarketPage( BaseSteps.getDriver());



    @When("Осуществлен переход на страницу Яндекса")
    public void stepTransferToYa() {
        BaseSteps.getDriver().get(baseUrl);
    }

    @When("^Выбран пунк меню \"(.*)\"$")
    public void stepSelectMenuMarket(String menuItem) {
        mainSteps.stepSelectMainMenu( menuItem );
    }

    @When("Выбран пунк меню - Электроника")
    public void stepClickElectronika() {
        marketSteps.stepClickElectronika();
    }

    @When("Выбран пунк меню - Телевизоры")
    public void stepClickMenuTV() {
        marketSteps.stepClickMenuTV();
    }

    @When("^заполняются поля:$")
    public void stepFullfillFields(DataTable fields) {
        fields.asMap( String.class, String.class ).forEach(
                (key, value) -> marketSteps.stepFillField( key, value ) );
    }

    @Then("^значения полей равны:$")
    public void stepCheckFillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> marketSteps.stepCheckFillField(field, value));
    }

    @When("Выбран чек бокс Samsung")
    public void stepClickSamsung() {
        marketSteps.stepClickSamsung();
    }

    @When ("Выбран чек бокс LG")
    public void stepClickLG(){
        marketSteps.stepClickLG();
    }

    @When ("Выполнено нажатие на кнопку Применить")
    public void stepButtonPrimenit(){

        try {
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        marketSteps.stepButtonPrimenit();
    }

    @When ("Выполнена проверка Элиментов на форме телевизоров = 12")
    public void stepCheckCountOfEliments (){
        marketSteps.stepCheckCountOfEliments();
    }


    @When ("Запомнили значение 1ого элимента Телевизора и делаем поиск по нему")
    public void stepFoundFirstEliment (){
        String s = BaseSteps.getDriver().findElement( By.xpath( "(//div[@class='n-snippet-card2__title'])[1]" ) ).getText();
        BaseSteps.getDriver().findElement( By.xpath( "//INPUT[@id='header-search']" ) ).sendKeys( s);
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 5, 1000);
        wait.until( ExpectedConditions.elementToBeClickable(
                BaseSteps.getDriver().findElement(By.xpath("(//BUTTON[@role='button'])[1]"))));
        BaseSteps.getDriver().findElement( By.xpath( "(//BUTTON[@role='button'])[1]" ) ).click();
        Assert.assertTrue( BaseSteps.getDriver().findElement( By.xpath( "//H1[@class='title title_size_28 title_bold_yes']" ) ).getText().contains(s));
    }

    @When( "Выбран пунк меню - Наушники" )
    public void stepClickMenuHeadphones() {
        marketPage.headphones.click();
    }

    @When("Выбран чек бокс Beats")
    public void stepClickBeats() {
        marketPage.clickBeats.click();
    }

    @When("Выполнена проверка Элиментов на форме наушников = 12")
    public void stepCheckCountOfHeadphonesEliments() {
        marketSteps.stepCheckCountOfHeadphonesEliments();
    }

    @When("Запомнили значение 1ого элимента Наушников и делаем поиск по нему")
    public void stepFoundFirstHeadphonesEliment() {
        String k =  BaseSteps.getDriver().findElement( By.xpath( "(//DIV[@class='n-snippet-cell2__title'])[1]" ) ).getText();
        BaseSteps.getDriver().findElement( By.xpath( "//INPUT[@id='header-search']" ) ).sendKeys( k );
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 5, 1000);
        wait.until( ExpectedConditions.elementToBeClickable(
                BaseSteps.getDriver().findElement(By.xpath("(//BUTTON[@role='button'])[1]"))));
        BaseSteps.getDriver().findElement( By.xpath( "(//BUTTON[@role='button'])[1]" ) ).click();
        Assert.assertTrue(  BaseSteps.getDriver().findElement( By.xpath( "//LI[@class='n-breadcrumbs__item n-breadcrumbs__item_type_text']" ) ).getText().contains( k ) );
    }

}
