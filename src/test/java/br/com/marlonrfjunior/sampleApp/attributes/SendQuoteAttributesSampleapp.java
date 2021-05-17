package br.com.marlonrfjunior.sampleApp.attributes;

import br.com.marlonrfjunior.sampleApp.utils.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SendQuoteAttributesSampleapp extends BasePage {

    @FindBy(id = "email")
    protected WebElement fieldEmail;

    @FindBy(id = "phone")
    protected WebElement fieldPhone;

    @FindBy(id = "username")
    protected WebElement fieldUsername;

    @FindBy(id = "password")
    protected WebElement fieldPassword;

    @FindBy(id = "confirmpassword")
    protected WebElement fieldConfirmPassword;

    @FindBy(id = "Comments")
    protected WebElement textAreaComments;

    @FindBy(id = "sendemail")
    protected WebElement btnSend;


}
