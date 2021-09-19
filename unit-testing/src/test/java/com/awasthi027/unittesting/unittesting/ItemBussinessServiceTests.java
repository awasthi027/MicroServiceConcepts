package com.awasthi027.unittesting.unittesting;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.awasthi027.unittesting.unittesting.models.ItemInfo;
import com.awasthi027.unittesting.unittesting.respositories.ItemRespository;
import com.awasthi027.unittesting.unittesting.services.ItemBussinesService;

@RunWith(MockitoJUnitRunner.class)

class ItemBussinessServiceTests {

	@InjectMocks
	private ItemBussinesService itemBussinesService;
	
	@MockBean
	private ItemRespository itemRespository;
	
	@Test
	public void calculateSumUsingDatabaseBasic() {
		
		List<ItemInfo > dummyList = Arrays.asList(new ItemInfo(1,"Helment", 5, 330),
    			new ItemInfo(2,"Helment2", 5, 330));
		
		when(itemRespository.findAll()).thenReturn(dummyList);
		
		List<ItemInfo> items = itemBussinesService.retriveItems();
		
		assertEquals(items.get(0).getValue(), 1650);
	}

}
