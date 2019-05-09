package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage  {
	
	WebDriver driver;

	@FindBy(id="txtUsername")
	 @CacheLookup
	 WebElement txtUsername;
	 
	 @FindBy(id="txtPassword")
	 @CacheLookup
	 WebElement txtPassword;
	 
	 @FindBy(id="btnLogin")
	 WebElement btnLogin;
	 
	 @FindBy(id="menu_dashboard_index")
	 WebElement dashboard;
	 
	
	 
	
	
	public LoginPage(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	}

		public void doLogin(String uname,String pwd) {
			txtUsername.sendKeys(uname);
			txtPassword.sendKeys(pwd);
			btnLogin.click();
		}
	 public boolean isSuccessful() {
		 WebDriverWait wait= new WebDriverWait(driver,10);
		 wait.until(ExpectedConditions.visibilityOf(dashboard));
		 return (dashboard.getText().equals("Dashboard")); 
			 }

}
