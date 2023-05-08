package com.ssafy.trip.model.dto;

public class PageInfo {
	private boolean forwarCheck;
	private String uri;
	
	public PageInfo(boolean forwarCheck, String uri) {
		super();
		this.forwarCheck = forwarCheck;
		this.uri = uri;
	}
	
	public PageInfo(String uri) {
		this(true, uri);
	}
	
	public boolean isForwarCheck() {
		return forwarCheck;
	}
	public void setForwarCheck(boolean forwarCheck) {
		this.forwarCheck = forwarCheck;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	
}
