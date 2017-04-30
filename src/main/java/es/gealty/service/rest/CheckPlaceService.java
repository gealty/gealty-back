package es.gealty.service.rest;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import es.gealty.bean.Seed;
import es.gealty.dao.SeedDAO;
import es.gealty.dao.SeedHome;
import es.gealty.service.entities.CheckPlaceRequest;
import es.gealty.service.entities.CheckPlaceResponse;

@Path("CheckPlace")
public class CheckPlaceService {

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public CheckPlaceResponse checkPlace(CheckPlaceRequest request) throws SQLException {
		CheckPlaceResponse response = new CheckPlaceResponse();
//		Seed seed = new Seed();
//		seed.setId(132);
		
//		SeedHome dao = new SeedHome();
//		dao.persist(seed);
//		SeedDAO dao  = new SeedDAO();
//		
//		dao.getBean();
		
		return response;

	}

}
