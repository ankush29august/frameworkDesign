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

public class Sprint_1 extends BaseClass {
	
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
	@Test(priority=2)
	public void recruitmentVacancy() throws InterruptedException, AWTException {
		logger=extent.createTest("recruitmentVacancy");
		LoginPage login=new LoginPage(driver);
		login.doLogin(username, password);
		logger.info("launch Login");
		Vacancy vac=new Vacancy(driver);
		vac.recruitment();
		logger.info("Hovered on Recruitment");
		vac.addVacancy();
		logger.info("clicked on add button");
		vac.jobTitle(dropNo);
		logger.info("selected job title");
		vac.vacancyName(vName);
		logger.info("filled vacancy name");
		vac.hiringManager(mgName);
		logger.info("selected hiring manager");
		vac.position(noOfPosition);
		logger.info("filled no of Position");
		vac.descrip(desc);
		logger.info("Filled description");
		vac.save();
		logger.info("vacancy page saved");
		SoftAssert soft=new SoftAssert();
		boolean bool=vac.isSuccessfulAdded();
		soft.assertTrue(bool);
		logger.info("vacancy page successfully loaded ");
	}
	
	@Test(priority=3)
	public void performKPI() {
		logger=extent.createTest("performKPI");
		LoginPage login=new LoginPage(driver);
		login.doLogin(username, password);
		logger.info("login page launched");
		KPI kp=new KPI(driver);
		kp.performanceKPI();
		logger.info("perfromance anchor button hovered");
		kp.kpiForm(jobVal, indic, min, max);
		logger.info("kpi updated");
	}
	
	@Test(priority=4)
	public void performTracker() {
		logger=extent.createTest("performTracker");
		LoginPage login=new LoginPage(driver);
		
		login.doLogin(username, password);
		logger.info("login page launched");
		
			Tracker tk=new Tracker(driver);
		tk.performTracker();
		logger.info("hovered performance anchor button to select tracker and add items");
		tk.addPerformTracker(tName,empVal);
		logger.info("filled all the details");
	}


}
