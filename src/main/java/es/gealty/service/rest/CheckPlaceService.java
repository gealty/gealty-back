package es.gealty.service.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import es.gealty.service.entities.CheckPlaceRequest;
import es.gealty.service.entities.CheckPlaceResponse;

@Path("CheckPlace")
public class CheckPlaceService {

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public CheckPlaceResponse checkPlace(CheckPlaceRequest request) {
		CheckPlaceResponse response = new CheckPlaceResponse();

		return response;

	}

}
