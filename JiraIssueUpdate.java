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
public class JiraIssueUpdate {
	public void getChangeRequest() {
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue/";
		RestAssured.authentication=RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com","aZeu5Okc5H6bAteywwAd0F19");
		
		
		File inputfile = new File("./data/UpdateIssue.json");
		Response UpdateIssue = RestAssured.given().contentType(ContentType.JSON).log().all().body(inputfile).put("22524");
		System.err.println(UpdateIssue.statusCode());
	//	Create_changerequest.prettyPrint();
		UpdateIssue.then().log().all();
//		String issue_id = UpdateIssue.jsonPath().get("issues.id");
//		System.out.println(issue_id);
	}

}
