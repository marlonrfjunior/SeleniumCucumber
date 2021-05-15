package br.com.marlonrfjunior.sampleApp.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {


	private static WebDriver driver = Hooks.getDriver();
	private static Duration gap(int time){return Duration.ofSeconds(time);}
//	protected ExtentTest extentTest = TestRule.getExtentTest();
//	protected ExtentReports extentReport = TestRule.getExtentReports();
	private final Logger logger = Logger.getLogger(BasePage.class);

	public BasePage() {}


	protected void fixedWait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			logger.error("Erro ao executar wait(int seconds)", e);
		}
	}

	protected void moveToElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	protected boolean isElementDisplayed(By by) {
		boolean isElementPresent;
		boolean isElementDisplayed = false;
		isElementPresent = !driver.findElements(by).isEmpty();
		if (isElementPresent) {
			isElementDisplayed = driver.findElement(by).isDisplayed();
		}
		return isElementPresent && isElementDisplayed;
	}

//	private String saveScreenshotInRelatoriosPath() {
//		Calendar calendar = Calendar.getInstance();
//		int day = calendar.get(Calendar.DAY_OF_MONTH);
//		int month = calendar.get(Calendar.MONTH) + 1;
//		int year = calendar.get(Calendar.YEAR);
//		int hours = calendar.get(Calendar.HOUR_OF_DAY);
//		int minutes = calendar.get(Calendar.MINUTE);
//		int seconds = calendar.get(Calendar.SECOND);
//		int milliseconds = calendar.get(Calendar.MILLISECOND);
//		String datahora = "" + day + month + year + "_" + hours + minutes + seconds + milliseconds;
//		String screenShotName = datahora + ".png";
//		File scrFile = null;
//		try {
//				scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//				FileUtils.copyFile(scrFile, new File("target/report/html/img/" + screenShotName));
//
//		} catch (IOException e) {
//			logger.error("Erro ao salvar screenshot.", e);
//		}
//		return screenShotName;
//	}

//	protected void log(String log) {
//		String screenShotName = saveScreenshotInRelatoriosPath();
//		try {
//			extentTest.pass(log, MediaEntityBuilder.createScreenCaptureFromPath("img/" + screenShotName).build());
//		} catch (IOException e) {
//			logger.error("Erro ao executar logPrint()", e);
//		}
//	}
//
//	public void logPrintFail(String log) {
//		String screenShotName = saveScreenshotInRelatoriosPath();
//		try {
//			extentTest.fail(log, MediaEntityBuilder.createScreenCaptureFromPath("img/" + screenShotName).build());
//		} catch (IOException e) {
//			logger.error("Erro ao executar logPrintFail()", e);
//		}
//	}
//
//	protected void logInfo(String log) {
//		extentTest.info(log);
//	}
//
//	protected void logSkip(String log) {
//		extentTest.skip(log);
//	}
//
//	protected void logFail(String log) {
//		extentTest.fail(log);
//	}
//
//	protected void logError(String log) {
//		extentTest.error(log);
//	}
//
//	protected void logPass(String log) {
//		extentTest.pass(log);
//	}
//
//	protected ExtentTest createChildStart(String strNomeTeste) {
//		ExtentTest parentTest = TestRule.getExtentTest();
//		ExtentTest child = parentTest.createNode(strNomeTeste);
//		return child;
//	}
//
//	protected void childLogFail(ExtentTest child, String log) {
//		child.fail(log);
//	}
//
//	protected void childLogPass(ExtentTest child, String log) {
//		child.pass(log);
//	}
//
//	protected void childLogInfo(ExtentTest child, String log) {
//		child.info(log);
//	}
//
//	protected void multiType(String arg, int count) {
//		for (int i = 0; i < count; i++) {
//			type(arg);
//		}
//	}
//
//




//	public void aguardarDownloadArquivo() {
//		String downloadFilepath = System.getProperty("user.dir") + "/target/temp";
//		Utils.waitForFileExistsInPath(downloadFilepath, 10);
//		waitMilliseconds(500);
//	}

//	public void efetuarPrints(String strMensagemLog) {
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//
//		int intAlturaTotalVertical = Integer
//				.valueOf(driver.findElement(By.xpath("//html/body")).getAttribute("scrollHeight"));
//		jse.executeScript("scroll(0," + intAlturaTotalVertical + ")");
//		int intRolagemVerticalMaxima = Integer
//				.valueOf(driver.findElement(By.xpath("//html/body")).getAttribute("scrollTop"));
//
//		int intAlturaVisivelNaTela = intAlturaTotalVertical - intRolagemVerticalMaxima;
//
//		int intQuantidadePrintsVertical = intAlturaTotalVertical / (intAlturaVisivelNaTela - 15);
//
//		for (int i = 0; i < intQuantidadePrintsVertical; i++) {
//			jse.executeScript("scroll(0," + (i * (intAlturaVisivelNaTela - 15)) + ")");
//			this.log(strMensagemLog);
//		}
//
//		jse.executeScript("scroll(0," + (intAlturaTotalVertical) + ")");
//		this.log(strMensagemLog);
//	}
//
//	public void efetuarPrintsVH(String strMensagemLog) {
//		List<WebElement> lstDIVs = driver.findElements(By.xpath(
//				"//div[not(@id='cabecalho')][not(@id='cabecalhoPagina')][not(@id='botoesPagina')][not(@id='btnVoltar')][not(@id='exportContainer')][not(@class='classHidden')][not(@class='noExport')][not(@id='loadingScreen')]"));
//
//		List<WebElement> lstDIVsSelecionadas = new ArrayList<WebElement>();
//		WebElement DIVSelecionado = null;
//		int intAlturaMaxima = 0;
//		int intAlturaVisivel = 0;
//		int intLarguraMaxima = 0;
//		int intLarguraVisivel = 0;
//		for (WebElement webElement : lstDIVs) {
//			intLarguraMaxima = Integer.valueOf(webElement.getAttribute("scrollWidth"));
//			intLarguraVisivel = Integer.valueOf(webElement.getAttribute("clientWidth"));
//			intAlturaMaxima = Integer.valueOf(webElement.getAttribute("scrollHeight"));
//			intAlturaVisivel = Integer.valueOf(webElement.getAttribute("clientHeight"));
//
//			if ((intLarguraMaxima - intLarguraVisivel > 10) && webElement.getCssValue("overflow").equals("auto")) {
//				lstDIVsSelecionadas.add(webElement);
//			}
//		}
//		if (lstDIVsSelecionadas.size() == 1) {
//			DIVSelecionado = lstDIVsSelecionadas.get(0);
//			intLarguraMaxima = Integer.valueOf(DIVSelecionado.getAttribute("scrollWidth"));
//			intLarguraVisivel = Integer.valueOf(DIVSelecionado.getAttribute("clientWidth"));
//			intAlturaMaxima = Integer.valueOf(DIVSelecionado.getAttribute("scrollHeight"));
//			intAlturaVisivel = Integer.valueOf(DIVSelecionado.getAttribute("clientHeight"));
//		} // considera o iframeContent
//		else if (lstDIVsSelecionadas.size() == 0) {
//			for (WebElement webElement : lstDIVs) {
//				DIVSelecionado = webElement;
//				if (Integer.valueOf(DIVSelecionado.getAttribute("scrollWidth")) > intLarguraMaxima) {
//					intLarguraMaxima = Integer.valueOf(DIVSelecionado.getAttribute("scrollWidth"));
//				}
//				if (Integer.valueOf(DIVSelecionado.getAttribute("scrollHeight")) > intAlturaMaxima) {
//					intAlturaMaxima = Integer.valueOf(DIVSelecionado.getAttribute("scrollHeight"));
//				}
//			}
//			driver.switchTo().defaultContent();
//			intAlturaVisivel = Integer.valueOf(driver.findElement(By.id("iframeContent")).getAttribute("clientHeight"));
//			intLarguraVisivel = Integer.valueOf(driver.findElement(By.id("iframeContent")).getAttribute("clientWidth"));
//			driver.switchTo().frame("iframeContent");
//			DIVSelecionado = null; // pois nenhum DIV sera utilizado na rolagem de pagina
//		}
//
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//
//		int intQuantidadePrintsVertical = intAlturaMaxima / intAlturaVisivel;
//		int intQuantidadePrintsHorizontal = intLarguraMaxima / intLarguraVisivel;
//
//		// considera o /html/body
//		if (DIVSelecionado == null) {
//			DIVSelecionado = driver.findElement(By.xpath("/html/body"));
//
//			for (int i = 0; i <= intQuantidadePrintsVertical; i++) {
//				for (int j = 0; j <= intQuantidadePrintsHorizontal; j++) {
//					jse.executeScript(
//							"scroll(" + (j * (intLarguraVisivel - 25)) + "," + (i * (intAlturaVisivel - 15)) + ")");
//					this.log(strMensagemLog);
//				}
//			}
//			// considera o div com overflow = auto
//		} else {
//			// posiciona no topo a esquerda
//			jse.executeScript("document.getElementById('" + DIVSelecionado.getAttribute("id") + "').scrollDown = 0 ");
//			jse.executeScript("document.getElementById('" + DIVSelecionado.getAttribute("id") + "').scrollLeft = 0 ");
//			this.log(strMensagemLog);
//
//			for (int i = 0; i < intQuantidadePrintsVertical; i++) {
//				for (int j = 0; j < intQuantidadePrintsHorizontal; j++) {
//					jse.executeScript("document.getElementById('" + DIVSelecionado.getAttribute("id")
//							+ "').scrollLeft += " + (intLarguraVisivel - 25) + ";");
//					this.log(strMensagemLog);
//				}
//				jse.executeScript("document.getElementById('" + DIVSelecionado.getAttribute("id") + "').scrollDown += "
//						+ (intAlturaVisivel - 15) + ";");
//			}
//		}
//	}

	protected static WebElement findElementByXpath(String xpath){
		return  driver.findElement(By.xpath(xpath));
	}
	/**
	 * Clicar no WebElemnt com uma espera
	 * @param webElement
	 */
	protected static void click(WebElement webElement) {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		webElement.click();
		driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
	}

	/**
	 * Clicar no By com uma espera
	 * @param by
	 */
	protected static void click(By by) {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(by).click();
		driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
	}

	/**
	 * Envia um determinado texto parametrizado de acordo com o WebElement com uma espera
	 * @param webElement
	 * @param text
	 */
	protected static void setText(WebElement webElement, String text) {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		webElement.sendKeys(text);
		driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
	}

	/**
	 * Envia um determinado texto parametrizado de acordo com o WebElement com uma espera
	 * @param by
	 * @param text
	 */
	public static void setText(By by, String text) {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(by).sendKeys(text);
		driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
	}

	/**
	 * Retorna o texto do WebElement com uma espera
	 * @param webElement
	 * @return
	 */
	protected static String getText(WebElement webElement) {
		String text;
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		if (webElement.getAttribute("value").equals("")) {
			text = webElement.getAttribute("innerText");
		} else {
			text = webElement.getAttribute("value");
		}
		driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
		return text;
	}

	/**
	 * Retorna o texto do by com uma espera
	 * @param by
	 * @return
	 */
	protected static String getText(By by) {
		String text;
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		if (driver.findElement(by).getAttribute("value").equals("")) {
			text = driver.findElement(by).getAttribute("innerText");
		} else {
			text = driver.findElement(by).getAttribute("value");
		}
		driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
		return text;
	}

	/**
	 * Retorna o texto do by com uma espera
	 * @param by
	 * @return
	 */
	protected static void select(By by, String option) {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		Select combo = new Select(driver.findElement(by));
		combo.selectByVisibleText(option);
		driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
	}

	/**
	 * Retorna o texto do webElement com uma espera
	 * @param webElement
	 * @return
	 */
	public static void select(WebElement webElement, String option) {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		Select combo = new Select(webElement);
		combo.selectByVisibleText(option);
		driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
	}

}