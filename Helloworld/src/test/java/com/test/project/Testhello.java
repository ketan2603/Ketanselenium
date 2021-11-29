package com.test.project;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.nio.file.DirectoryStream.Filter;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.internal.MouseAction.Button;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testhello {
	public WebDriver driver;
	
	@Test(priority = 1)
	public void login() throws InterruptedException  {

    	System.setProperty("webdriver.chrome.driver", "E:\\bytes\\chromedirver\\chromedriver.exe");
    	this.driver=new ChromeDriver();
    	driver.manage().window().maximize();
        driver.get("https://dev2.thebest.directory/admin/");	
		
		WebElement emailname = driver.findElement(By.name("email"));
		emailname.sendKeys("testing.admindev2@yopmail.com");

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("Bytes@123");

		WebElement login =driver.findElement(By.xpath("/html/body/app-root/div/div/app-login/div/div/div[2]/form/div[4]/button"));
		login.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
				}
	@SuppressWarnings("deprecation")
	@Test(priority = 2)
	public void article() throws InterruptedException  {
		
		WebElement aclick= driver.findElement(By.xpath("/html/body/app-root/div/app-navbar/div/div/nav/div/ul/li[2]"));
		aclick.click();
	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
		WebElement search =driver.findElement(By.xpath("/html/body/app-root/div/div/app-admin-article-list/div/div/div[2]/div/div[1]/div[1]/input"));
		search.sendKeys("Loream New Latest Article 27 Sponsored By:Evelyn Patel");
		search.sendKeys(Keys.ENTER);
		Thread.sleep(100);
		search.clear();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Select cetegory= new Select(driver.findElement(By.id("category")));
		Thread.sleep(100);
		cetegory.selectByVisibleText("FEGLI");
		Thread.sleep(100);
		cetegory.selectByIndex(4);
		
		Thread.sleep(50);
 		this.cfilter();
	
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Select autosharef= new Select(driver.findElement(By.id("autoshare")));
		Thread.sleep(100);
		autosharef.selectByVisibleText("Yes");
		Thread.sleep(100);
		autosharef.selectByValue("No");	
		Thread.sleep(100);
		
		Thread.sleep(50);
 		this.cfilter();
	//	autosharef.deselectAll();
//		driver.navigate().refresh();
//		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
//		WebElement user=driver.findElement(By.xpath("/html/body/app-root/div/div/app-admin-article-list/div/div/div[2]/div/div[1]/div[4]/ngx-select-dropdown/div/button/span[1]"));
//		user.click();
//		Thread.sleep(100);
//		WebElement searchs= driver.findElement(By.name("search-text"));
//		searchs.sendKeys("Bhaumik Patadiya");
//		searchs.sendKeys(Keys.ENTER);
		
		driver.navigate().refresh();
		Select status= new Select(driver.findElement(By.id("articleStatus")));
		Thread.sleep(100);
		status.selectByValue("scheduled");
		Thread.sleep(100);
		status.selectByVisibleText("View AOPL");
		
		Thread.sleep(50);
 		this.cfilter();
		
		driver.navigate().refresh();
		Select sstging= new Select(driver.findElement(By.id("dummy_date")));
		Thread.sleep(100);
		sstging.selectByValue("5");
		Thread.sleep(100);
		sstging.selectByVisibleText("Last 15 days");
		
		Thread.sleep(50);
 		this.cfilter();	
	}
	
		public void cfilter() {
		
		WebElement filter= driver.findElement(By.xpath("/html/body/app-root/div/div/app-admin-article-list/div/div/div[2]/div/div[1]/div[7]/a[2]"));
		filter.click();	
	}
 	
		@Test(priority=3)
public void createarticle() throws InterruptedException {
 		Thread.sleep(100);
		WebElement carticle= driver.findElement(By.xpath("/html/body/app-root/div/div/app-admin-article-list/div/div/div[2]/div/div[1]/div[7]/a[3]"));
		carticle.click();
		
		Thread.sleep(50);
		Select ctype = new Select(driver.findElement(By.name("content_type")));
		ctype.selectByValue("Editorial");
		
		Thread.sleep(50);
		Select ccategory = new Select(driver.findElement(By.name("category_id")));
		ccategory.selectByVisibleText(" PS Retirement ");
		
		WebElement title =driver.findElement(By.id("colFormLabel"));
		title.sendKeys("Loream New Latest Article 27 Sponsored By:Evelyn Patel");
		
		Thread.sleep(50);
		WebElement image = driver.findElement(By.name("image"));
		image.sendKeys("C:\\Users\\Ketan\\Pictures\\Saved Pictures\\image.jpg");
		
	    WebElement confirm= driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[3]/button[1]"));
		confirm.click();

		WebElement autoshare= driver.findElement(By.xpath("/html/body/app-root/div/div/app-admin-article/div/div/div[2]/div/form/div[6]/div/div/label[2]"));
		autoshare.click();
		
//		WebElement discription =driver.findElement(By.id("/html/body/p"));
//		discription.sendKeys("Loream New Latest Article 27 Sponsored By:Evelyn Patel Loream New Latest Article 27 Sponsored By:Evelyn Patel Loream New Latest Article 27 Sponsored By:Evelyn Patel");
		
		WebElement editorFrame = driver.findElement(By.xpath("//*[@id=\"cke_3_contents\"]/iframe"));

		driver.switchTo().frame(editorFrame);

		WebElement body = driver.findElement(By.tagName("body"));

		body.clear(); 
		body.sendKeys("some text");
		
		Thread.sleep(10);
		WebElement metatitle = driver.findElement(By.cssSelector("body > app-root > div > div > app-admin-article > div > div > div.row.mainTable > div > form > div:nth-child(9) > div > input"));
		metatitle.sendKeys("Loream");
		
		WebElement mdescription = driver.findElement(By.cssSelector("body > app-root > div > div > app-admin-article > div > div > div.row.mainTable > div > form > div:nth-child(10) > div > textarea"));
		mdescription.sendKeys("Loream New Latest Article ");
		
		WebElement mkeywords = driver.findElement(By.cssSelector("body > app-root > div > div > app-admin-article > div > div > div.row.mainTable > div > form > div:nth-child(11) > div > input"));
		mkeywords.sendKeys("Article 27 Sponsored By:Evelyn Patel");
		
		WebElement checkbox= driver.findElement(By.name("direct_dummy"));
		checkbox.click();
		
		Select stostging= new Select(driver.findElement(By.name("user_id")));
		stostging.selectByVisibleText("Ronaldo Portugal");
		
		WebElement addarticle=driver.findElement(By.xpath("/html/body/app-root/div/div/app-admin-article/div/div/div[2]/div/form/div[12]/div/button[2]"));
		addarticle.click();
		
	}
		private FluentWait<WebDriver> WebDriverWait(WebDriver driver2, int i) {
			// TODO Auto-generated method stub
			return null;
		}	}

	
	
	

