package com.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
    List<WebElement> topMenuListField;
    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktopTab;
    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopsAndNoteBooksTab;
    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement componentsTab;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccounts;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement registerAccountText;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    WebElement loginAccountText;

    //    By currencySelector = By.xpath("//span[contains(text(),'Currency')]");
//    By currencyGBP = By.className("GBP");
//
//    public void chooseGBP() {
//        mouseHoverToElementAndClick(currencySelector);
//        mouseHoverToElementAndClick(currencyGBP);
//    }
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currencySelector;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'£ Pound Sterling')]")
    WebElement currencyGBP;

    public void chooseGBP() {
        mouseHoverToElementAndClick(currencySelector);
        mouseHoverToElementAndClick(currencyGBP);
    }
    public void selectMenu(String menu) {
        List<WebElement> topMenuList = topMenuListField;
        try {
            for (WebElement element : topMenuList) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            topMenuList = topMenuListField;
        }
    }

    public void mouseHoverAndClickOnDesktop() {
        Reporter.log("Hovering and Clicking on desktop " + desktopTab.toString());
        mouseHoverToElementAndClick(desktopTab);
        CustomListeners.test.log(Status.PASS,"Click on desktop");
    }

    public void mouseHoverAndClickOnLaptopsAndNotebooks() {
        Reporter.log("Hovering and Clicking on laptops and notebooks " + laptopsAndNoteBooksTab.toString());
        mouseHoverToElementAndClick(laptopsAndNoteBooksTab);
        CustomListeners.test.log(Status.PASS,"Click on laptops and notebooks tab");
    }

    public void mouseHoverAndClickOnComponents() {
        Reporter.log("Hovering and Clicking on components " + componentsTab.toString());
        mouseHoverToElementAndClick(componentsTab);
        CustomListeners.test.log(Status.PASS,"Click on components tab");
    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountsList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        try {
            for (WebElement options : myAccountsList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountsList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        }
    }

    public void clickOnMyAccount() {
        Reporter.log("Clicking on my account " + myAccounts.toString());
        clickOnElement(myAccounts);
        CustomListeners.test.log(Status.PASS,"Click on my accounts tab");
    }

    public String getRegisterAccountText() {
        Reporter.log("Getting register account text " + registerAccountText.toString());
        CustomListeners.test.log(Status.PASS,"Get register account text");
        return getTextFromElement(registerAccountText);
    }

    public String getLoginAccountText() {
        Reporter.log("Getting login account text " + loginAccountText.toString());
        CustomListeners.test.log(Status.PASS,"Get login account text");
        return getTextFromElement(loginAccountText);
    }


}
