package Pages;

import base.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import pageObject.WilsonPageObject;

import java.time.Duration;


public class WilsonPage extends Base {
    WebDriver driver;
    WilsonPageObject wilsonPageObject = new WilsonPageObject();

    public WilsonPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, wilsonPageObject);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void navigateToSite() throws InterruptedException {

        goToPage("https://returnbofeature.go-bbg.com/returns/return-order");
        waitUntilPageReady(Duration.ofMinutes(1));
    }

    public void selectTheGermanLanguage()
    {
        wilsonPageObject.anmeldung_btn.click();
    }

    public void selectTheEnglishLanguage()
    {
        wilsonPageObject.language_selector.click();
        waitUntilVisible(wilsonPageObject.english_language, Duration.ofSeconds(5));
        wilsonPageObject.english_language.click();
        wilsonPageObject.anmeldung_btn.click();
    }

    public boolean loginToWilson() throws InterruptedException {
        String your_title = "Sign in to your account";
        switchToWindowTitle(your_title);
        waitUntilVisible(wilsonPageObject.login_email_txt,Duration.ofMinutes(1));
        wilsonPageObject.login_email_txt.sendKeys("m.ehsan@go-bbg.com");
        wilsonPageObject.next_btn.click();
        try {
            waitUntilVisible(wilsonPageObject.password_txt,Duration.ofSeconds(10));
        } catch (Exception ignored) {}
        wilsonPageObject.password_txt.sendKeys("Harry@5791");
        wilsonPageObject.signin_btn.click();
        return false;
    }

    public boolean verifyThatAllTheListItemContentAreDisplayed() throws InterruptedException {
        switchToMainWindowTitle();
        waitUntilVisible(wilsonPageObject.item_Content,Duration.ofMinutes(1));
        return wilsonPageObject.item_Content_lst.get(1).getText().contains("Retouren verwalten")
                && wilsonPageObject.item_Content_lst.get(2).getText().contains("Retoure erstellen")
                && wilsonPageObject.item_Content_lst.get(3).getText().contains("Technische Kontrolle")
                && wilsonPageObject.item_Content_lst.get(4).getText().contains("Reparatur")
                && wilsonPageObject.item_Content_lst.get(5).getText().contains("Refurbishment")
                && wilsonPageObject.item_Content_lst.get(6).getText().contains("Inspektion");
    }

    public void selectTheRetourenverwalten()
    {
        wilsonPageObject.item_Content_lst.get(1).click();
    }

    public void searchForTheOrder(String order)
    {
        wilsonPageObject.order_txtField.sendKeys(order);
        waitUntilVisible(wilsonPageObject.submitBtn,Duration.ofMinutes(1));
        wilsonPageObject.submitBtn.click();
    }

    public void editButtonTheReturn() throws InterruptedException {
        int i=0;
        waitUntilVisible(wilsonPageObject.edit_btn,Duration.ofMinutes(1));
        wilsonPageObject.edit_btn.click();
        waitUntilVisible(wilsonPageObject.submitBtn,Duration.ofMinutes(1));
        scrollToView((wilsonPageObject.submitBtn));
        do {
            try {
                i++;
                wilsonPageObject.submitBtn.click();
                Thread.sleep(1000);
            } catch (Exception ignored) {}
        } while (elementExist(wilsonPageObject.retoure_btn) && i<20);
    }

    public void provideTheDetailsForTheReturn()
    {
        int i=0,j=0,k=0,l=0, m=0;
        waitUntilVisible(wilsonPageObject.return_chkBox,Duration.ofMinutes(1));
        javaScriptButtonClick(wilsonPageObject.return_chkBox);
        do {
            i++;
            try {
                wilsonPageObject.folgeschaden_drpDown.get(0).click();
                waitUntilVisible(wilsonPageObject.true_folgeschaden_option, Duration.ofSeconds(3));
                wilsonPageObject.true_folgeschaden_option.click();
                break;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } while (i<10);

        do {
            j++;
            try {
                wilsonPageObject.Retourengrund_drpDown.click();
                waitUntilVisible(wilsonPageObject.return_Reason_option,Duration.ofSeconds(3));
                wilsonPageObject.return_Reason_option.click();
                break;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } while (j<10);

        do {
            k++;
            try {
                wilsonPageObject.kompensation_drpDown.click();
                waitUntilVisible(wilsonPageObject.kompensation_item,Duration.ofSeconds(3));
                wilsonPageObject.kompensation_item.click();
                break;
            } catch (Exception ex) { System.out.println(ex.getMessage());}
        } while (k<10);

        do {
            l++;
            try {
                wilsonPageObject.rucksendung_drpDown.click();
                waitUntilVisible(wilsonPageObject.rucksendung_item,Duration.ofSeconds(3));
                wilsonPageObject.rucksendung_item.click();
                break;
            } catch (Exception ex) { System.out.println(ex.getMessage());}
        } while (l<10);
        waitUntilVisible(wilsonPageObject.comments_txtBox,Duration.ofSeconds(3));
        do {
            m++;
            wilsonPageObject.comments_txtBox.sendKeys("Testing purpose only!");
        } while (!wilsonPageObject.comments_txtBox.getText().contains("Testing purpose only!") && m<10);
        wilsonPageObject.submitBtn.click();
    }

    public boolean verifyTheReturnSuccessMessage()
    {
        waitUntilVisible(wilsonPageObject.return_success_lbl,Duration.ofMinutes(1));
        return wilsonPageObject.return_success_lbl.getText().contains("Return Order was created successfully");
    }

    public void selectTheManagereturn() throws InterruptedException {
        switchToMainWindowTitle();
        waitUntilVisible(wilsonPageObject.item_Content,Duration.ofMinutes(1));
        wilsonPageObject.item_Content_lst.get(1).click();
    }

    public void editButtonTheReturnEnglish() throws InterruptedException {
        int i=0;
        waitUntilVisible(wilsonPageObject.edit_btn,Duration.ofMinutes(1));
        wilsonPageObject.edit_btn.click();
        waitUntilVisible(wilsonPageObject.submitBtn,Duration.ofMinutes(1));
        scrollToView((wilsonPageObject.submitBtn));
        do {
            try {
                i++;
               wilsonPageObject.create_return_btn.click();
                Thread.sleep(1000);
            } catch (Exception ignored) {}
        } while (elementExist(wilsonPageObject.create_return_lst) && i<20);
    }

    private void switchToWindowTitle(String your_title) throws InterruptedException {
        Thread.sleep(3000);
        String currentWindow = driver.getWindowHandle(); //will keep current window to switch back
        for(String winHandle : driver.getWindowHandles()){
            if (driver.switchTo().window(winHandle).getTitle().equals(your_title)) {
                break;
            }
            else {
                driver.switchTo().window(currentWindow);
            }
        }
    }

    private void switchToMainWindowTitle() throws InterruptedException {

        try
        {
            driver.switchTo().window(driver.getWindowHandles().stream().toList().get(0));
        } catch (Exception ignored) {

        }
    }

    public void provideTheDetailsForTheReturnEnglish() throws InterruptedException {
        int i=0,j=0,k=0,l=0, m=0;
        waitUntilVisible(wilsonPageObject.return_chkBox,Duration.ofMinutes(1));
        javaScriptButtonClick(wilsonPageObject.return_chkBox);
        do {
            i++;
            try {
                wilsonPageObject.folgeschaden_drpDown.get(0).click();
                waitUntilVisible(wilsonPageObject.true_folgeschaden_option, Duration.ofSeconds(3));
                wilsonPageObject.true_folgeschaden_option.click();
                break;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } while (i<10);

        do {
            j++;
            try {
                wilsonPageObject.Retourengrund_drpDown.click();
                waitUntilVisible(wilsonPageObject.return_Options_English,Duration.ofSeconds(3));
                wilsonPageObject.return_Options_English.click();
                break;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } while (j<10);
        Thread.sleep(3000);
        do {
            k++;
            try {
                wilsonPageObject.kompensation_drpDown.click();
                waitUntilVisible(wilsonPageObject.kompensation_item_english,Duration.ofSeconds(3));
                wilsonPageObject.kompensation_item_english.click();
                break;
            } catch (Exception ex) { System.out.println(ex.getMessage());}
        } while (k<10);

        do {
            l++;
            try {
                wilsonPageObject.rucksendung_drpDown.click();
                waitUntilVisible(wilsonPageObject.rucksendung_item_english,Duration.ofSeconds(3));
                wilsonPageObject.rucksendung_item_english.click();
                break;
            } catch (Exception ex) { System.out.println(ex.getMessage());}
        } while (l<10);
        waitUntilVisible(wilsonPageObject.comments_txtBox_English,Duration.ofSeconds(3));
        do {
            m++;
            wilsonPageObject.comments_txtBox_English.sendKeys("Testing purpose only!");
        } while (!wilsonPageObject.comments_txtBox_English.getText().contains("Testing purpose only!") && m<10);
        wilsonPageObject.submitBtn.click();
    }

   }