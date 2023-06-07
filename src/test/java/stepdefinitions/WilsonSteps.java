package stepdefinitions;

import Pages.WilsonPage;
import base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class WilsonSteps {

    private BaseUtil base;
    WilsonPage wilsonPage;

    public WilsonSteps(BaseUtil base)  {
        this.base = base;
        wilsonPage = new WilsonPage(base.driver);
    }

    @Given("I navigate to the wilson site")
    public void iNavigateToTheWilsonSite() throws InterruptedException {
      wilsonPage.navigateToSite();
    }

    @And("I login to the wilson site")
    public void iLoginToTheWilsonSite() throws InterruptedException {
        wilsonPage.loginToWilson();
    }

    @Then("I verify that all items are correctly displayed")
    public void iVerifyThatAllItemsAreCorrectlyDisplayed() throws InterruptedException {
        Assert.assertTrue(wilsonPage.verifyThatAllTheListItemContentAreDisplayed());
    }

    @And("I select the Retouren verwalten")
    public void iSelectTheRetourenVerwalten() {
        wilsonPage.selectTheRetourenverwalten();
    }

    @When("I search the order number {string}")
    public void iSearchTheOrderNumber(String arg0) {
        wilsonPage.searchForTheOrder(arg0);
    }

    @And("I select edit button")
    public void iSelectEditButton() throws InterruptedException {
        wilsonPage.editButtonTheReturn();
    }

    @And("I provide the details for the return")
    public void iProvideTheDetailsForTheReturn() {
        wilsonPage.provideTheDetailsForTheReturn();
    }

    @Then("I should see the return success message")
    public void iShouldSeeTheReturnSuccessMessage() {
        Assert.assertTrue(wilsonPage.verifyTheReturnSuccessMessage(),"The return is not successfully created!");
    }

    @And("I let select the language german")
    public void iLetSelectTheLanguageGerman() {
        wilsonPage.selectTheGermanLanguage();
    }

    @And("I let select the language English")
    public void iLetSelectTheLanguageEnglish() {
        wilsonPage.selectTheEnglishLanguage();
    }

    @And("I select the Manage return")
    public void iSelectTheManageReturn() throws InterruptedException {
        wilsonPage.selectTheManagereturn();
    }

    @And("I select edit button non DE")
    public void iSelectEditButtonNonDE() throws InterruptedException {
        wilsonPage.editButtonTheReturnEnglish();
    }


    @And("I provide the details for the return for english")
    public void iProvideTheDetailsForTheReturnForEnglish() throws InterruptedException {
      wilsonPage.provideTheDetailsForTheReturnEnglish();
    }
}
