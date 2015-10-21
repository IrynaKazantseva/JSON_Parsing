package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Input {
	public static void main(String[] args) throws IOException {
		BufferedReader br = null;
		String line = null;
		String splitBy = ",";
		String test_case_id = null;
		String item_full = null;
		String item = null;
		String urlIp = null;
		String urlPrice = null;
		String url = null;
		String fname = null;
		String csvFile = "C:/Workspace/JSON_Parsing/src/main/resources/test2.csv";
		String [] csv = null;
		String price_usd = null;
		
		br = new BufferedReader (new FileReader(csvFile));
		 WebDriver driver = new FirefoxDriver();
		 while ((line = br.readLine()) != null)
		 {
			 csv = line.split(splitBy);
			 test_case_id = csv[0];
			 urlPrice = csv [1];
			 item = csv [2];
			 item_full = csv[3];
			 urlIp = csv[4];
			 
			 
			driver.get(urlPrice);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			driver.findElement(By.id("gh-ac")).sendKeys(item_full);
			driver.findElement(By.id("gh-btn")).click();
			price_usd = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[3]/div/div[1]/div/div[3]/div/div[1]/div/w-root/div/div/ul/li[1]/ul[1]/li[1]/span")).getText();
			//Double price_usdDouble = Double.parseDouble(price_usd);
			//System.out.println(price_usdDouble);
	}
		 driver.quit();
		 br.close();	 
}
}