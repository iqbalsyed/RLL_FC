package stepdefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.openqa.selenium.io.FileHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.locator.LoginExcelData;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginExcelDataStep {
	
	static WebDriver driver = new ChromeDriver();
    LoginExcelData lp= PageFactory.initElements(driver, LoginExcelData.class);

//    @Before
//    public void setUp() {
//        driver = new ChromeDriver();
//        lp = PageFactory.initElements(driver, LoginExcelData.class);
//        driver.manage().window().maximize();
//    }
//
//    @After
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
	
	private static final Logger logger = LogManager.getLogger(LoginExcelDataStep.class);
	private static final String EXCEL_PATH = "testdata\\ExcelData.xlsx";
	private static final String SHEET_NAME = "Sheet1";

	
	@Given("User lands on the homepage")
	public void user_lands_on_the_homepage() {
		logger.info("User lands on the homepage");
		driver.manage().window().maximize();
		driver.get("https://www.firstcry.com/");
		String et = "Baby Products Online India: Newborn Baby Products & Kids Online Shopping at FirstCry.com";
		String at = driver.getTitle();
		Assert.assertEquals(et, at, "User on homepage");

	}

	@When("user clikcs on the loginbtn")
	public void user_clikcs_on_the_loginbtn() {
		logger.info("User click on the login");
		lp.clickloginButton();
		String url = "https://www.firstcry.com/m/login?URL=https://www.firstcry.com/";
		Assert.assertEquals(url, driver.getCurrentUrl());
	}

	@When("user enters the email from row {int}")
	public void user_enters_the_email_from_row1(Integer RowNumber) throws IOException, InterruptedException {
		logger.info("user enters email");
		Object[][] excelData = readExcelData(EXCEL_PATH, SHEET_NAME);
		String emailorphonenumber = excelData[RowNumber][0].toString();
		lp.Login(emailorphonenumber);
		Thread.sleep(200);
	}
	
	@When("user clicks on continuebtn {int}")
	public void user_clicks_on_continuebtn(Integer i) throws InterruptedException {
		logger.info("user clicks on continuebtn");
		WebElement continuebtn=driver.findElement(By.xpath("//*[@id=\"login\"]/div/div[3]/span"));
		continuebtn.click();
		Thread.sleep(200);
		takeScreenShot(+i+"firstcry-login.png");
	
		
	}

	@Then("user gets the login status")
	public void user_gets_the_login_status() {
	   
	}
	
	
	public static void takeScreenShot(String fileName) {
		// 1. type cast driver instance too take screen shot
		TakesScreenshot tsc = (TakesScreenshot) driver ;
		
		// 2. call take screen shot method with file type
		File src = tsc.getScreenshotAs(OutputType.FILE);
		
		// 3. create  file  with screen shot
		try {
			FileHandler.copy(src, new File("screenshot_Login\\" +fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
private Object[][] readExcelData(String filePath, String sheetName) throws IOException {
		FileInputStream file = new FileInputStream(filePath);
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet(sheetName);

		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rowCount][colCount];

		for (int i = 1; i <= rowCount; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				Cell cell = row.getCell(j);
				data[i - 1][j] = cell.toString();
			}
		}

		workbook.close();
		file.close();

		return data;
	}
}



