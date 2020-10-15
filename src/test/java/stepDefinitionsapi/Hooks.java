package stepDefinitionsapi;

import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	//@Before("@DeletePlace")
	@After("@Regression")
	public void beforescenario() throws IOException
	{
		//execute this code if place id is null
		//write a code to get place id
		
		/*
		 * Stepdefinitionclass stepdefobj = new Stepdefinitionclass();
		 * 
		 * if(Stepdefinitionclass.placeidvalue ==null )
		 * 
		 * 
		 * stepdefobj.add_place_payload_with("Thai tamil", "simpu", "100039933");
		 * 
		 * stepdefobj.user_calls_with_http_request("addplaceApi", "POST");
		 * 
		 * stepdefobj.the_Api_call_got_sucess_with_response_code(200);
		 * 
		 * stepdefobj.do_the_get_call_using_with_place_id_and_verify_the_in_the_response
		 * ("getplaceApi", "simpu");
		 */
		
		System.out.println(" Hooks All passedvvvvvvvvvvvvvvvvvvvvvvvvvvv");
		
		
		
	}

}
