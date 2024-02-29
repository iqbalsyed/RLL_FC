package com.locator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginLocator{
	
	WebDriver driver;
	public LoginLocator(WebDriver driver) {
		  this.driver = driver;
	  PageFactory.initElements(driver, this); 
	 }
	 
	//login page
	@FindBy(xpath = "//*[@id=\"lemail\"]")
    public WebElement emailField;
	@FindBy(xpath = "//span[@class='J14SB_42 cl_fff']")
    public WebElement cont;
	
	//HomePage
	@FindBy(xpath = "//span[@class='anch myacc_2']")
    public WebElement account;
	@FindBy(xpath = "/html/body/div[1]/div[5]/div/div[3]/ul/li[8]/span[2]/ul/li[1]/a")
    public WebElement profile;
	@FindBy(xpath = "/html/body/div[1]/div[8]/div/div/div[1]/ul/li[2]/a")
    public WebElement boysfashion;
	@FindBy(xpath = "/html/body/div[1]/div[8]/div/div/div[2]/div[3]/div/div/ul[2]/li[3]/a")
    public WebElement bestseller;
	@FindBy(xpath = "//*[@id=\"maindiv\"]/div[1]/div/div[1]/div[1]/a/img")
    public WebElement shoeimage;
	@FindBy(xpath = "//*[@id=\"maindiv\"]/div[1]/div/div[2]/div[3]/div[2]/div/a")
    public WebElement addshortlist;
	@FindBy(xpath = "//span[@class='anch']")
    public WebElement shortlist;
	@FindBy(xpath = "//*[@id=\"LoginLocation\"]/div[4]/div")
    public WebElement pinconfirm;
	@FindBy(xpath = "/html/body/div[1]/div[5]/div/div[1]/a/img")
    public WebElement logo;
	@FindBy(xpath = "//*[@id=\"address\"]/div")
    public WebElement confirmadd;
	@FindBy(xpath = "/html/body/div[1]/div[5]/div/div[3]/ul/li[8]/span[2]/ul/li[14]/a")
    public WebElement clickshortlist;
	
	
	
	//shortlist //cart
	
	@FindBy(xpath = "//*[@id=\"DivContent\"]/div/div/div/div[3]/a")
    public WebElement checkshortlist;
	@FindBy(xpath = "//div[@class='bn_btn li_ml lft M14_white addtocrt']")   
    public WebElement short2cart;
	@FindBy(xpath = "//div[@class='done_btn M14_white']")
    public WebElement done;
	@FindBy(xpath = "//span[@class='prodQuant cart-icon B18_orange paddinglft']")
    public WebElement cart;
	@FindBy(xpath = "//span[@class='M15_21 removetext']")
    public WebElement cart2short;
	@FindBy(xpath = "//*[@id=\"ShortlistTab\"]")
    public WebElement myshortlist;
	@FindBy(xpath = "//span[@class='prd_delete_sz']")
    public WebElement delfromshortlist;
	
	
	
	
	
	
	//Profile Page
	@FindBy(xpath = "//*[@id=\"parent_1\"]")
	public WebElement edit;
	@FindBy(xpath = "//*[@id=\"ch_defalut\"]")
	public WebElement addchild;    
	
	@FindBy(xpath = "//*[@id=\"editt\"]")
	public WebElement editcontact;
	@FindBy(xpath = "//*[@id=\"txtAddMobilenew\"]")
	public WebElement addcontact;
	@FindBy(xpath = "//*[@id=\"callmebtn\"]")
	public WebElement savecontact;
	@FindBy(xpath = "//*[@id=\"otpsubmit\"]")
	public WebElement submitotp;
	
	@FindBy(xpath = "//span[@class='R14_link cur-point']")
    public WebElement resendotp;
	@FindBy(xpath = "//span[@class='otp-popup-close']")
    public WebElement closeotp;
	
	
	@FindBy(xpath = "/html/body/div[8]/div[2]/div[2]/div[3]/div/div[2]/div[4]/div[2]/div[2]/div[3]/div[2]/div")
	public WebElement deletechild;
	@FindBy(xpath = "//*[@id=\"confirmSubmit\"]")
	public WebElement confirmdelete;
	
	@FindBy(xpath = "//*[@id=\"addNewAddDiv\"]")
	public WebElement addaddress;
	
	@FindBy(xpath = "//span[@class='sprite-ac delete_fn']")
    public WebElement deladdress;
	
	@FindBy(xpath = "//*[@id=\"confirmSubmit\"]")
    public WebElement cofirmdeladdress;
	
	
	@FindBy(xpath = "//div[@id='chkTopOffers']")
    public WebElement topoffer;
	@FindBy(xpath = "//div[@id='chkTopDeals']")
    public WebElement topdeals;
	
	//Update Address Web Elements
			@FindBy(xpath = "//*[@id=\"txtAddName\"]")
			public WebElement nameadd;
			@FindBy(xpath = "//*[@id=\"txtAddAddress1\"]")
			public WebElement flatadd;
			@FindBy(xpath = "//*[@id=\"txtAddAddress2\"]")
			public WebElement streetadd;
			@FindBy(xpath = "//*[@id=\"txtAddAddress3\"]")
			public WebElement landadd;
			@FindBy(xpath = "//*[@id=\"txtAddPincode\"]")
			public WebElement pinadd;
			@FindBy(xpath = "//*[@id=\"txtAddMobile\"]")
			public WebElement mobileadd;
			@FindBy(xpath = "//*[@id=\"btnSaveAddress\"]")
			public WebElement saveaddbtn;
			@FindBy(xpath = "/html/body/div[8]/div[2]/div[2]/div[4]/div[3]/div[1]/div/div[12]/div[1]")
			public WebElement savebtn;
			public void clicksave() {
		        saveaddbtn.click();
		    }
			// Update Profile Web Elements 
			@FindBy(xpath = "//*[@id=\"userFnLName\"]")
			public WebElement name;
			@FindBy(xpath = "//*[@id=\"userGenderFemale\"]")
			public WebElement mom;   
			@FindBy(xpath = "//span[@id='userGenderMale']")
			public WebElement dad;
			@FindBy(xpath = "/html/body/div[8]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div/div/div[4]/span[1]")
			public WebElement guardian;
			@FindBy(xpath = "//*[@id=\"UpdateUserInfo\"]")
			public WebElement save;
			
			//   Update Child Web Elements
			@FindBy(xpath = "//*[@id=\"childFnLName\"]")
			public WebElement cname;
			@FindBy(xpath = "//*[@id=\"child\"]/div/div[2]/div[1]/div[1]/div[2]/div/div/div[1]")
			public WebElement dob;
			@FindBy(xpath = "/html/body/div[1]/div/div[21]")
			public WebElement bdate;
			@FindBy(xpath = "//*[@id=\"weight\"]")
			public WebElement weight;
			@FindBy(xpath = "//*[@id=\"height\"]")
			public WebElement height;
			@FindBy(xpath = "//*[@id=\"childGenderGirl\"]")
			public WebElement girl;
			@FindBy(xpath = "//*[@id=\"saveChild\"]")
			public WebElement savechild;
			
			public void openPage(String url) {
		        driver.get(url);
		    }
		           
		    public WebDriver getDriver() {
		        return driver;              
		    }
		    public String getCurrentUrl() {
		        return driver.getCurrentUrl();
		    }
		    
		    String email = "mkfbdhvmg@gmail.com";
		    public void sendemail( ) {
		        emailField.sendKeys(email);
		    }
		    public void sendcontact(String e ) {
		        addcontact.sendKeys(e);
		    }
		    public void sendKeys(WebElement element, String text) {
		        element.sendKeys(text);
		    }
		    public void clickcont() {
		        cont.click();
		    }
		    public void clickaddchild() {
		        addchild.click();
		    }
		    public void clickdeletechild() {
		        deletechild.click();
		    }
		    public void clickconfirmdelete() {
		        confirmdelete.click();
		    }
		    public void clickaddaddress() {
		        addaddress.click();
		    }
		    public void clickedit() {
		        edit.click();
		    }
		    public void clickeditcontact() {
		        editcontact.click();
		    }
		    public void clicksavecontact() {
		        savecontact.click();
		    }
		    public void waitForElementVisible(WebElement element) {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));
		        wait.until(ExpectedConditions.visibilityOf(element));
		    }
			
			public void updatecontact(Integer row) throws NullPointerException{
				
				
		    	XSSFWorkbook workbook;
				XSSFSheet sheet;
				XSSFCell cell;
				try {
					// Import xlsx sheet
					File src = new File("testdata\\profile.xlsx");

					// Load the file as FileInputStream.
					FileInputStream fileInput = new FileInputStream(src);

					// Load the workbook
					workbook = new XSSFWorkbook(fileInput);

					// Load the sheet in which data is stored. (0)
					sheet = workbook.getSheetAt(0);

					//for (int row = 1; row < sheet.getLastRowNum(); row++) {
						
						// import data from cell : username
						cell = sheet.getRow(row).getCell(0);
						cell.setCellType(CellType.STRING);
						name.clear();
						sendKeys(name, cell.getStringCellValue());
						Thread.sleep(600);
						cell = sheet.getRow(row).getCell(1);
						cell.setCellType(CellType.STRING);
						String Iam = cell.getStringCellValue();
//						if(Iam == "dad") {
//							dad.click();
//						}
//						if(Iam == "mom") {
//							mom.click();
//						}
//						if(Iam == "guardian") {
//							guardian.click();
//						}
						save.click();

						Thread.sleep(400);
					//}

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		    	
		    }
			public void updatechild() throws InterruptedException {
				Thread.sleep(1000);
				cname.sendKeys("Aakansha");
				dob.click();
				Thread.sleep(200);
				bdate.click();
				girl.click();
				weight.sendKeys("200");
				height.sendKeys("455");
				savechild.click();
			}
		
		public void updateaddress(String location) {
			XSSFWorkbook workbook;
			XSSFSheet sheet;
			XSSFCell cell;
			try {
				// Import xlsx sheet
				//String location = "testdata\\\\Address.xlsx";
				File src = new File(location);
				// Load the file as FileInputStream.
				FileInputStream fileInput = new FileInputStream(src);
				// Load the workbook
				workbook = new XSSFWorkbook(fileInput);
				// Load the sheet in which data is stored. (0)
				sheet = workbook.getSheetAt(0);
				//for (int row = 1; row < sheet.getLastRowNum(); row++) {
				int row =0;
					// import data from cell : username
					cell = sheet.getRow(row).getCell(1);
					cell.setCellType(CellType.STRING);
					sendKeys(nameadd, cell.getStringCellValue());
					row++;
					cell = sheet.getRow(row).getCell(1);
					cell.setCellType(CellType.STRING);
					sendKeys(flatadd, cell.getStringCellValue());
					row++;
					cell = sheet.getRow(row).getCell(1);
					cell.setCellType(CellType.STRING);
					sendKeys(streetadd, cell.getStringCellValue());
					row++;
					cell = sheet.getRow(row).getCell(1);
					cell.setCellType(CellType.STRING);
					sendKeys(landadd, cell.getStringCellValue());
					row++;
					cell = sheet.getRow(row).getCell(1);
					cell.setCellType(CellType.STRING);
					sendKeys(pinadd, cell.getStringCellValue());
					row++;
					cell = sheet.getRow(row).getCell(1);
					cell.setCellType(CellType.STRING);
					sendKeys(mobileadd, cell.getStringCellValue());
					

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	
	
	 public void setUserName(String strUserName) {
	        emailField.sendKeys(strUserName);
	    }
	    
	    public void clickLogin() {
	        cont.click();
	    }
	    public void waitfor() throws InterruptedException {
	    	wait(2000);
	    }
	    public void hover() {
	    	Actions action = new Actions(driver);
			action.moveToElement(account).perform();
	    }
	    public void hoversi() {
	    	Actions action = new Actions(driver);
			action.moveToElement(shoeimage).perform();
	    }
	    public void hoverbf() {
	    	Actions action = new Actions(driver);
			action.moveToElement(boysfashion).perform();
	    }
	    public void clickprofile() {
	        profile.click();
	    }
	   

}
	
