package es.gealty.service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import es.gealty.service.rest.CheckPlaceService;

@ApplicationPath("/services")
public class RestApplication extends Application {

	private Set<Object> services;

	public RestApplication() {
		services = new HashSet<Object>();
		services.add(new CheckPlaceService());
	}

	@Override
	public Set<Object> getSingletons() {
		return services;
	}
}
