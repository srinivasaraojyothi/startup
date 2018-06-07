package zycus.assignment.core;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

public class POST {
	Client clientConnectionString = ClientBuilder.newClient();
	public Response post(String url,Entity<String> PayLoad){
		Response postResponse=clientConnectionString.target(url).request().post(PayLoad);
		return postResponse;
	}

}
