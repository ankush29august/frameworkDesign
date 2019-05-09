package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Vacancy {
	WebDriver driver;
	
	@FindBy(id="menu_recruitment_viewRecruitmentModule")
	WebElement recruitment;
	
	@FindBy(id="menu_recruitment_viewJobVacancy")
	WebElement vacancy;
	
	@FindBy(id="btnAdd")
	WebElement btnAdd;
	
	@FindBy(id="addJobVacancy_jobTitle")
	WebElement jobSelect;
	
	@FindBy(id="addJobVacancy_name")
	WebElement vacancyName;
	
	@FindBy(id="addJobVacancy_hiringManager")
	WebElement managerName;
	
	@CacheLookup
	@FindBy(xpath = "//div[@class = 'ac_results']/ul/li")
	List<WebElement> hiring_mng_list;
	
	
	
//	@FindBy(xpath="/html/body/div[4]/ul/li[2] ")
//	WebElement mgName;
	
	@FindBy(id="addJobVacancy_noOfPositions")
	WebElement noOfPositions;
	
	@FindBy(id="addJobVacancy_description")
	WebElement description;
	
	@FindBy(id="btnSave")
	WebElement saveButton;
	
	@FindBy(xpath="//*[@id=\"resultTable\"]/tbody/tr/td[2]/a")
	WebElement vacancyValidate;
	
	
	
	
	
	
	
	public Vacancy(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void recruitment() {
		//WebElement ele=recruitment;
		Actions ac=new Actions(driver);
		ac.moveToElement(recruitment).build().perform();
			
	}
	
	public void addVacancy() {
		vacancy.click();
		btnAdd.click();
		
	}
	
	
	
	public void jobTitle(String dropNo) {
		Select sel=new Select(jobSelect);
		sel.selectByValue(dropNo);
	}
	
	public void vacancyName(String vName) {
		vacancyName.sendKeys(vName);
	}
	
	public void hiringManager(String mgName) throws AWTException {
		managerName.click();
		
		managerName.sendKeys(mgName);
		for(WebElement e:hiring_mng_list) {
			if(e.getText().equals(mgName)) {
				e.click();
				break;
			}
		}
		
//		Robot robot=new Robot();
//		robot.keyPress(KeyEvent.VK_SPACE);
//		robot.keyRelease(KeyEvent.VK_SPACE);
//		WebDriverWait wait=new WebDriverWait(driver,10);
//		wait.until(ExpectedConditions.elementToBeClickable(mgName));
//		mgName.click();
		
	}
	
	public void position(String noOfPosition) {
		noOfPositions.sendKeys(noOfPosition);
	}
	
	public void descrip(String desc) {
		description.sendKeys(desc);
	}
	
	public void save() {
		saveButton.click();
	}
	
	public boolean isSuccessfulAdded() {
		vacancy.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 return (vacancyValidate.getText().equals("Quality Engineer")); 
			 }
	
	
	
}
