package com.awasthi027.unittesting.unittesting;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import com.awasthi027.unittesting.unittesting.business.SomeBusinessImpl;
import com.awasthi027.unittesting.unittesting.data.SomeDataService;

@ExtendWith(MockitoExtension.class)
class SomeBussinesMockTest {
	
	@InjectMocks
	SomeBusinessImpl bussiness = new SomeBusinessImpl();
	
	@Mock
	SomeDataService someDataService;

	@BeforeEach
	public void before() {
		bussiness.setDataService(someDataService);
	}

	@Test
	void calculateSum_Basic() {
		when(someDataService.retriveAllData()).thenReturn(new int[] { 1, 2, 3 });
		assertEquals(6, bussiness.calculateTheSum());
	}

	@Test
	void calculateSum_EmptyList() {
		when(someDataService.retriveAllData()).thenReturn(new int[] {});
		assertEquals(0, bussiness.calculateTheSum());
	}

	@Test
	void calculateSum_OneValue() {
		when(someDataService.retriveAllData()).thenReturn(new int[] { 5 });
		assertEquals(5, bussiness.calculateTheSum());
	}

}
