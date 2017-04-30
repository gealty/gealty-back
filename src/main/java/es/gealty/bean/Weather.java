package es.gealty.bean;

import org.json.JSONObject;

public class Weather {

	private double lat;
	private double lon;
	private double tempMin;
	private double tempMax;
	private double humidity;
	private double windSpeed;

	public Weather(JSONObject json) {
		if (json != null) {
			try {
				this.lon = json.getJSONObject("coord").getDouble("lon");
				this.lat = json.getJSONObject("coord").getDouble("lat");
				// parse to celsius
				this.tempMax = json.getJSONObject("main").getDouble("temp_max") - 273.15;
				this.tempMin = json.getJSONObject("main").getDouble("temp_min") - 273.15;
				this.humidity = json.getJSONObject("main").getDouble("humidity");
				this.windSpeed = json.getJSONObject("wind").getDouble("speed");
			} catch (Exception e) {
				System.out.println("Weather not found");
			}
		}

	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public double getTempMin() {
		return tempMin;
	}

	public void setTempMin(double tempMin) {
		this.tempMin = tempMin;
	}

	public double getTempMax() {
		return tempMax;
	}

	public void setTempMax(double tempMax) {
		this.tempMax = tempMax;
	}

	public double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}

}
