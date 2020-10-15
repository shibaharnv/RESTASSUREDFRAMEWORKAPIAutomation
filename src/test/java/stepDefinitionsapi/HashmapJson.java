package stepDefinitionsapi;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HashmapJson {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		RestAssured.useRelaxedHTTPSValidation();

		// json to hashmap

		HashMap<String, Object> hashmapobj = new HashMap();
		hashmapobj.put("name", "shibahar");
		hashmapobj.put("isbn", "fsfsd");
		hashmapobj.put("aisle", "f32");
		hashmapobj.put("author", "fsdfsdf");

		// For multiple json create a another haspmap and assingn the map

		Response responsevalue = given().log().all().header("Content-Type", "application/json").body(hashmapobj).when()
				.post("/Library/Addbook.php").then().log().all().assertThat().statusCode(200).extract().response();

		String responsevaluestring = responsevalue.toString();

		System.out.println("responsevalue  " + responsevaluestring);
	}

}
