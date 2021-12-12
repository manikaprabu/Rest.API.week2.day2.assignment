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
public class JiraIssueCreate {
	public void getChangeRequest() {
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue";
		RestAssured.authentication=RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com","aZeu5Okc5H6bAteywwAd0F19");
		
		File inputfile = new File("./data/PostIssue.json");
		
		Response Create_JiraIssue = RestAssured.given().contentType(ContentType.JSON).log().all().body(inputfile).post();
		System.err.println(Create_JiraIssue.statusCode());
	//	Create_JiraIssue.prettyPrint();
		Create_JiraIssue.then().log().all();
		String issue_id = Create_JiraIssue.jsonPath().get("issues.id");
		System.out.println(issue_id);
	}
}
