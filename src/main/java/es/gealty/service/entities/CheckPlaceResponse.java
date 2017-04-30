package es.gealty.service.entities;

import es.gealty.bean.Weather;

public class CheckPlaceResponse {

	private String result;
	private Weather weather;

	public Weather getWeather() {
		return weather;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
