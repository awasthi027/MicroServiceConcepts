package com.awasthi027.unittesting.unittesting;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;

import java.util.List;

import org.junit.jupiter.api.Test;

class ListOfMock {
	List <String> mock = mock(List.class);
	
	@Test
	void size_basic() {
		
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}
	
	@Test
	void size_returndefferntvalue() {
	
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}

	@Test
	void size_returnValue() {
		
		when(mock.get(0)).thenReturn("Ashish");
		assertEquals("Ashish", mock.get(0));
		assertEquals(null, mock.get(1));
	}
	
	@Test
	void size_genericParams() {
	
		when(mock.get(anyInt())).thenReturn("Ashish");
		assertEquals("Ashish", mock.get(0));
		assertEquals("Ashish", mock.get(1));
	}
    
	@Test
	 void verifyBasicMethods() {
		String value = mock.get(0);
		verify(mock).get(0);
		verify(mock).get(anyInt());
	}
	

}
