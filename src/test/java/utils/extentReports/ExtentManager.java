package utils.extentReports;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.relevantcodes.extentreports.ExtentReports;

// ExtentReports extent instance created here. That instance can be reachable by getReporter() method.

public class ExtentManager {

	protected static ExtentReports extent;
	static Properties prop = new Properties();
	static String environment;
	static String platform;
	static InputStream input;

	public synchronized static ExtentReports getReporter() {
		try {
			if (extent == null) {
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
				Date date = new Date();

				input = new FileInputStream(
						System.getProperty("user.dir") + "/src/test/resources/ConfigFiles/config.properties");
				prop.load(input);
				// load a properties file
				environment = prop.getProperty("Environment");
				platform = prop.getProperty("Platform");
				// Set HTML reporting file location
				String htmlReportDir = System.getProperty("user.dir");
				extent = new ExtentReports(htmlReportDir + "/src/test/resources/Reports/PfizerReport_" + platform + "_"
						+ dateFormat.format(date) + ".html", true);
				extent.loadConfig(
						new File(System.getProperty("user.dir") + "/src/test/resources/ConfigFiles/extent-config.xml"));
			}
		} catch (Exception e) {
			System.out.println("Exception while creating Report");
		}
		return extent;
	}
}