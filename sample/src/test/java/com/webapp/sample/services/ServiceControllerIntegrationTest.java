package com.webapp.sample.services;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;



@RunWith(SpringRunner.class)
@WebMvcTest(ServicesController.class)
public class ServiceControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    /**
     * Validates the response status given by GET method /property with no params
     * @throws Exception
     */
    @Test
    public void getPropertyNoNameTest()
      throws Exception 
    {
    	mvc.perform(MockMvcRequestBuilders
    	  .get("/property")
          .accept(MediaType.APPLICATION_JSON))
          .andExpect(status().isNotFound());
    }
    
    /**
     * Validates the response status given by GET method /property with a valid name
     * and value set to true
     * @throws Exception
     */
    @Test
    public void getPropertyValidNameTest()
      throws Exception 
    {
        System.setProperty("prop", "true");

        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
    	requestParams.add("name", "prop");
    	
    	mvc.perform(MockMvcRequestBuilders
    	  .get("/property")
    	  .params(requestParams)
          .accept(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk());
    	
        System.clearProperty("prop");
    }
    
    /**
     * Validates the response status given by GET method /property with a valid name
     * and value set different to true
     * @throws Exception
     */
    @Test
    public void getPropertyValidNameNotTrueTest()
      throws Exception 
    {
        System.setProperty("prop", "xxx");

        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
    	requestParams.add("name", "prop");
    	
    	mvc.perform(MockMvcRequestBuilders
    	  .get("/property")
    	  .params(requestParams)
          .accept(MediaType.APPLICATION_JSON))
          .andExpect(status().isNotFound());
    	
        System.clearProperty("prop");
    }
    
    /**
     * Validates the response status given by GET method /property with an invalid name
     * @throws Exception
     */
    @Test
    public void getPropertyInvalidNameTest()
      throws Exception 
    {
        LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
    	requestParams.add("name", "prop");
    	
    	mvc.perform(MockMvcRequestBuilders
    	  .get("/property")
    	  .params(requestParams)
          .accept(MediaType.APPLICATION_JSON))
          .andExpect(status().isNotFound());
    }
    
    /**
     * Validates the response status given by POST method /property 
     * @throws Exception
     */
    @Test
    public void setPropertyTest()
      throws Exception 
    {
    	JSONObject json = new JSONObject();
    	json.put("propertyName","prop");
    	json.put("propertyValue","true");

    	mvc.perform(MockMvcRequestBuilders
    			.post("/property")
  	      		.content(json.toString())
    			.contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
