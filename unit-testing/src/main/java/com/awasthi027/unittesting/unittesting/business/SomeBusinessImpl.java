package com.awasthi027.unittesting.unittesting.business;

import com.awasthi027.unittesting.unittesting.data.SomeDataService;

public class SomeBusinessImpl {

	public SomeDataService dataService;
	

	public void setDataService(SomeDataService dataService) {
		this.dataService = dataService;
	}

	public int calculateTheSum(int [] data) {
		int sum = 0;
		for( int item: data) {
			sum += item;
		}
		
		return sum;
	}
	
	
	public int calculateTheSum() {
		int sum = 0;
		int [] data = dataService.retriveAllData();
		for( int item: data) {
			sum += item;
		}
		
		return sum;
	}

	

}
