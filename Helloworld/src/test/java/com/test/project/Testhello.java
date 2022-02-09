package com.test.project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Testhello {
		public WebDriver driver;

	@SuppressWarnings("deprecation")
	@Test(priority = 1)
	public void loginfail() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "E:\\bytes\\chromedriver_win32\\chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev2.thebest.directory/admin/");

		WebElement emailname = driver.findElement(By.name("email"));
		emailname.sendKeys("testing.admindev2@yopmail.com");

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("Bytes@1234");

		WebElement login = driver
				.findElement(By.xpath("/html/body/app-root/div/div/app-login/div/div/div[2]/form/div[4]/button"));
		login.click();
		System.out.println("Login failed");
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

	}

	@Test(priority = 2)
	public void login() {

		driver.navigate().refresh();

		WebElement emailname = driver.findElement(By.name("email"));
		emailname.sendKeys("testing.admindev2@yopmail.com");

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("Bytes@123");

		WebElement login = driver
				.findElement(By.xpath("/html/body/app-root/div/div/app-login/div/div/div[2]/form/div[4]/button"));
		login.click();
		System.out.println("Login Sucessfully");
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
	}

	@SuppressWarnings("deprecation")
	@Test(priority = 3)
	public void article() throws InterruptedException {

		WebElement aclick = driver.findElement(By.xpath("/html/body/app-root/div/app-navbar/div/div/nav/div/ul/li[2]"));
		aclick.click();

		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		WebElement search = driver.findElement(
				By.xpath("/html/body/app-root/div/div/app-admin-article-list/div/div/div[2]/div/div[1]/div[1]/input"));
		search.sendKeys("Loream New Latest Article 27 Sponsored By:Evelyn Patel");
		search.sendKeys(Keys.ENTER);
		System.out.println("search Sucessfully");
		Thread.sleep(100);
		search.clear();

		Select scategory = new Select(driver.findElement(By.id("category")));
		scategory.selectByValue("CSM");
		System.out.println("category filter Sucessfully");
		Thread.sleep(1500);
		this.cfilter();

		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Select autosharef = new Select(driver.findElement(By.id("autoshare")));
		Thread.sleep(100);
		autosharef.selectByVisibleText("Yes");
		Thread.sleep(100);
		autosharef.selectByValue("No");
		System.out.println("autoshare filter Sucessfully");
		Thread.sleep(100);

		Thread.sleep(50);
		this.cfilter();
		// autosharef.deselectAll();
//		driver.navigate().refresh();
//		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

//		WebElement user=driver.findElement(By.xpath("/html/body/app-root/div/div/app-admin-article-list/div/div/div[2]/div/div[1]/div[4]/ngx-select-dropdown/div/button/span[1]"));
//		user.click();
//		Thread.sleep(100);
//		WebElement searchs= driver.findElement(By.name("search-text"));
//		searchs.sendKeys("Bhaumik Patadiya");
//		searchs.sendKeys(Keys.ENTER);

		driver.navigate().refresh();
		Select status = new Select(driver.findElement(By.id("articleStatus")));
		Thread.sleep(100);
		status.selectByValue("scheduled");
		Thread.sleep(100);
		status.selectByVisibleText("View AOPL");
		System.out.println("status filter Sucessfully");

		Thread.sleep(50);
		this.cfilter();

		driver.navigate().refresh();
		Select sstaging = new Select(driver.findElement(By.id("dummy_date")));
		Thread.sleep(100);
		sstaging.selectByValue("5");
		Thread.sleep(100);
		sstaging.selectByVisibleText("Last 15 days");

		Thread.sleep(50);
		this.cfilter();
	}

	public void cfilter() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement Cfilter = driver.findElement(
				By.xpath("/html/body/app-root/div/div/app-admin-article-list/div/div/div[2]/div/div[1]/div[6]/a[2]"));
		Cfilter.click();
		Thread.sleep(1500);
	}

//	@SuppressWarnings("deprecation")
//	@Test(priority = 4)
//	public <V> void createarticle() throws InterruptedException {
//
//		Thread.sleep(2000);
//		WebElement carticle = driver.findElement(
//				By.xpath("/html/body/app-root/div/div/app-admin-article-list/div/div/div[2]/div/div[1]/div[6]/a[3]"));
//		carticle.click();
//
//		Select ctype = new Select(driver.findElement(By.name("content_type")));
//		ctype.selectByValue("Editorial");
//
//		Thread.sleep(500);
//		Select ccategory = new Select(driver.findElement(By.name("category_id")));
//		ccategory.selectByVisibleText(" PS Retirement ");
//
//		WebElement title = driver.findElement(By.id("colFormLabel"));
//		title.sendKeys("Loream New Latest Article 27 Sponsored By:Evelyn Patel");
//
//		Thread.sleep(500);
//		WebElement image = driver.findElement(By.name("image"));
//		image.sendKeys("C:\\Users\\Ketan\\Pictures\\Saved Pictures\\image.jpg");
//
//		WebElement confirm = driver.findElement(By.xpath("/html/body/ngb-modal-window/div/div/div[3]/button[1]"));
//		confirm.click();
//
//		Thread.sleep(500);
//		WebElement autoshare = driver.findElement(By.xpath(
//				"/html/body/app-root/div/div/app-admin-article/div/div/div[2]/div/form/div[7]/div/div/label[2]/input"));
//		autoshare.click();
//
//		Thread.sleep(500);
//		WebElement editorFrame = driver.findElement(By.xpath("//*[@id=\"cke_3_contents\"]/iframe"));
//		driver.switchTo().frame(editorFrame);
//		WebElement body = driver.findElement(By.tagName("body"));
//		body.clear();
//		body.sendKeys("some text");
//		driver.switchTo().parentFrame();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		WebElement metatitile = driver.findElement(By.name("metatitle"));
//		metatitile.sendKeys("Loream");
//
//		WebElement mdescription = driver.findElement(By.name("metsdescription"));
//		mdescription.sendKeys("Loream New Latest Article ");
//
//		WebElement mkeywords = driver.findElement(By.name("metakeywords"));
//		mkeywords.sendKeys("Article");
//
////		WebElement checkbox = driver.findElement(By.name("direct_dummy"));
////		checkbox.click();
////		Thread.sleep(10000);
////		Select stostging = new Select(driver.findElement(By.name("user_id")));
////		stostging.selectByVisibleText("Ronaldo Portugal");	
//
//		WebElement exdate = driver.findElement(By.name("sponsor_exp_date"));
//		exdate.click();
//		Thread.sleep(500);
//		WebElement sdate = driver.findElement(By.xpath(
//				"/html/body/bs-datepicker-container/div/div/div/div/bs-days-calendar-view/bs-calendar-layout/div[2]/table/tbody/tr[3]/td[5]"));
//		sdate.click();
//
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		WebElement submit = driver.findElement(By
//				.xpath("/html/body/app-root/div/div/app-admin-article/div/div/div[2]/div/form/div[14]/div/button[2]"));
//		submit.submit();
//		Thread.sleep(1000);
//	}
}
