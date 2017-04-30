package es.gealty.service.rest;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import es.gealty.bean.Weather;
import es.gealty.service.entities.CheckPlaceRequest;
import es.gealty.service.entities.CheckPlaceResponse;
import es.gealty.trade.WeatherTrade;

@Path("CheckPlace")
public class CheckPlaceService {

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public CheckPlaceResponse checkPlace(CheckPlaceRequest request) throws SQLException {
		CheckPlaceResponse response = new CheckPlaceResponse();
		
		WeatherTrade weatherTrade = new WeatherTrade();
		
		Weather weather = weatherTrade.getCurrentWeather(request.getLng(), request.getLat());
		
		response.setWeather(weather);
		
		if(weather != null){
			response.setResult("OK");
		}
		
		return response;

	}

}
