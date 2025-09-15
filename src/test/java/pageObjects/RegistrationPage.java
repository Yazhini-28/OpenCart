package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage {

	WebDriver driver;
	
	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtPasswordConfirm;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkPolicy;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstName(String fName) {
		txtFirstName.sendKeys(fName);
	}
	
	public void setLastName(String lName) {
		txtLastName.sendKeys(lName);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String tel) {
		txtTelephone.sendKeys(tel);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void setPasswordConfirm(String passwordConfirm) {
		txtPasswordConfirm.sendKeys(passwordConfirm);
	}
	
	public void setPrivacyPolicy() {
		chkPolicy.click();
	}
	
	public void clickContinue() {
		btnContinue.click();
		
		//btnContinue.submit();
		
		//btnContinue.sendKeys(Keys.RETURN);
		
		//Actions act = new Actions(driver);
		//act.moveToElement(btnContinue).build().perform();
		
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btnContinue);
		
		//WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//myWait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
	}
	
	public String getConfirmationMsg() {
		try {
		 return (msgConfirmation.getText());
		}
		catch(Exception e) {
		 return (e.getMessage());	
		}
	}
}
