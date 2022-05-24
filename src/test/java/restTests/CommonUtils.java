package restTests;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;





public class CommonUtils 
{
	/**
	 * Generic function for all GET calls
	 * @param url
	 * @param username
	 * @return Response
	 */
    public Response getCall( String url, String username)
    {
    	RestAssured.baseURI = "https://petstore.swagger.io/v2";

    	Response res= given().get(url+username).then().extract().response(); 
    	return res;
    }
    
    /**
     * Generic function for all post calls
     * @param url
     * @param username
     * @param isFileBody
     * @return
     * @throws IOException
     */
    public Response postCall(String url, String username, boolean isBodyAsJson) throws IOException {
    	RestAssured.baseURI = "https://petstore.swagger.io/v2";
    	String body="";
    	if(!isBodyAsJson) {
        body= "{\r\n"
    			+ "  \"id\": 101,\r\n"
    			+ "  \"username\": \""+username+"\",\r\n"
    			+ "  \"firstName\": \"V\",\r\n"
    			+ "  \"lastName\": \"P\",\r\n"
    			+ "  \"email\": \"dvfsd@fg.com\",\r\n"
    			+ "  \"password\": \"pass2\",\r\n"
    			+ "  \"phone\": \"03888332\",\r\n"
    			+ "  \"userStatus\": 0\r\n"
    			+ "}";
    	}
    	else {
        	FileInputStream file = new FileInputStream(new File(System.getProperty("user.dir")+"\\testdata\\data.json"));
            body = IOUtils.toString(file);
            System.out.println(body.replace("USERNAME", username));
    	}

    	Response res= given().header("content-type","application/json").body(body.replace("USERNAME", username)).
    	when().post(url).then().extract().response(); 
		return res;
    }
    
    /**
     * Generic function for all put calls
     * @param url
     * @param username
     * @param isFileBody
     * @return
     * @throws IOException
     */
    public Response putCall(String url, String username,String modifiedFirstname, boolean isBodyAsJson) throws IOException {
    	RestAssured.baseURI = "https://petstore.swagger.io/v2";
    	String body="";
    	if(!isBodyAsJson) {
        body= "{\r\n"
        		+ "  \"id\": 101,\r\n"
        		+ "  \"username\": \"USERNAME\",\r\n"
        		+ "  \"firstName\": \""+modifiedFirstname+"\",\r\n"
        		+ "  \"lastName\": \"Firstname\",\r\n"
        		+ "  \"email\": \"sample@test.com\",\r\n"
        		+ "  \"password\": \"passwrod\",\r\n"
        		+ "  \"phone\": \"0087799\",\r\n"
        		+ "  \"userStatus\": 0\r\n"
        		+ "}";
    	}
    	else {
        	FileInputStream file = new FileInputStream(new File(System.getProperty("user.dir")+"\\testdata\\data.json"));
            body = IOUtils.toString(file);
            System.out.println(body.replace("USERNAME", username));
    	}

        System.out.println(body.replace("USERNAME", username));

    	Response res= given().header("content-type","application/json").body(body.replace("USERNAME", username)).
    	when().put(url+username).then().extract().response(); 
		return res;
    }
    
    /**
     * Generic function for delete call
     * @param url
     * @param username
     * @return
     */
    public Response deleteCall( String url, String username)
    {
    	RestAssured.baseURI = "https://petstore.swagger.io/v2";

    	Response res= given().delete(url+username).then().extract().response(); 
    	return res;
    }
}

