package org.base;
import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.math.BigDecimal;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	import java.util.LinkedList;
	import java.util.List;
	import java.util.Set;

	import org.apache.commons.io.FileUtils;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.CellType;
	import org.apache.poi.ss.usermodel.DateUtil;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.Select;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass {

		public static  WebDriver driver;
		
		public void getDriver (String browser) {

			switch(browser) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;

			case "Edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;

			default:
				System.out.println("In Valid Browser Type");
				break;
			}}

		
		public void getUrl(String url){
			driver.get(url);
		}
		public WebElement element(String xpathExpression ) {
			WebElement element = driver.findElement(By.xpath(xpathExpression));
			return element;
			}
		
		public void winmax() {
			driver.manage().window().maximize();
			
		}
		public void refresh() {
			driver.navigate().refresh();
			
		}
		public void keysValue(WebElement keys,String value) {
			keys.sendKeys(value);
			}
		public void screencapture() throws IOException {
			TakesScreenshot ts= (TakesScreenshot)driver;
			File source =ts.getScreenshotAs(OutputType.FILE);
			File destine= new File("C:\\Users\\Hp\\Pictures\\Saved Pictures\\login.png");
			FileUtils.copyFile(source, destine);	
			}
		public void selectoptions(WebElement element, String value ) {
			 Select s= new Select(element);
			 s.selectByValue(value);
		}
		public void selectoptions1(WebElement element1, int value ) {
			 Select s1= new Select(element1);
			 s1.selectByIndex(value);
		}
		public void sync(int s) throws InterruptedException {
			Thread.sleep(s);
			
		}
		public String getWindowsID(int index) {

			String parentWindowsID = driver.getWindowHandle();
			Set<String> allWindowsID = driver.getWindowHandles();
			List<String> li = new LinkedList<String>();
			li.addAll(allWindowsID);
			String childWindowsID = li.get(index);
			return childWindowsID;
		}
		
		public void windowsHandle(String nameOrHandle) {
			driver.switchTo().window(nameOrHandle);
		}
		
		 public void action(WebElement a) {
				Actions s= new Actions(driver);
				s.moveToElement(a).perform();
		 }
		 public void scroll(WebElement element) {
			    JavascriptExecutor js= (JavascriptExecutor)driver;
				js.executeScript("arguments[0].scrollIntoView(true)", element);
				}
		 public void navigate() {
			 driver.navigate().refresh();
			
		}
		public String readexcel(int rownum,int cellnum) throws IOException {
			File file=new File("C:\\Users\\Public\\Documents\\swaglab.xlsx");
			FileInputStream stream = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(stream);
			Sheet sheet = book.getSheet("Sheet1");
			Row row = sheet.getRow(rownum);
			Cell cell = row.getCell(cellnum);
			
			CellType celltype = cell.getCellType();
			
			String value = null;

			switch(celltype){
			case STRING:
		      value=cell.getStringCellValue();        
		     break;
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					Date date = cell.getDateCellValue();
					 SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yy");
					 value=dateformat.format(date);
					 
					
				} else {
					double numericvalue= cell.getNumericCellValue();
					BigDecimal valueof = BigDecimal.valueOf(numericvalue);
					value= valueof.toString();

				}
				break;

			default:
				break;
			}
				
		     return value;
				
				
			}

			
		}

