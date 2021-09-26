package week4_day2_class;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CarWala {
	
	
	public static void main(String[] args) throws Exception {
		   WebDriverManager.chromedriver().setup();
		   ChromeDriver driver = new ChromeDriver();
		   driver.get("https://www.carwale.com/");
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		   driver.manage().window().maximize();	
		   Actions action = new Actions(driver);

		    System.out.println("2. Select the Used options");
     driver.findElement(By.xpath("//div[@data-unique-key='used']")).click();
	 
            System.out.println("3. Enter city as Chennai");
	 driver.findElement(By.xpath("//input[@placeholder='City, eg: Mumbai']")).sendKeys("Chennai");
	 driver.findElement(By.xpath("//div[@class='o-fznJzu o-fznJPk o-OAYdd o-dbKqqe o-cpnuEd o-bUVylL o-eMXLyl o-GFmfi']")).click();
	 
	 
	        System.out.println("4. set the lower limit to 4 lakhs using the slider");
     WebElement firstTog = driver.findElement(By.xpath("(//div[@class='o-eVIFUq o-cUSgRL o-fuiuOo o-jeeUx '])[1]"));
     action.clickAndHold(firstTog).perform();
     action.dragAndDropBy(firstTog, 70, 0).perform();
     
           
     WebElement secondTog = driver.findElement(By.xpath("(//div[@class='o-eVIFUq o-cUSgRL o-fuiuOo o-jeeUx '])[2]"));
     action.clickAndHold(secondTog).perform();
     action.dragAndDropBy(secondTog, -130, 0).perform();
     action.release();
     
         System.out.println(" 6. Ensure if you have chosen correctly using the text displayed in the text box above ");
     String textCheck = driver.findElement(By.xpath("//div[contains(@class,'o-cYOpxG o-fznJDS o-fznJFI o-fzptVd o-fzptYr')]")).getText();
     boolean contains = textCheck.contains("4 - 12");
     Assert.assertEquals(true, contains);
     System.out.println("Asser Passed - Scenario Validated");
     
     File src =  driver.getScreenshotAs(OutputType.FILE);
     File dst = new File("./Snaps/CarWale Script Passed.png");
     FileUtils.copyFile(src, dst);

}

}
