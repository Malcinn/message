
package com.company.message;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Example resource class hosted at the URI path "/myresource"
 * https://www.ibm.com/developerworks/library/wa-aj-tomcat/
 */
@Path("/myresource")
public class MyResource {

	/**
	 * Method processing HTTP GET requests, producing "text/plain" MIME media type.
	 * 
	 * @return String that will be send back as a response of type "text/plain".
	 */
	@GET
	@Produces("text/plain")
	public String getIt() {
		return "Hi there!";
	}
}
