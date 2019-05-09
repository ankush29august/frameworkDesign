package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserManagement {
	WebDriver driver;
	
	@FindBy(id="menu_admin_viewAdminModule")
	WebElement menuAdmin;
	
	@FindBy(id="menu_admin_UserManagement")
	WebElement userManage;

	
	@FindBy(id="menu_admin_viewSystemUsers")
	WebElement usersView;
	
	@FindBy(id="searchSystemUser_userName")
	WebElement uName;
	
	@FindBy(id="searchSystemUser_employeeName_empName")
	WebElement employeeName;
	
	@FindBy(id="searchBtn")
	WebElement searchBtn;
	

//	@FindBy()
//	WebElement

	
	public UserManagement(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void usersManage() {
		Actions act=new Actions(driver);
		act.moveToElement(menuAdmin).build().perform();
		act.moveToElement(userManage).build().perform();
		usersView.click();
	}
	
	public void systemUsers(String userName,String empName) {
		uName.sendKeys(userName);
		
	}

}
