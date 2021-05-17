package br.com.marlonrfjunior.sampleApp.attributes;

import br.com.marlonrfjunior.sampleApp.utils.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ProductDataAttributesSampleapp extends BasePage {

    @FindBy(id = "insurancesum")
    protected WebElement comboInsuranceSum;

    @FindBy(id = "meritrating")
    protected WebElement comboMeritRating;

    @FindBy(id = "damageinsurance")
    protected WebElement comboDamageInsurance;

    @FindBy(id = "courtesycar")
    protected WebElement comboCourtesyCar;

    @FindBy(xpath = "//a[contains(@class,'prev')]")
    protected WebElement btnPreviousMonth;

    @FindBy(xpath = "//a[contains(@class,'-next')]")
    protected WebElement btnNextMonth;

    @FindBy(id = "openstartdatecalender")
    protected WebElement btncalendar;

    @FindBy(xpath = "//span[contains(@class,'month')]")
    protected WebElement actualMonth;

    @FindBy(xpath = "//span[contains(@class,'year')]")
    protected WebElement actualYear;

    protected WebElement selectDay(String dia){
        return findElementByXpath("//a[contains(text(),'"+dia+"')]");
    }

    protected WebElement selectProducts(String option){
        return findElementByXpath("//input[contains(@id,'"+option+"')]/..//span[@class='ideal-check']");
    }

}
