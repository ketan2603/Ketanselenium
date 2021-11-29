import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "E:\\bytes\\chromedirver\\chromedriver.exe");
		
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://dev2.thebest.directory/admin/");
				
		WebElement emailname = driver.findElement(By.name("email"));
		emailname.sendKeys("testing.admindev2@yopmail.com");

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("Bytes@123");

		WebElement login = driver
				.findElement(By.xpath("/html/body/app-root/div/div/app-login/div/div/div[2]/form/div[4]/button"));
		login.click();
	}

}
