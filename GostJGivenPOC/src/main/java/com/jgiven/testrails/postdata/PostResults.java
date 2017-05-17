package com.jgiven.testrails.postdata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class PostResults {

	public static String ConvertResults(String resultsfilepath,JsonArray testsarray) throws Exception{
		Gson gson = new Gson();
		BufferedReader br = new BufferedReader(new FileReader(resultsfilepath));
		TestResults models = gson.fromJson(br, TestResults.class);
		TestRailResults railresults = new TestRailResults();
		List<TestRailResult> trailresults = new LinkedList<TestRailResult>();
		
		for(Scenario scenario:models.getScenarios()){
			TestRailResult railresult = new TestRailResult();
			//railresult.setElapsed(String.valueOf(scenario.getDurationInNanos()));
			railresult.setComment("Class Name:"+scenario.getClassName()+"Method Name:"+scenario.getTestMethodName());
			if(scenario.getScenarioCases().get(0).getSuccess() == true)
				railresult.setStatusId(1);
			else
				railresult.setStatusId(5);
		List<CustomStepResult> listtrstepresults = new LinkedList<CustomStepResult>();
		int i=0;
		railresult.setTestid(testsarray.get(i).getAsJsonObject().get("id").getAsInt());		
		for(ScenarioCase cases:scenario.getScenarioCases()){
			CustomStepResult trstepresults= new CustomStepResult();			
			for(Step stepresult :cases.getSteps()){
				trstepresults.setContent(stepresult.getName());
				if(stepresult.getStatus().trim().equalsIgnoreCase("PASSED")) {
				trstepresults.setStatusId(1);
				}else{
					trstepresults.setStatusId(5);
				}
			}
			i++;
			listtrstepresults.add(trstepresults);
		}
		railresult.setCustomStepResults(listtrstepresults);
		trailresults.add(railresult);
		}
		
		railresults.setResults(trailresults);
		String response = gson.toJson(railresults);
		return response;
	}
	
	public static void main(String[] args) throws Exception{
		String response = addRun(2);
		JsonObject responsedata = new JsonParser().parse(response).getAsJsonObject();
		System.out.println(responsedata);
		int id=responsedata.get("id").getAsInt();
		String runresponse =getTestForRun(id);
		JsonArray responseArrayData = new JsonParser().parse(runresponse).getAsJsonArray();
		String results = addResults(1,id,responseArrayData);
		System.out.println(results);
	}
	
	public static String addRun(int projectId)throws Exception{
		HashMap< String, Object> JsonMap = new HashMap<String, Object>();
		JsonMap.put("suite_id", 2);
		JsonMap.put("name", new Date());
		JsonMap.put("assignedto_id", 1);
		JsonMap.put("include_all", true);
		String url="https://mytestrunner.testrail.net/index.php?/api/v2/add_run/"+projectId;
		Gson gsonObj = new Gson();
		String jsonStr = gsonObj.toJson(JsonMap);
		String response =HttpClientUtility.ExecutePost(url, jsonStr);
		return response;
	}
	
	public static String addResults(int projectId,int runid,JsonArray test_ids)throws Exception{
		String results= ConvertResults("./target/jgiven-reports/json/com.jgiven.gost.tests.LoginRegisterTest.json",test_ids);
		System.out.println(results);
		String url ="https://mytestrunner.testrail.net/index.php?/api/v2/add_results/"+runid;
		String response =HttpClientUtility.ExecutePost(url, results);
		return response;
	}
	//index.php?/api/v2/get_run/:
	public static String getRun(int runid)throws Exception{
		String url="https://mytestrunner.testrail.net/index.php?/api/v2/get_run/"+runid;
		String responsedata =HttpClientUtility.executeGet(url);
		return responsedata;
	}
	public static String getTestForRun(int runid)throws Exception{
		String url="https://mytestrunner.testrail.net/index.php?/api/v2/get_tests/"+runid;
		String responsedata =HttpClientUtility.executeGet(url);
		return responsedata;
	}



}
