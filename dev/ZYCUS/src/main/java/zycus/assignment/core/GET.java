package zycus.assignment.core;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

public class GET {
	Client clientConnectionString = ClientBuilder.newClient();

	public Response get( String url){		
		Response getResponse=clientConnectionString.target(url).request().get();
	return getResponse;

		
		
	}

}
