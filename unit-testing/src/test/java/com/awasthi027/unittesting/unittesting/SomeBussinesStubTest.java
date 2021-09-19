package com.awasthi027.unittesting.unittesting;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import com.awasthi027.unittesting.unittesting.business.SomeBusinessImpl;
import com.awasthi027.unittesting.unittesting.data.SomeDataService;

class SomeDataServiceStub implements SomeDataService {

	@Override
	public int[] retriveAllData() {
		return new int [] {1,2,3};
	}
	
}
class SomeDataServiceStubEmpty implements SomeDataService {

	@Override
	public int[] retriveAllData() {
		return new int [] {};
	}
	
}
class SomeDataServiceStubOne implements SomeDataService {

	@Override
	public int[] retriveAllData() {
		return new int [] {5};
	}
	
}
class SomeBussinesStubTest {

	@Test
	void calculateSum_Basic() {
		SomeBusinessImpl  bussiness = new SomeBusinessImpl();
		bussiness.setDataService(new SomeDataServiceStub());
		int result = bussiness.calculateTheSum();
	    int expectedResult = 6;
	    assertEquals(expectedResult, result);
	}
	
	@Test
	void calculateSum_EmptyList() {
		SomeBusinessImpl  bussiness = new SomeBusinessImpl();
		bussiness.setDataService(new SomeDataServiceStubEmpty());
		int result = bussiness.calculateTheSum();
	    int expectedResult = 0;
	    assertEquals(expectedResult, result);
	}
	
	@Test
	void calculateSum_OneValue() {
		SomeBusinessImpl  bussiness = new SomeBusinessImpl();
		bussiness.setDataService(new SomeDataServiceStubOne());
		int result = bussiness.calculateTheSum();
	    int expectedResult = 5;
	    assertEquals(expectedResult, result);
	}


}
