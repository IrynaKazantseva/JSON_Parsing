package core;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

public class Currency2 {

	public static void main(String[] args) throws IOException {

		String item_01 = "Soccer Ball";
		Double item_01_price_usd = 35.00;
		String us_code = "USD";
		String country_02_code = "code";
		
		final String element_02 = "Rate";

		final String countryName = "geoplugin_countryName";
		final String currencyCode = "geoplugin_currencyCode";
 
		URL urlFR = new URL("http://www.geoplugin.net/json.gp?ip=88.191.179.56");
		
		InputStream is = urlFR.openStream();
		JsonParser parser = Json.createParser(is);

		while (parser.hasNext()) {

			Event e = parser.next();

			if (e == Event.KEY_NAME) {

				switch (parser.getString()) {

				case countryName:
					parser.next();
					String country = parser.getString();
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
					// System.out.println(rate1);
					Double item_01_eur_price = item_01_price_usd * rate1;
					System.out.println("Item 01: " + item_01 + "; US Price: " + item_01_price_usd + "; Local Price: "
							+ item_01_eur_price);
					break;
				}
			}
		}
}
}