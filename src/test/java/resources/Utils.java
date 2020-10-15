package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {

	public static RequestSpecification req;
	
	public RequestSpecification Requestspecifactionmethod() throws IOException
	{
		
	
		
		if(req==null)
		{
		
		PrintStream printstreamobj = new PrintStream(new FileOutputStream("logging.txt"));
		
		//RestAssured.baseURI = "https://rahulshettyacademy.com";
		 //new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				 
		 req	= new RequestSpecBuilder().setBaseUri(propertiesmethod("baseuri"))
				.addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(printstreamobj))
				.addFilter(ResponseLoggingFilter.logResponseTo(printstreamobj))
				.setContentType(ContentType.JSON).build();
		
		return req;
		}
		
		return req ;
	
		
		

	}
	
	
	public static String propertiesmethod (String Key) throws IOException
	{
		Properties prop = new Properties();
		
		FileInputStream fisobj = new FileInputStream("C:\\Users\\nshibaha\\Eclipseworkspace\\APIAUTOMATIONRESTASSUREDFRAMEWORK\\src\\test\\java\\resources\\global.properties");
		
		prop.load(fisobj);
		
		return prop.getProperty(Key);
		
	}
	
	
	
	public String getJsonpathvalue(Response Response, String Key)
	{
		
		System.out.println("Response value getjsonpath method  " +Response.asString());
		
		String responsestringvalue = Response.asString();
		
		JsonPath js1 = new JsonPath(responsestringvalue);
		
		String getJsonpathvalueString =js1.get(Key).toString();
		
		return getJsonpathvalueString;
		
	}
}
