package org.rmas.service;

import org.apache.camel.builder.RouteBuilder;

public class EventRoutes extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("cxf:bean:incoming")
		.setHeader("who").groovy("headers.CamelAuthentication.getPrincipals().toArray()[0].name")
		.log("in here with ${headers.who}")
		.choice()
			.when(header("operationName").isEqualTo("pushEvent"))
				.choice()
					.when(header("who").isEqualTo("joe"))
						.transform().constant("joe pushed").to("mock:nuts")
					.otherwise()
						.transform().groovy("'not joe -- ' + headers.who + ' pushed'").to("mock:nuts")
					.endChoice()
			.otherwise()
				.transform().constant("soemthing else").to("mock:balls");

		
	}

}
