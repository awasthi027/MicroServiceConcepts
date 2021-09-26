package com.ashi.learning;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class Reader implements ItemReader<String> {

	private String [] courses = {"Java web services", "End to End Project", "Angular"};
	private int count = 0;
	
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		System.out.println("Insider read method =============");
		if (count < courses.length) {
			return courses[count++];
		}else {
			count = 0;
		}
		return null;
	}

}