package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tracker {
	
	WebDriver driver;
	@CacheLookup
	@FindBy(id="menu__Performance")
	WebElement perform;
	
	@CacheLookup
	@FindBy(id="menu_performance_Configure")
	WebElement config;
	
	@CacheLookup
	@FindBy(id="menu_performance_addPerformanceTracker")
     WebElement track;
	
	@CacheLookup
	@FindBy(id="btnAdd")
	WebElement trackAdd;
	
	@CacheLookup
	@FindBy(id="addPerformanceTracker_tracker_name")
	WebElement trackerName;
	
	@CacheLookup
	@FindBy(id="addPerformanceTracker_employeeName_empName")
	WebElement employeeName;
	
	@CacheLookup
	@FindBy(xpath = "//div[@class = 'ac_results']/ul/li")
	List<WebElement> employeeList;
	
    @CacheLookup
    @FindBy(id="addPerformanceTracker_availableEmp")
    WebElement fromTracker;
    
    @FindBy(id="btnAssignEmployee")
    WebElement empAddBtn;
	
    @FindBy(id="btnSave")
    WebElement saveTrackBtn;
	
	public Tracker(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void performTracker() {
		Actions act=new Actions(driver);
		act.moveToElement(perform).build().perform();
		 WebDriverWait wait= new WebDriverWait(driver,10);
		 wait.until(ExpectedConditions.visibilityOf(config));
		act.moveToElement(config).build().perform();
		 try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		track.click();
		//click to add button
		trackAdd.click();
	}
	
	public void addPerformTracker(String tName,String empVal) {
		//tName="Ankush Tanwar"
		trackerName.sendKeys(tName);
		employeeName.sendKeys("john");
		for(WebElement e:employeeList) {
			if(e.getText().equals("John Smith")) {
				e.click();
				break;
			}
		}
		
		Select sel=new Select(fromTracker);
		//empVal="7"
		sel.selectByValue(empVal);
		empAddBtn.click();
		saveTrackBtn.click();
				
		
	}
	
	
}
