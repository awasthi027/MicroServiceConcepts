package com.awasthi027.unittesting.unittesting;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

class JsonAssertTest {

  private String actualResp = "{\"id\":1,\"name\":\"Helment\",\"quantity\":2,\"price\":660}";
  
  @Test
  public void assertTheJSON() throws JSONException {
	  String expectedJSON =  "{\"id\":1,\"name\":\"Helment\",\"quantity\":2,\"price\":660}";
	  JSONAssert.assertEquals(expectedJSON, actualResp, true);
  }
  
  @Test
  public void matchSJONValue() throws JSONException {
	  String expectedJSON =  "{\"id\":1,\"name\":\"Helment\",\"quantity\":2,\"price\":660}";
	  JSONAssert.assertEquals(expectedJSON, actualResp, true);
  }

}
