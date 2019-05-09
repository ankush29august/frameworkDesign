package FunctionalTestCase;

import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.Tracker;
import Utilities.BaseClass;

public class TrackerTestCase extends BaseClass {
	
	@Test
	public void performTracker() {
		logger=extent.createTest("performTracker");
		LoginPage login=new LoginPage(driver);
		login.doLogin(username, password);
		logger.info("launch login");
		
		Tracker tk=new Tracker(driver);
		tk.performTracker();
		logger.info("select tracker option");
		tk.addPerformTracker(tName,empVal);
		logger.info("Add tracker details");
	}

}
