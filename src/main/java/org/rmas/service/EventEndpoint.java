package org.rmas.service;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace="http://rmas.org")
public class EventEndpoint {

	@WebResult( name="response", targetNamespace="http://rmas.org/" )
	public String pushEvent( @WebParam( name="event", targetNamespace="http://rmas.org/" ) String event ) {
		return "n/a";
	}

	@WebResult( name="response", targetNamespace="http://rmas.org/" )
	public String getEvents( @WebParam( name="from", targetNamespace="http://rmas.org/" ) String when ) {
		return "n/a";
	}
	
}
