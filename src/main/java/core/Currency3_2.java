	package core;

	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;
	import java.io.InputStream;
	import java.net.URL;
	import java.util.concurrent.TimeUnit;

	import javax.json.Json;
	import javax.json.stream.JsonParser;
	import javax.json.stream.JsonParser.Event;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	public class Currency3_2 {
		public static void main(String[] args) throws IOException {

			
			
			String us_code = "USD";
			String country_02_code = "code";
			final String element_02 = "Rate";
			final String countryName = "geoplugin_countryName";
			final String currencyCode = "geoplugin_currencyCode";
	 
			//URL urlFR = new URL("http://www.geoplugin.net/json.gp?ip=88.191.179.56");
			
			String csvFile = "C:/Workspace/JSON_Parsing/src/main/resources/test.csv";
			BufferedReader br = null;
			String line = null;
			String splitBy = ",";
			String test_case_id = null;
			String item = null;
			String urlIp = null;
			String price = null;
			
			String [] csv = null;
			
			 br = new BufferedReader (new FileReader(csvFile));
			 WebDriver driver = new FirefoxDriver();
			 while ((line = br.readLine()) != null)
			 {
				 csv = line.split(splitBy);
				 test_case_id = csv[0];
				 item = csv[1];
				 price = csv[2];
				 urlIp = csv [3];
				 
				driver.get(urlIp);
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				

			 	
			
			URL urlIp2 =  new URL(csv[3]);
			 	
			
			
			
			InputStream is = urlIp2.openStream();
			JsonParser parser = Json.createParser(is);

			while (parser.hasNext()) {

				Event e = parser.next();

				if (e == Event.KEY_NAME) {

					switch (parser.getString()) {

					case countryName:
						parser.next();
						String country = parser.getString();
						System.out.println("             "  + test_case_id);
						System.out.println("CountryName: " + country);
						break;

					case currencyCode:
						parser.next();
						country_02_code = parser.getString();
						System.out.println("CurrencyCode: " + country_02_code);
						break;
					}
				}
			}

			URL urlrate = new URL("http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20%28%22" + us_code + country_02_code +"%22%29&format=json&env=store://datatables.org/alltableswithkeys");
					
			InputStream ins = urlrate.openStream();
			JsonParser p = Json.createParser(ins);
			while (p.hasNext()) {
				Event a = p.next();
				if (a == Event.KEY_NAME) {
					switch (p.getString()) {
					
					case element_02:
						p.next();
						String url_rate = p.getString(); // 0.8792
						Double rate1 = Double.parseDouble(url_rate);
						Double priceDouble = Double.parseDouble(price);
						// System.out.println(rate1);
						Double item_local_price = priceDouble * rate1;
						
						System.out.println("Item: " + item + "; US Price: " + priceDouble + "; Local Price: "
								+ item_local_price);
						System.out.println("=========================================================");
						break;
					}//end switch 
				}// end if
			} //end while 
			
			
			
			 } //end while (Buffered)		
			
			 
			 driver.quit();
			 br.close();	 
	} //end main 
	} //end class 

