package com.webapp.sample.services;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.sample.properties.Property;

@RestController
public class ServicesController {

	/**
	 * Gets the value of the System Property identified by name
	 * @param 
	 * 	name property name
	 * @return 
	 * 	200 if property value is true 
	 * 	404 otherwise
	 */
	@RequestMapping ("/property")
 	void getProperty(@RequestParam(required = false) String name,
			HttpServletResponse response) 
	{
		boolean propertyValue = false;
		
		if(name != null) {
			String value = System.getProperty(name);
			
			if(value != null && value.equals("true"))
			{
				propertyValue = true;
			}
		}
		
		response.setStatus(
				propertyValue ? HttpServletResponse.SC_OK :
					HttpServletResponse.SC_NOT_FOUND);
	}
	
	/**
	 * Sets a system property
	 * @param 
	 * 	property A JSON representation of a Property object
	 */
	@RequestMapping(method=RequestMethod.POST, value="/property")
 	void setProperty(@RequestBody Property property) 
	{
		System.setProperty(property.getPropertyName(), property.getPropertyValue());
	}
	
	
	/**
	 * Default mapping
	 * @param response
	 */
	@RequestMapping("")
	void init(HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_OK);
	}
}
