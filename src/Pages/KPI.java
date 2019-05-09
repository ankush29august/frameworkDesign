package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

public class KPI {
	
	WebDriver driver;
	
	@FindBy(id="menu__Performance")
	WebElement performance;
	
	@FindBy(id="menu_performance_Configure")
	WebElement config;
	
	@FindBy(id="menu_performance_searchKpi")
	WebElement searchKpi;
	
	@FindBy(id="btnAdd")
	WebElement addButton;
	
	@FindBy(id="defineKpi360_jobTitleCode")
	WebElement jobTitle;
	
	@FindBy(id="defineKpi360_keyPerformanceIndicators")
	WebElement kpIndicator;
	
	@FindBy(id="defineKpi360_minRating")
	WebElement minRating;
	
	
	@FindBy(id="defineKpi360_maxRating")
	WebElement maxRating;
	
	@FindBy(id="defineKpi360_makeDefault")
	WebElement makeDefault;
	
	@FindBy(id="saveBtn")
	WebElement saveKpiBtn;
	
	
	
	
	public KPI(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void performanceKPI() {
		Actions act=new Actions(driver);
		act.moveToElement(performance).build().perform();
		 WebDriverWait wait= new WebDriverWait(driver,10);
		 wait.until(ExpectedConditions.visibilityOf(config));
		act.moveToElement(config).build().perform();
		 try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		searchKpi.click();
		//click to add button
		addButton.click();
	
	}

	public void kpiForm(String jobVal,String indic,String min,String max) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	Select sel=new Select(jobTitle);
	sel.selectByValue(jobVal);
	 kpIndicator.sendKeys(indic);
	 minRating.sendKeys(min);
	 maxRating.sendKeys(max);
	 makeDefault.click();
	 saveKpiBtn.click();
	}
	

}
