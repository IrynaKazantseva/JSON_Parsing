package core;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

public class JSON {
public static void main(String[] args) throws IOException {
		
		URL urlUSA = new URL("http://www.geoplugin.net/json.gp?ip=216.113.169.239");
		URL urlFR = new URL ("http://www.geoplugin.net/json.gp?ip=88.191.179.56");
		URL urlCH = new URL ("http://www.geoplugin.net/json.gp?ip=123.126.136.198");
		URL urlGB = new URL ("http://www.geoplugin.net/json.gp?ip=217.10.135.73");
		URL urlUK = new URL ("http://www.geoplugin.net/json.gp?ip=91.211.213.10");
		
		
		final String element_01 = "geoplugin_city";
		final String element_02 = "geoplugin_region";
		final String element_03 = "geoplugin_latitude";
		final String element_04 = "geoplugin_longitude";

		String element_name_01 = "City: ";
		String element_name_02 = "State: ";
		String element_name_03 = "Latitude: ";
		String element_name_04 = "Longitude: ";

		 
		InputStream is1 = urlUSA.openStream();
		JsonParser parser1 = Json.createParser(is1);
		
		InputStream is2 = urlFR.openStream();
		JsonParser parser2 = Json.createParser(is2);
		
		InputStream is3 = urlCH.openStream();
		JsonParser parser3 = Json.createParser(is3);
		
		InputStream is4 = urlGB.openStream();
		JsonParser parser4 = Json.createParser(is4);

		InputStream is5 = urlUK.openStream();
		JsonParser parser5 = Json.createParser(is5);



		///////////////////////USA
		while (parser1.hasNext()) {

		Event e = parser1.next();

		if (e == Event.KEY_NAME) {

			switch (parser1.getString()) {

			case element_01:
				parser1.next();
				System.out.println(element_name_01 + parser1.getString());
			break;

			case element_02:
				parser1.next();
				System.out.println(element_name_02 + parser1.getString());
			break;
			
			case element_03:
				parser1.next();
				System.out.println(element_name_03 + parser1.getString());
			break;
			
			case element_04:
				parser1.next();
				System.out.println(element_name_04 + parser1.getString());
				System.out.println("///////////////////////////////////");
			break;
			}

		}
	}
		
///////////////////////FRANCE
while (parser2.hasNext()) {

Event e = parser2.next();

if (e == Event.KEY_NAME) {

switch (parser2.getString()) {

case element_01:
	parser2.next();
	System.out.println(element_name_01 + parser2.getString());
break;

case element_02:
	parser2.next();
	System.out.println(element_name_02 + parser2.getString());
break;

case element_03:
	parser2.next();
	System.out.println(element_name_03 + parser2.getString());
break;

case element_04:
	parser2.next();
	System.out.println(element_name_04 + parser2.getString());
	System.out.println("///////////////////////////////////");
break;
}

}
}

///////////////////////CHINA
while (parser3.hasNext()) {

Event e = parser3.next();

if (e == Event.KEY_NAME) {

switch (parser3.getString()) {

case element_01:
parser3.next();
System.out.println(element_name_01 + parser3.getString());
break;

case element_02:
parser3.next();
System.out.println(element_name_02 + parser3.getString());
break;

case element_03:
parser3.next();
System.out.println(element_name_03 + parser3.getString());
break;

case element_04:
parser3.next();
System.out.println(element_name_04 + parser3.getString());
System.out.println("///////////////////////////////////");
break;
}

}
}


///////////////////////GBritan
while (parser4.hasNext()) {

Event e = parser4.next();

if (e == Event.KEY_NAME) {

switch (parser4.getString()) {

case element_01:
parser4.next();
System.out.println(element_name_01 + parser4.getString());
break;

case element_02:
parser4.next();
System.out.println(element_name_02 + parser4.getString());
break;

case element_03:
parser4.next();
System.out.println(element_name_03 + parser4.getString());
break;

case element_04:
parser4.next();
System.out.println(element_name_04 + parser4.getString());
System.out.println("///////////////////////////////////");
break;
}

}
}

///////////////////////Ukraine
while (parser5.hasNext()) {

Event e = parser5.next();

if (e == Event.KEY_NAME) {

switch (parser5.getString()) {

case element_01:
parser5.next();
System.out.println(element_name_01 + parser5.getString());
break;

case element_02:
parser5.next();
System.out.println(element_name_02 + parser5.getString());
break;

case element_03:
parser5.next();
System.out.println(element_name_03 + parser5.getString());
break;

case element_04:
parser5.next();
System.out.println(element_name_04 + parser5.getString());
System.out.println("///////////////////////////////////");
break;
}

}
}

	}

}
