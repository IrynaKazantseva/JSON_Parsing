package core;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

public class Currency {
	public static void main(String[] args) throws IOException {

		String item_01 = "Soccer Ball";
		Double item_01_price_usd = 35.00;
		

		//final String element_01 = "id";
		final String element_02 = "Rate";

		final String countryName = "geoplugin_countryName";
		final String currencyCode = "geoplugin_currencyCode";

		URL urlFR = new URL("http://www.geoplugin.net/json.gp?ip=88.191.179.56");

		URL urlCH = new URL("http://www.geoplugin.net/json.gp?ip=123.126.136.198");
		
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
					System.out.println("CurrencyCode: " + parser.getString());
					break;
				}
			}
		}

		URL urlrate = new URL(
				"http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20%28%22USDEUR%22%29&format=json&env=store://datatables.org/alltableswithkeys");

		InputStream ins = urlrate.openStream();
		JsonParser p = Json.createParser(ins);
		while (p.hasNext()) {
			Event a = p.next();
			if (a == Event.KEY_NAME) {
				switch (p.getString()) {
				//case element_01:
				//	p.next();
				//	String country_01_code = p.getString(); // USDEUR
					// System.out.println("country_01_code: " + p.getString());
				//	break;

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

		///////////////////////China

		InputStream is2 = urlCH.openStream();
		JsonParser parser2 = Json.createParser(is2);

		while (parser2.hasNext()) {

			Event e = parser2.next();

			if (e == Event.KEY_NAME) {

				switch (parser2.getString()) {

				case countryName:
					parser2.next();
					String country = parser2.getString();
					System.out.println("CountryName: " + country);
					break;

				case currencyCode:
					parser2.next();
					System.out.println("CurrencyCode: " + parser2.getString());
					break;
				}
			}
		}

		URL urlrate2 = new URL(
				"http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.xchange%20where%20pair%20in%20%28%22USDCNY%22%29&format=json&env=store://datatables.org/alltableswithkeys");

		InputStream ins2 = urlrate2.openStream();
		JsonParser p2 = Json.createParser(ins2);
		while (p2.hasNext()) {
			Event a = p2.next();
			if (a == Event.KEY_NAME) {
				switch (p2.getString()) {
			//	case element_01:
				//	p2.next();
					//String country_02_code = p2.getString(); // USDCNY
					// System.out.println("country_02_code: " + p2.getString());
					//break;

				case element_02:
					p2.next();
					String url_rate2 = p2.getString(); // 0.8792
					Double rate2 = Double.parseDouble(url_rate2);
					// System.out.println(rate1);
					Double item_01_CNY_price = item_01_price_usd * rate2;
					System.out.println("Item 01: " + item_01 + "; US Price: " + item_01_price_usd + "; Local Price: "
							+ item_01_CNY_price);
					break;
				}
			}
		}

	}
}