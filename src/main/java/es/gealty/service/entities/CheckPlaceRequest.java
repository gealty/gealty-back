package es.gealty.service.entities;

public class CheckPlaceRequest {
	private String seed;
	private Double lat;
	private Double lon;
	private Boolean save;

	public String getSeed() {
		return seed;
	}

	public void setSeed(String seed) {
		this.seed = seed;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public Boolean getSave() {
		return save;
	}

	public void setSave(Boolean save) {
		this.save = save;
	}

}
