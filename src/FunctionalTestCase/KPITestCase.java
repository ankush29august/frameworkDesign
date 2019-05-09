package FunctionalTestCase;

import org.testng.annotations.Test;

import Pages.KPI;
import Pages.LoginPage;
import Utilities.BaseClass;

public class KPITestCase extends BaseClass {

	
	@Test
	public void performKPI() {
		//to check git functionality
		logger=extent.createTest("PerformKPI");
		LoginPage login=new LoginPage(driver);
		
		login.doLogin(username, password);
		logger.info("login  page");
		
		KPI kp=new KPI(driver);
		kp.performanceKPI();
		logger.info("click add to Key Performance Indicator");
		kp.kpiForm(jobVal, indic, min, max);
		logger.info("Add and save detail in Indicator");
	}
}
