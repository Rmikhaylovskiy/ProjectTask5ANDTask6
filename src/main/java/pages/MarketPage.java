package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;
public class MarketPage {
    @FindBy(xpath = "//A[@class='link topmenu__link'][text()='Электроника']")
    public WebElement electronica;

    @FindBy(xpath = "//A[@class='link catalog-menu__list-item metrika i-bem metrika_js_inited'][text()='Телевизоры']")
    public WebElement televizor;

    @FindBy(xpath = "//INPUT[@id='glf-pricefrom-var']")
    public WebElement inputMinSum;

    @FindBy(xpath = "//LABEL[@class='checkbox__label'][text()='Samsung']")
    public WebElement clickSamsung;

    @FindBy(xpath = "//LABEL[@class='checkbox__label'][text()='LG']")
    public WebElement clickLG;

    @FindBy(xpath = "//button[@class='button button_action_n-filter-apply button_size_s button_pseudo_yes button_theme_pseudo i-bem button_js_inited']")
    public WebElement clickButtonPrimenit;

    @FindBy(xpath = "(//div[@class='n-snippet-card2__title'])[1]")
    public WebElement takeFirstElement;

    @FindBy(xpath = "//INPUT[@id='header-search']")
    public WebElement searchField;

    @FindBy(xpath = "(//BUTTON[@role='button'])[1]")
    public WebElement clickButton2;

    @FindBy(xpath = "//H1[@class='title title_size_28 title_bold_yes']")
    public WebElement tittleOfElement;

    @FindBy(xpath = " (//A[@class='link catalog-menu__list-item metrika i-bem metrika_js_inited'][text()='Наушники и Bluetooth-гарнитуры'])[2]")
    public WebElement headphones;

    @FindBy(xpath = "//LABEL[@class='checkbox__label'][text()='Beats']")
    public WebElement clickBeats;

    @FindBy(xpath = "(//DIV[@class='n-snippet-cell2__title'])[1]")
    public WebElement takeFirstElementOfheadphones;

    @FindBy(xpath = "//LI[@class='n-breadcrumbs__item n-breadcrumbs__item_type_text']")
    public WebElement tittleOfHeadphonesElement;

    public MarketPage(WebDriver driver) {
        PageFactory.initElements( BaseSteps.getDriver(), this );
    }

    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Сумма":
                fillField( inputMinSum, value );
                break;
            default:
                throw new AssertionError( "Поле '" + fieldName + "' не объявлено на странице" );
        }
    }

    public String getFillField(String fieldName){
        switch (fieldName){
            case  "Сумма":
                return inputMinSum.getAttribute("value");

        }
        throw new AssertionError("Поле не объявлено на странице");
    }
}
