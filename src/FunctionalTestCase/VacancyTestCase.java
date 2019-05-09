package FunctionalTestCase;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.Vacancy;
import Utilities.BaseClass;

public class VacancyTestCase extends BaseClass {
	
	@Test
	public void recruitmentVacancy() throws InterruptedException, AWTException {
		logger=extent.createTest("recruitmentVacancy");
		LoginPage login=new LoginPage(driver);
		login.doLogin(username, password);
		logger.info("launch login");
		Vacancy vac=new Vacancy(driver);
		vac.recruitment();
		logger.info("hover on recruitment menu");
		vac.addVacancy();
		logger.info("click on vacancy option and then click add button to add vacancy");
		vac.jobTitle(dropNo);
		logger.info("select job title");
		vac.vacancyName(vName);
		logger.info("fill vacancy name");
		vac.hiringManager(mgName);
		logger.info("list and select hiring manager");
		vac.position(noOfPosition);
		logger.info("add no of position");
		vac.descrip(desc);
		logger.info("Add description for job profile");
		vac.save();
		logger.info("save all!");
		boolean bool=vac.isSuccessfulAdded();
		Assert.assertTrue(bool);
		logger.info("validate for save");
	}

}
