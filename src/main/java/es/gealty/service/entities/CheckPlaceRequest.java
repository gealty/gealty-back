package es.gealty.service.entities;

public class CheckPlaceRequest {
	private String seed;
	private String lat;
	private String lon;
	private boolean save;

	public boolean isSave() {
		return save;
	}

	public void setSave(boolean save) {
		this.save = save;
	}

	public String getSeed() {
		return seed;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public void setSeed(String seed) {
		this.seed = seed;
	}

}
