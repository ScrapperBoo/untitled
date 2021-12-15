import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.junit.Test;



import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class testcase extends tetsttt {
    private final static String BASE_URL = "http://xn----8sbalhqhcqniie4b.xn--p1ai/";
    private final static String ERROR_MESSAGE = "Неправильный логин или пароль.";
    private final static String WRONG_LOGIN = "Неправильный логин .";
    private final static String WRONG_PASSWORD = "Неправильный пароль.";
    private final static String EXPECTED_CITY = "Екатеринбург";
    private final static String CATEGORY_OF_MENU = "Для колбасы";

    private final SelenideElement linkPersonalRoom = $x("//input[@class='form']");
    private final SelenideElement pressBtnSearch = $x("//button[@class='go']");
    private final SelenideElement chooseCat = $x("//select[@name=\"category_id\"]");
    private final SelenideElement btnBuy = $x("//button[@class='order_go']");
    private final SelenideElement Prise = $x("//span[@id=\"cart-total\"]");
    private final SelenideElement otzyv = $x("////a[@href=\"/kontakty\"]");
    private final  ElementsCollection collection= $$x("//div[@id=\"nav\"]//ul//li//a");
    private final  SelenideElement entertext= $x("//textarea[@name=\"enquiry\"]");


    @Test
    public  void SearchMenu()
    {
        Selenide.open(BASE_URL);
        linkPersonalRoom.setValue("гриб");
        Selenide.sleep(5000);
        pressBtnSearch.click();
        chooseCat.selectOption("      Сушеные грибы");
        Selenide.sleep(5000);
        Assert.assertTrue(chooseCat.getText().contains("      Сушеные грибы"));

    }
    @Test
    public  void BuyProduct()
    {
        Selenide.open(BASE_URL);
        btnBuy.click();
        Selenide.sleep(5000);
        Assert.assertTrue(Prise.getText().contains("15 товар(ов) - "));


    }
    @Test
    public  void Write()
    {
        Selenide.open(BASE_URL);
        btnBuy.click();
        SelenideElement btnBuy= $x("//a[text()='Оформить заказ']");
        SelenideElement razmestit= $x("//input[@value=\"Разместить заказ\"]");
        btnBuy.click();
        Selenide.sleep(5000);
        razmestit.click();
        SelenideElement dangerColl= $x("//div[@class=\"text-danger\"]");
        Selenide.sleep(5000);
        Assert.assertTrue(dangerColl.getText().contains("Имя должно быть от 1 до 32 символов!"));


    }
}
