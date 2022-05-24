package restTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class restAssuredAssignment {

	CommonUtils commonUtils = new CommonUtils();
	String userName= "SwethaTestUserE";
	String userName1= "SwethaTestUserF";


	@Test(priority =3)
	public void getUser() {		
		Response res = commonUtils.getCall("/user/", userName1);
		Assert.assertEquals(res.getStatusCode(), 200);

	}
	
	@Test(priority =1)
	 public void createUser() throws IOException
	    {
			Response res = commonUtils.postCall("/user/", userName,false);
			Assert.assertEquals(res.getStatusCode(), 200);

	    }
	@Test(priority =2)
	 public void createUserWithJsonFile() throws IOException
	    {
			Response res = commonUtils.postCall("/user/", userName1,true);
			Assert.assertEquals(res.getStatusCode(), 200);

	    }
	
	@Test(priority =4)
	 public void modifyUser() throws IOException
	    {
			Response res = commonUtils.putCall("/user/", userName,"newFirstname1",false);
			Assert.assertEquals(res.getStatusCode(), 200);

	    }

	@Test(priority =5)
	 public void modifyUserWithJsonFile() throws IOException
	    {
			Response res = commonUtils.putCall("/user/", userName1,"newFirstname2",true);
			Assert.assertEquals(res.getStatusCode(), 200);

	    }
	

	@Test(priority =6)
	 public void deleteUser() throws IOException
	    {
			Response res = commonUtils.deleteCall("/user/", userName1);
			Assert.assertEquals(res.getStatusCode(), 200);
			
	    }
	@Test(priority =7)
	public void getNonExistingUser() {		
		Response res = commonUtils.getCall("/user/", "NonExistingUser");
		Assert.assertEquals(res.getStatusCode(), 404);

	}
	
	@Test(priority =8)
	public void modifyUserWrongRequest() throws IOException {		
		Response res = commonUtils.putCall("/users/", "Testuser11","newFirstname2",true);
		Assert.assertEquals(res.getStatusCode(), 404);
	}
	
	@Test(priority =9)
	 public void createUserWrongRequest() throws IOException
	    {
			Response res = commonUtils.postCall("/users/", "Testuser12",true);
			Assert.assertEquals(res.getStatusCode(), 404);

	    }  
	@Test(priority =10)
	 public void deleteUserWrongRequest() throws IOException
	    {
			Response res = commonUtils.deleteCall("/user/", "Testuser13");
			Assert.assertEquals(res.getStatusCode(), 404);
	    }
}
