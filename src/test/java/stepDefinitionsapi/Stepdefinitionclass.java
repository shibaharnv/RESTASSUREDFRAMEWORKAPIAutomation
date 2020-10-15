package stepDefinitionsapi;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResourcesEnum;
import resources.Testdatabuild;
import resources.Utils;

public class Stepdefinitionclass extends Utils {

	ResponseSpecification resspect;
	RequestSpecification request;
	Response responsevalue;
	JsonPath js1;
	Testdatabuild data = new Testdatabuild();

	static String placeidvalue;

	@Given("Add place payload with {string} {string} {string}")

	public void add_place_payload_with(String language, String name, String phonenumber) throws IOException {
		// here we are just framing the url like this
		// :https://rahulshettyacademy.com/"xxfromwhenblock"/json?key=qaclick123
		// and pass the values from feature file for payload.

		RestAssured.baseURI = "https://rahulshettyacademy.com";

		RestAssured.useRelaxedHTTPSValidation();
		request = given().log().all().spec(Requestspecifactionmethod())
				.body(data.addplacepayload(language, name, phonenumber));
		resspect = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	}

	@When("User calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String httpmehtod) {

		resspect = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		APIResourcesEnum resourceenumobj = APIResourcesEnum.valueOf(resource);
		System.out.println(resourceenumobj.getresourcemethod());
		if (httpmehtod.equalsIgnoreCase("POST")) {
			responsevalue = request.when().post(resourceenumobj.getresourcemethod());
		} else if (httpmehtod.equalsIgnoreCase("GET")) {
			responsevalue = request.when().get(resourceenumobj.getresourcemethod());
		}
	}

	@Then("The Api call got sucess with {int} response code.")
	public void the_Api_call_got_sucess_with_response_code(Integer int1) {

		int actualstatucode = responsevalue.getStatusCode();
		assertEquals(actualstatucode, 200);
	}

	@Then("The {string} code should be {string}")
	public void the_code_should_be(String keyvalue, String expectedvalue) {

		assertEquals(getJsonpathvalue(responsevalue, keyvalue), expectedvalue);
		System.out.println("All testcases passed");
	}

	@Then("Do the get call using {string} with place id and verify the {string} in the response")
	public void do_the_get_call_using_with_place_id_and_verify_the_in_the_response(String resource, String expectedname)
			throws IOException {

		placeidvalue = getJsonpathvalue(responsevalue, "place_id");
		request = given().log().all().spec(Requestspecifactionmethod()).queryParam("place_id", placeidvalue);
		user_calls_with_http_request(resource, "GET");
		String actualname = getJsonpathvalue(responsevalue, "name");
		assertEquals(actualname, expectedname);
		System.out.println("Name values are matching");
	}

	@Given("Delete the place by adding the payload with placeid")
	public void delete_the_place_by_adding_the_payload_with_placeid() throws IOException {

		request = given().log().all().spec(Requestspecifactionmethod()).body(data.deleteplacepayload(placeidvalue));

		System.out.println("DELETE METHOD :Added place deleted");
	}

}
