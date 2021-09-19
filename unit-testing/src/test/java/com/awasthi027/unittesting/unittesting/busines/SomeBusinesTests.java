package com.awasthi027.unittesting.unittesting.busines;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import com.awasthi027.unittesting.unittesting.business.SomeBusinessImpl;
import com.awasthi027.unittesting.unittesting.data.SomeDataService;



class SomeBusinesTests {

	@Test
	void calculateSum_Basic() {
		SomeBusinessImpl  bussiness = new SomeBusinessImpl();
		int result = bussiness.calculateTheSum(new int [] {1,2,3});
	    int expectedResult = 6;
	    assertEquals(expectedResult, result);
	}
	
	@Test
	void calculateSum_EmtryList() {
		SomeBusinessImpl  bussiness = new SomeBusinessImpl();
		int result = bussiness.calculateTheSum(new int [] {});
	    int expectedResult = 0;
	    assertEquals(expectedResult, result);
	}
	
	@Test
	void calculateSum_OneValue() {
		SomeBusinessImpl  bussiness = new SomeBusinessImpl();
		int result = bussiness.calculateTheSum(new int [] {5});
	    int expectedResult = 5;
	    assertEquals(expectedResult, result);
	}

}
