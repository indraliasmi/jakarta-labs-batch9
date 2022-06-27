package qaautomation.tugas4;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Tugas5 {
	@Test
	public void testRegisterAPI() {
		Faker faker = new Faker();
		String username = faker.name().firstName();
		String password = "idamanwanita";
		String email = faker.internet().emailAddress();
		String phone = faker.phoneNumber().cellPhone();
		RestAssured.baseURI = "https://kolakproject.herokuapp.com";
		String registerPayLoad = String.format("{\"username\": \"%s\", \"password\":\"%s\", \"email\":\"%s\", \"phonenumber\":\"%s\"}", username, password, email, phone);
		//System.out.println(registerPayLoad);
		Response response = RestAssured.given().contentType("application/json").body(registerPayLoad).when().post("/register");
		int statusCode = response.getStatusCode();
		assertEquals(201, statusCode);
		String status = response.jsonPath().get("Status");
		System.out.println(status);
		Assert.assertEquals(status, "Created");
		String msg = response.jsonPath().get("Message");
		System.out.println(msg);
		Assert.assertEquals(msg, "New User Registered");
	}

}
