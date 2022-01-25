package com.examples.cucumber;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectRepository.HomePage_OR;
import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class MyStepdefs{

    public static AppiumDriver<MobileElement> driver;
    public static DesiredCapabilities cap;
    public static String localURL = "http://127.0.0.1:4723/wd/hub";

    public MyStepdefs(){
        cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("DeviceName", "emulator-5554");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("appPackage", "com.coppel.superhero");
        cap.setCapability("appActivity", ".MainActivity");
        cap.setCapability("unicodeKeyboard", "true");
        cap.setCapability("resetKeyboard", "true");
        cap.setCapability("noReset", "true");
        cap.setCapability("fullReset", "false");
    }

    @Given("Lanzar aplicacion superheroes")
    public void lanzarAplicacionSuperheroes() throws MalformedURLException, InterruptedException {

        driver = new AndroidDriver<MobileElement>(new URL(localURL), cap);
        Thread.sleep(3000);
    }

    @Then("Validar coincidencia")
    public void validarCoincidencia() throws InterruptedException {
        Thread.sleep(5000);

        String NAMEHEROE = driver.findElementByXPath(HomePage_OR.HEROETWO).getText();
        System.out.println(NAMEHEROE);
        Assert.assertTrue(NAMEHEROE.equals("Animal Man"));

    }

    @When("Buscar a {string}")
    public void buscarA(String arg0) throws InterruptedException {
        Thread.sleep(5000);

        MobileElement el = driver.findElementByXPath(HomePage_OR.SEARCH);
        el.click();
        Thread.sleep(5000);


        driver.findElementByClassName(HomePage_OR.SEARCHHERO).sendKeys(arg0);
        driver.executeScript("mobile:performEditorAction", Map.of("action", "done"));
        Thread.sleep(5000);

    }

    @When("Seleccionar tres SuperHeroes a favoritos")
    public void seleccionarTresSuperHeroesAFavoritos() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElementByXPath(HomePage_OR.HEROEONE).click();
        Thread.sleep(5000);
        MobileElement add = driver.findElementById(HomePage_OR.ADDFAVO);
        add.click();
        Thread.sleep(5000);
        driver.navigate().back();

        Thread.sleep(5000);
        driver.findElementByXPath(HomePage_OR.HEROETWO).click();
        Thread.sleep(5000);
        MobileElement addT = driver.findElementById(HomePage_OR.ADDFAVO);
        addT.click();
        Thread.sleep(5000);
        driver.navigate().back();

        Thread.sleep(5000);
        driver.findElementByXPath(HomePage_OR.HEROETHREE).click();
        Thread.sleep(5000);
        MobileElement addr = driver.findElementById(HomePage_OR.ADDFAVO);
        addr.click();
        Thread.sleep(5000);
        driver.navigate().back();



    }

    @Then("Validar esten en favoritos")
    public void validarEstenEnFavoritos() throws InterruptedException {

        Thread.sleep(5000);
        driver.findElementByXPath(HomePage_OR.FAVO).click();

        Thread.sleep(5000);
        Assert.assertTrue(driver.findElementByXPath(HomePage_OR.HEROEONE).isEnabled());
        Assert.assertTrue(driver.findElementByXPath(HomePage_OR.HEROETWO).isEnabled());
        Assert.assertTrue(driver.findElementByXPath(HomePage_OR.HEROETHREE).isEnabled());


    }

    @When("Deseleccionar los tres favoritos")
    public void deseleccionarLosTresFavoritos() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElementByXPath(HomePage_OR.FAVO).click();

        Thread.sleep(5000);
        driver.findElementByXPath(HomePage_OR.HEROEONE).click();
        Thread.sleep(5000);
        MobileElement add = driver.findElementById(HomePage_OR.ADDFAVO);
        add.click();
        Thread.sleep(5000);
        driver.navigate().back();

        Thread.sleep(5000);
        driver.findElementByXPath(HomePage_OR.FAVO).click();


        Thread.sleep(5000);
        driver.findElementByXPath(HomePage_OR.HEROETWO).click();
        Thread.sleep(5000);
        MobileElement addT = driver.findElementById(HomePage_OR.ADDFAVO);
        addT.click();
        Thread.sleep(5000);
        driver.navigate().back();

        Thread.sleep(5000);
        driver.findElementByXPath(HomePage_OR.FAVO).click();

        Thread.sleep(5000);
        driver.findElementByXPath(HomePage_OR.HEROETHREE).click();
        Thread.sleep(5000);
        MobileElement addr = driver.findElementById(HomePage_OR.ADDFAVO);
        addr.click();
        Thread.sleep(5000);
        driver.navigate().back();

        Thread.sleep(5000);
        driver.findElementByXPath(HomePage_OR.FAVO).click();


    }

    @Then("Validar Favoritos este Vacios")
    public void validarFavoritosEsteVacios() throws InterruptedException {

        Thread.sleep(5000);
        driver.findElementByXPath(HomePage_OR.FAVO).click();
        try {
            Assert.assertFalse(driver.findElementByXPath(HomePage_OR.HEROEONE).isDisplayed());
            Assert.assertFalse(driver.findElementByXPath(HomePage_OR.HEROETWO).isDisplayed());
            Assert.assertFalse(driver.findElementByXPath(HomePage_OR.HEROETHREE).isDisplayed());
        } catch (Exception e){

        }

    }
}
