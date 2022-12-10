package stepDeffile;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CRUDOperation_StepDefs {

	Response response;
	RequestSpecification request;
	
	@Given("The base URI is {string}")
	public void the_base_URI_is(String URI) {
	    // Write code here that turns the phrase above into concrete actions
	    request= RestAssured.given().baseUri(URI);
	    
	}

	@When("I perform the Get Operation")
	public void i_perform_the_Get_Operation() {
	    // Write code here that turns the phrase above into concrete actions
	    response=request.get();
	}

	@Then("Response code should be {int}")
	public void response_code_should_be(int expResponseCode) {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals(expResponseCode, response.statusCode());
	   
	    }

	@When("I perform the POST operation giving the Name as {string} and Salary as {string}")
	public void i_perform_the_POST_operation_giving_the_Name_as_and_Salary_as(String Name, String Salary) {
	    // Write code here that turns the phrase above into concrete actions
		Map<String,Object> mapObj = new HashMap<String,Object> ();
		mapObj.put("name", Name);
		mapObj.put("salary", Salary);
		response=request.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(mapObj)
				.when().post("/create");
	 
	}
	@When("I perform the PUT operation giving the Name as {string} and Salary as {string}")
	public void i_perform_the_PUT_operation_giving_the_Name_as_and_Salary_as(String Name, String Salary) {
	    // Write code here that turns the phrase above into concrete actions
		Map<String,Object> mapObj = new HashMap<String,Object> ();
		mapObj.put("name", Name);
		mapObj.put("salary", Salary);
		response=request.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(mapObj).when().put("/1");
	}
	
	@When("I perform the DELETE operation")
	public void i_perform_the_DELETE_operation() {
	    // Write code here that turns the phrase above into concrete actions
		response=request.contentType(ContentType.JSON)
				.accept(ContentType.JSON).when().delete("/23");
	}

	
}
