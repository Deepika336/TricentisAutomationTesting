package utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportGenerator {

	public static ExtentReports extent;
	public static ExtentTest logger;
	public static int i = 1;

	public void startReport() {
		extent = new ExtentReports("C:\\Users\\Hp\\OneDrive\\Documents\\selenium\\selenium demo\\TricentisSprint_team2\\Reports\\Tricentis.html",
				true);
	}
	
	

	public void startTest() {
		logger = extent.startTest("test" + i);		
		logger.log(LogStatus.PASS,"test is pass");		
		i++;
	}

	
	public void endTest() {
		extent.flush();
		extent.endTest(logger);
	}

	public void endReport() {
		extent.close();
	}

}
