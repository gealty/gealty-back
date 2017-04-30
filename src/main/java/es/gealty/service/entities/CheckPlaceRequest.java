package es.gealty.service.entities;

public class CheckPlaceRequest {
	private String seed;
	private Double lat;
	private Double lng;
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

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Boolean getSave() {
		return save;
	}

	public void setSave(Boolean save) {
		this.save = save;
	}

}
