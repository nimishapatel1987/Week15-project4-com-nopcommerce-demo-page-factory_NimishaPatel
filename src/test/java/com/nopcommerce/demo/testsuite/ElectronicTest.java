package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.Electronics;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class ElectronicTest extends BaseTest {
    Electronics electronics;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        electronics = new Electronics();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {

        electronics.mouseHoverOnElectronics();
        electronics.mouseHoverOnCellPhonesAndClick();
        electronics.verifyTextCellPhones();
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        electronics.mouseHoverOnElectronics();
        electronics.mouseHoverOnCellPhonesAndClick();
        Assert.assertEquals(electronics.verifyTextCellPhones(), "Cell phones", "Error message not displayed");
        electronics.clickOnListViewTab();
        Thread.sleep(3000);
        electronics.clickOnProductNameNokia();
        Assert.assertEquals(electronics.verifyTextNokiaLumia(), "Nokia Lumia 1020", "Error message not displayed");
        Assert.assertEquals(electronics.verifyNokiaPrice(), "$349.00", "Error message not displayed");
        electronics.clearQuantity();
        Thread.sleep(1000);
        electronics.changeQuantityTo2("2");
        Thread.sleep(1000);
        electronics.clickOnAddToCart();
        electronics.mouseHoverOnShoppingCart();
        electronics.hoverAndClickOnGoToCart();
        Assert.assertEquals(electronics.verifyMessageShoppingCart(), "Shopping cart", "Error message not displayed");
        Assert.assertEquals(electronics.verifyQuantity(), "(2)", "Error message not displayed");
        Assert.assertEquals(electronics.verifyTotal(), "$698.00", "Error message not displayed");
        electronics.clickOnCheckbox();
        electronics.clickOnCheckout();
        Assert.assertEquals(electronics.verifyTextWelcomePlease(), "Welcome, Please Sign In!", "Error message not displayed");
        electronics.clickOnRegister();
        Assert.assertEquals(electronics.verifyTextRegister(), "Register", "Error message not displayed");
        Thread.sleep(1000);

        electronics.sendTextToFirstNameField("Pari");
        electronics.sendTextToLastNameField("Patel");
        electronics.sendTextToEmailField("paripatel1234@gmail.com");
        electronics.sendTextToPasswordField("123456");
        electronics.sendTextToConfirmPasswordField("123456");

        electronics.clickOnRegister1();
        //  Assert.assertEquals(electronics.verifyMessageYourRegistrationCompleted(), "Your registration completed", "Error message not displayed");
        electronics.clickOnContinue();
        Assert.assertEquals(electronics.verifyTextShoppingCart(), "Shopping cart", "Error message not displayed");
        electronics.clickOnCheckbox1();
        electronics.clickOnCheckout1();
        electronics.countryByVisibleText("United Kingdom");
        electronics.sendTextToCity("Cambridge");
        electronics.sendTextToAddress("Cambridge");
        electronics.sendTextToPostelCode("CB4 3NB");
        electronics.sendTextToPhoneNumber("01234567890");

        electronics.clickOnContinue1();
        electronics.clickOn2ndDayAir();
        electronics.clickOnContinue2();
        electronics.clickOnCreditCard();
        electronics.clickOnContinueTab();
        electronics.clickOnVisa();

        //electronics.clickOnVisa();
        electronics.sendTextToCardholderName("PPPatel");
        electronics.sendTextToCardNumber("1111222233334444");

        electronics.sendTextToExpirationMonth("10");
        electronics.sendTextToExpirationYear("2025");
        electronics.sendTextToCardCode("675");
        electronics.clickOnContinue3();

        Assert.assertEquals(electronics.verifyPaymentMethod(), "Credit Card", "Error message not displayed");
        //    Assert.assertEquals(electronics.verifyShopingMethod(), "2nd Day Air", "Error message not displayed");
        //  Assert.assertEquals(electronics.verifyTotalPrice(), "$698.00", "Error message not displayed");

        electronics.clickOnConfirm();
        Assert.assertEquals(electronics.verifyTextThankYou(), "Thank you", "Error message not displayed");
        Assert.assertEquals(electronics.verifySuccessfully(), "Your order has been successfully processed!", "Error message not displayed");

        electronics.clickOnContinue4();
        Assert.assertEquals(electronics.verifyWelcomeToOurStore(), "Welcome to our store", "Error message not displayed");
        electronics.clickOnLogout();
    }
}
