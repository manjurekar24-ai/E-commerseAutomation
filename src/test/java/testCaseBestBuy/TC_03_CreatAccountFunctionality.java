package testCaseBestBuy;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;

import baseBestBuy.BaseClassBB;
import pagesBestBuy.CreatAccountPageBB;
import pagesBestBuy.HomePageBB;

public class TC_03_CreatAccountFunctionality extends BaseClassBB {
	
	@BeforeClass
	public void setupClass() {
		sheetName="loginTestData";
	}
	
	@BeforeMethod
	public void setup() {
		testName = "tc_03_validateCreatAccountFunctionality";
		testDescription = "CreatAccount Functionality";
		testCategory = "Regression";
		testAuthor = "Basil Ahamed";
		// Call parent setUp method to initialize WebDriver
		super.setUp();
	}
	
	@Test(dataProvider="getFromExcel", priority=3)
	public void tc_03_validateCreatAccountFunctionality(String fname, String lname, String emailId,
			String pass, String repass, String mob, String xpathText, String expMsg) throws Exception {
		// Country selection is already handled in BaseClassBB.initialization()
		HomePageBB hp=new HomePageBB();
		hp.goToCreatAccount();
		CreatAccountPageBB ca=new CreatAccountPageBB();
		String actMsg = ca.creatAccountFunctionality(fname, lname, emailId, pass, repass, mob, xpathText);
		softAssert(actMsg, expMsg);
		if (actMsg.equals(expMsg)) {
			reportStep("Validating CreatAccount Functionality - Pass", "Pass", testName);
		} else {
			reportStep("Validating CreatAccount Functionality - Fail", "Fail", testName);
		}
	}
}
