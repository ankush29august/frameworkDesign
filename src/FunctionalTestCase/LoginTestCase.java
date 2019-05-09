package FunctionalTestCase;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pages.KPI;
import Pages.LoginPage;
import Pages.Tracker;
import Pages.Vacancy;
import Utilities.BaseClass;

public class LoginTestCase extends BaseClass {
	
	@Test(priority=1)
	public void loginTest() throws InterruptedException {
		logger=extent.createTest("loginTest");
		SoftAssert sa= new SoftAssert();
		LoginPage lp=new LoginPage(driver);
		
		lp.doLogin(username, password);
		logger.info("launch the login page");
		Boolean res=lp.isSuccessful();
    	sa.assertAll();
    	logger.info("validate the page");
		
	}
//	@Test(priority=2)
//	public void recruitmentVacancy() throws InterruptedException, AWTException {
//		logger=extent.createTest("recruitmentVacancy");
//		LoginPage login=new LoginPage(driver);
//		login.doLogin(username, password);
//		Vacancy vac=new Vacancy(driver);
//		vac.recruitment();
//		vac.addVacancy();
//		vac.jobTitle(dropNo);
//		vac.vacancyName(vName);
//		vac.hiringManager();
//		vac.position(noOfPosition);
//		vac.descrip(desc);
//		vac.save();
//		boolean bool=vac.isSuccessfulAdded();
//		Assert.assertTrue(bool);
//	}
	
//	@Test(priority=3)
//	public void performKPI() {
//		logger=extent.createTest("performKPI");
//		LoginPage login=new LoginPage(driver);
//		login.doLogin(username, password);
//		
//		KPI kp=new KPI(driver);
//		kp.performanceKPI();
//		kp.kpiForm(jobVal, indic, min, max);
//	}
	
//	@Test(priority=4)
//	public void performTracker() {
//		logger=extent.createTest("performTracker");
//		LoginPage login=new LoginPage(driver);
//		login.doLogin(username, password);
//		
//		
//		Tracker tk=new Tracker(driver);
//		tk.performTracker();
//		tk.addPerformTracker(tName,empVal);
//	}

}
