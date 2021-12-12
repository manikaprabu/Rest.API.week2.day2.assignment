package week2.day2.assignment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@Test
public class JiraIssueGet {
	public void getChangeRequest() {
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/search?jql=project=RS";
		RestAssured.authentication=RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com","aZeu5Okc5H6bAteywwAd0F19");
		
	//	Response response = RestAssured.given().accept(ContentType.XML).get();
		Response response = RestAssured.given().accept(ContentType.JSON).get();
		System.err.println(response.statusCode());
		//List<String> allSysId = response.xmlPath().getList("response.result.sys_id");
			List<String> allissue_id = response.jsonPath().getList("issues.id");
			System.err.println(allissue_id);
			response.prettyPrint();
	}

}
