package com.taf.test.framework.helpers;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;


/**
 * Every Api Step definition class should extend this class
 */

public class ApiHelper {
    private static Gson gson;

//    static {
//        RestAssured.baseURI = UrlBuilder.getBasePathURI().toString();
//    }


    protected static RequestSpecification givenConfig() {
        RestAssured.useRelaxedHTTPSValidation();

        return given().log().all().
                header("Accept-Language", "en").contentType("application/json").accept("application/json");


    }
    protected static RequestSpecification givenConfig(String tenantId,String productId) {
        RestAssured.useRelaxedHTTPSValidation();

        return given().log().all().
                header("Accept-Language", "en").contentType("application/json").accept("application/json").header("X-TENANT-ID",tenantId).header("X-PRODUCT-ID",productId);


    }
    protected static RequestSpecification givenConfigWithToken(String accessToken) {
        RestAssured.useRelaxedHTTPSValidation();
        return given().
                header("Accept-Language", "en").header("Content-Type", "application/json").header("Accept","application/json").header("Access-Token",accessToken);
    }

    //Specify all one time default Gson config
    public static Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gson(gsonBuilder);
        return gson;
    }

    //Custom Gson config to override Default Gson  configuration
    public static Gson gson(GsonBuilder gsonBuilder) {
        gson = gsonBuilder.create();
        return gson;
    }

    public static boolean checkIfKeyExists(String jsonString,String key) throws JSONException {
        boolean result = true;
        JSONArray jsonArray = new JSONArray(jsonString);
        int jsonSize = jsonArray.length();
        for(int i=0;i<jsonSize;i++){
            if(jsonArray.getJSONObject(i).has(key)){
                result =  true;
            }
            else{
                result =  false;
                break;
            }
        }
       return result;
    }

    public static HashMap<String,String> getKeyValueMap(String jsonString, List<String> keys) throws JSONException {
        HashMap<String,String> resultantMap = new HashMap<>();
        JSONObject jsonObject = new JSONObject(jsonString);
        for(String key:keys){
            resultantMap.put(key,jsonObject.getString(key));
        }
        return resultantMap;
    }

    public static String getValueForKey(String json,String path){
        JsonPath jsonPath = new JsonPath(json);
        return jsonPath.getString(path);


    }


}