package com.awasthi027.unittesting.unittesting.controllers;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.awasthi027.unittesting.unittesting.models.ItemInfo;
import com.awasthi027.unittesting.unittesting.services.ItemBussinesService;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
class ItemControllerTests {

	@MockBean
	private ItemBussinesService itemBussinesService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void helloworld_basic() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/dummy-item");
				;
		 mockMvc.perform(requestBuilder)
				.andExpect(status().isOk()).andExpect(content().json("{\"id\":1,\"name\":\"Helment\",\"quantity\":2,\"price\":660}"))
				.andReturn();

	}
	
	
    @Test
    public void jsonValidation_bussiness_layer()  throws Exception {
    	
    	when(itemBussinesService.retriveHardCodedItem()).thenReturn(new ItemInfo(1,"Helment", 5, 330));
    	
    	RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/item-bussines-layer");
		;
         mockMvc.perform(requestBuilder)
		.andExpect(status().isOk()).andExpect(content().json("{\"id\":1,\"name\":\"Helment\",\"quantity\":5,\"price\":330}"))
		.andReturn();
    	
    }
    

    @Test
    public void validateAllItemsBasic()  throws Exception {
    	
    	List<ItemInfo > dummyList = Arrays.asList(new ItemInfo(1,"Helment", 5, 330),
    			new ItemInfo(2,"Helment2", 5, 330));
    	
    	when(itemBussinesService.retriveItems()).
    	thenReturn(dummyList);
    	
    	RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/item-bussines-layer");
		;
         mockMvc.perform(requestBuilder)
		.andExpect(status().isOk()).andExpect(content().json("[{id:1, name: Helment, quantity: 5, price: 330}, {id:2, name: Helment2, quantity: 5, price: 330}]"))
		.andReturn();
    	
    }
    

}
