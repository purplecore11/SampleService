package com.webapp.sample.properties;


public class Property {
	String propertyName;
	String propertyValue;

	public Property() {
		this.propertyName = "";
		this.propertyValue = "";
	}
	
	public Property(String propertyName, String propertyValue) {
		this.propertyName = propertyName;
		this.propertyValue = propertyValue;
	}
	
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getPropertyValue() {
		return propertyValue;
	}
	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}

	
}
