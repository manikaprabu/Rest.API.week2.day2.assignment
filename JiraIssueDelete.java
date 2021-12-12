package week2.day2.assignment;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@Test
public class JiraIssueDelete {
	public void getChangeRequest() {
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue";
		RestAssured.authentication=RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com","aZeu5Okc5H6bAteywwAd0F19");

		//File inputfile = new File("./data/CreateIncident.json");

		Response DeleteIssue = RestAssured.given().contentType(ContentType.JSON).log().all().delete("22523");
		System.err.println(DeleteIssue.statusCode());

		DeleteIssue.then().log().all();

	}
}
