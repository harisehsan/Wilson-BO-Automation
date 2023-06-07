package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.cert.X509Certificate;
import java.util.List;

public class WilsonPageObject {
    @FindBy(xpath = "//span[@class='mat-button-wrapper']") public WebElement anmeldung_btn;
    @FindBy (id = "i0116") public WebElement login_email_txt;
    @FindBy (xpath = "//input[@id='idSIButton9']") public WebElement next_btn;
    @FindBy (xpath = "//input[@id='i0118']") public WebElement password_txt;
    @FindBy (xpath = "//input[@id='idSIButton9']") public WebElement signin_btn;
    @FindBy (xpath = "//div[@class='mat-list-item-content']") public List<WebElement> item_Content_lst;
    @FindBy (xpath = "//div[@class='mat-list-item-content']") public WebElement item_Content;
    @FindBy (id = "mat-input-13") public WebElement order_txtField;
    @FindBy (css = "button[type='submit']") public WebElement submitBtn;
    @FindBy (xpath = "(//span[normalize-space()='Retoure erstellen'])[1]") public List <WebElement> retoure_btn;
    @FindBy (xpath = "(//mat-icon[@role='img'][normalize-space()='edit'])[1]") public WebElement edit_btn;
    @FindBy (xpath = "//div[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']") public WebElement return_chkBox;
    @FindBy (xpath = "//mat-select[@formcontrolname='consequentialDamage']//div[@aria-hidden='true']//div//div") public List <WebElement> folgeschaden_drpDown;
    @FindBy (xpath = "//div[@class='mat-select-value ng-tns-c72-113']") public List <WebElement> folgeschaden_drpDown_2;
    @FindBy (xpath = "//span[normalize-space()='True']") public WebElement true_folgeschaden_option;
    @FindBy (xpath = "//mat-select[@formcontrolname='returnReasonId']//div[@aria-hidden='true']//div//div") public WebElement Retourengrund_drpDown;
    @FindBy (xpath = "//span[normalize-space()='Gebrochen bei Gebrauch']") public WebElement return_Reason_option;
    @FindBy (xpath = "//mat-select[@formcontrolname='compensationId']//div[@aria-hidden='true']//div//div") public WebElement kompensation_drpDown;
    @FindBy (xpath = "//span[normalize-space()='Erstattung']") public WebElement kompensation_item;
    @FindBy (xpath = "//mat-select[@formcontrolname='shipmentNeeded']//div[@aria-hidden='true']//div//div") public WebElement rucksendung_drpDown;
    @FindBy (xpath = "//span[normalize-space()='Falsch']") public WebElement rucksendung_item;
    @FindBy (xpath = "//textarea[contains(@placeholder,'Grund')]") public WebElement comments_txtBox;
    @FindBy (xpath = "//span[normalize-space()='Return Order was created successfully']") public WebElement return_success_lbl;
    @FindBy (xpath = "//body[1]/app-root[1]/app-layout[1]/mat-sidenav-container[1]/mat-sidenav-content[1]/div[1]/app-login[1]/div[1]/mat-card[1]/mat-form-field[1]/div[1]/div[1]/div[3]/mat-select[1]/div[1]/div[2]/div[1]") public WebElement language_selector;
    @FindBy (xpath = "//span[normalize-space()='English']") public WebElement english_language;
    @FindBy (xpath = "(//span[normalize-space()='Create Return'])[1]") public WebElement create_return_btn;
    @FindBy (xpath = "(//span[normalize-space()='Create Return'])[1]") public List <WebElement> create_return_lst;
    @FindBy (xpath = "//mat-option[@role='option']//span[contains(text(),'Item got damaged while using')]") public WebElement return_Options_English;
    @FindBy (xpath = "//span[normalize-space()='Refund']") public WebElement kompensation_item_english;
    @FindBy (xpath = "//span[normalize-space()='False']") public WebElement rucksendung_item_english;
    @FindBy (xpath = "//textarea[contains(@placeholder,'Reason')]") public WebElement comments_txtBox_English;

}
