package com.webapp.sample.properties;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PropertyTest {
    /**
     * Validates the empty constructor and set methods
     */
	@Test
	public void emptyConstructorTest() {
		Property property = new Property();
		
		property.setPropertyName("name");
		property.setPropertyValue("value");
		
		assertTrue(property.getPropertyName().equals("name") && 
				property.getPropertyValue().equals("value"));
	}
	
    /**
     * Validates the constructor with parameters
     */
	@Test
	public void constructorTest() {
		Property property = new Property("name", "value");
		
		assertTrue(property.getPropertyName().equals("name") && 
				property.getPropertyValue().equals("value"));
	}
	
}
