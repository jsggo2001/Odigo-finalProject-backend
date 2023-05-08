package com.ssafy.trip.model.dto;

import java.math.BigDecimal;

public class Spot {
	private String content_id;
	private String title;
	private String content_type_id;
	private String sido_code;
	private String gugun_code;
	private BigDecimal latitude;
	private BigDecimal longitude;
	private String first_image;
	private String addr1;
	
	public Spot(String content_id, String title, String content_type_id, String sido_code, String gugun_code,
			BigDecimal latitude, BigDecimal longitude, String first_image, String addr1) {
		super();
		this.content_id = content_id;
		this.title = title;
		this.content_type_id = content_type_id;
		this.sido_code = sido_code;
		this.gugun_code = gugun_code;
		this.latitude = latitude;
		this.longitude = longitude;
		this.first_image = first_image;
		this.addr1 = addr1;
	}
	
	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getFirst_image() {
		return first_image;
	}
	public void setFirst_image(String first_image) {
		this.first_image = first_image;
	}
	public String getContent_id() {
		return content_id;
	}
	public void setContent_id(String content_id) {
		this.content_id = content_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent_type_id() {
		return content_type_id;
	}
	public void setContent_type_id(String content_type_id) {
		this.content_type_id = content_type_id;
	}
	public String getSido_code() {
		return sido_code;
	}
	public void setSido_code(String sido_code) {
		this.sido_code = sido_code;
	}
	public String getGugun_code() {
		return gugun_code;
	}
	public void setGugun_code(String gugun_code) {
		this.gugun_code = gugun_code;
	}
	public BigDecimal getLatitude() {
		return latitude;
	}
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
	public BigDecimal getLongitude() {
		return longitude;
	}
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	@Override
	public String toString() {
		return "Spot [content_id=" + content_id + ", title=" + title + ", content_type_id=" + content_type_id
				+ ", sido_code=" + sido_code + ", gugun_code=" + gugun_code + ", latitude=" + latitude + ", longitude="
				+ longitude + ", first_image=" + first_image + "]";
	}
}
