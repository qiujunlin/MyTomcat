package com.mytomcat;

public class ServeletMapping {
	private String servletName;
	private String url;
	private String clazz;
	
	public ServeletMapping(String servletName, String url, String clazz) {
		super();
		this.servletName = servletName;
		this.url = url;
		this.clazz = clazz;
	}

	public String getServletName() {
		return servletName;
	}

	public void setServeletName(String servletName) {
		this.servletName = servletName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
}
