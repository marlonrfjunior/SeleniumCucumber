package br.com.marlonrfjunior.sampleApp.utils;

import io.cucumber.core.backend.TestCaseState;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DSL {


    private static WebDriver driver = DriverManager.getDriver();
    private static int numArquivos = 0;
    private static Duration gap(int time) {
        return Duration.ofSeconds(time);
    }
    private final Logger logger = Logger.getLogger(DSL.class);

    public DSL() {
    }

    /**
     * Gerar screenshot das interações no driver
     * @param webElement
     */
    protected static void getScreenshot(WebElement webElement) {

        String fileName = "target" + File.separator + "report" + File.separator + "Screenshoots" +
                File.separator +numArquivos+"_"+ webElement.getAttribute("name") + "_screenshot";
        try {
            TakesScreenshot ss = (TakesScreenshot) getDriver();
            File screenshotAs = ss.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotAs , new File(fileName + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        numArquivos++;
    }

    /**
     * Encontra um elemento pelo Xpath
     * @param xpath
     * @return
     */
    protected static WebElement findElementByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    /**
     * Encontra um elemento pelo by
     * @param by
     * @return
     */
    protected static WebElement findElementBy(By by) {
        return driver.findElement(by);
    }

    /**
     * Clicar no WebElemnt com uma espera implicita
     *
     * @param webElement
     */
    protected static void click(WebElement webElement) {
        implicitWait(webElement , 10);
        webElement.click();
        getScreenshot(webElement);
    }


    /**
     * Envia um determinado texto parametrizado de acordo com o WebElement com uma espera
     *
     * @param webElement
     * @param text
     */
    protected static void setText(WebElement webElement , String text) {
        implicitWait(webElement , 10);
        webElement.sendKeys(text);
        getScreenshot(webElement);
    }


    /**
     * Retorna o texto do WebElement com uma espera
     *
     * @param webElement
     * @return
     */
    protected static String getText(WebElement webElement) {
        String text;
        implicitWait(webElement , 10);
        if (webElement.getAttribute("value") == null) {
            text = webElement.getAttribute("innerText");
        } else {
            text = webElement.getAttribute("value");
        }
        getScreenshot(webElement);
        return text;
    }

    /**
     * Retorna o texto do webElement com uma espera
     *
     * @param webElement
     * @return
     */
    public static void select(WebElement webElement , String option) {
        implicitWait(webElement , 10);
        Select combo = new Select(webElement);
        combo.selectByVisibleText(option);
        getScreenshot(webElement);
    }

    /** movendo a tela até o elemento
     * @param element
     */
    protected void moveToElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    /** Espera Explicita
     * @param seconds
     */
    protected void fixedWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            logger.error("Erro ao executar wait(int seconds)" , e);
        }
    }

    /** Espera implicita
     * @param element
     *  elemento que deverá ser esperado
     * @param timeOutSeconds
     * tempo que será esperado
     */
    protected static void implicitWait(WebElement element , int timeOutSeconds) {
        driver.manage().timeouts().implicitlyWait(timeOutSeconds , TimeUnit.SECONDS);
        if (element.isDisplayed()) {
            driver.manage().timeouts().implicitlyWait(0 , TimeUnit.SECONDS);
        }
    }



    /** Retorna o atual browser incializado anteriormente
     * @return
     *  Driver Atual
     */
    public static WebDriver getDriver() {
        return driver;
    }
}