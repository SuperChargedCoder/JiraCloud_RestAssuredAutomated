package com.JIRA_Cloud;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.io.File;

import org.testng.annotations.Test;

import com.util.Payload;

import static io.restassured.RestAssured.*;

public class IssueCreationAPI {

	String basicAuthKey = "Basic <NeedToBeCreated>";
	String filePath = System.getProperty("user.dir") + "\\RestAPIHandling.jpg";
	String issueId;

	@Test(priority = 1)
	public void CreateIssue() {

		RestAssured.baseURI = "https://<JIRA_UserId>.atlassian.net/";

		String createIssueResponse = given().header("Content-Type", "application/json")
				.header("Authorization", basicAuthKey).body(Payload.CreateBug()).log().all().post("rest/api/3/issue")
				.then().log().all().assertThat().statusCode(201).contentType("application/json").extract().response()
				.asString();

		JsonPath js = new JsonPath(createIssueResponse);
		issueId = js.getString("id");
		System.out.println("Issue ID: " + issueId);

	}

	@Test(priority = 2, dependsOnMethods = { "CreateIssue" })
	public void AddAttachmentToIssue() {
		RestAssured.baseURI = "https://<JIRA_UserId>.atlassian.net/";
		given().pathParam("key", issueId).header("X-Atlassian-Token", "no-check").header("Authorization", basicAuthKey)
				.multiPart("file", new File(filePath)).log().all().post("rest/api/3/issue/{key}/attachments").then()
				.log().all().assertThat().statusCode(200);
	}
}
