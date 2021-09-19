package com.awasthi027.unittesting.unittesting.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awasthi027.unittesting.unittesting.models.ItemInfo;
import com.awasthi027.unittesting.unittesting.services.ItemBussinesService;


@RestController
public class ItemController {
	
	@Autowired
	private ItemBussinesService itemBussinesService;
	
	@GetMapping(path = "/dummy-item")
	public ItemInfo dummayItem() {
		return new ItemInfo(1,"Helment", 2, 660);
	}

	@GetMapping(path = "/item-bussines-layer")
	public List<ItemInfo> itemfromBussinesLayer() {
		List<ItemInfo> list = itemBussinesService.retriveItems();
		for(ItemInfo itemInfo: list) {
			itemInfo.setValue( itemInfo.getPrice() * itemInfo.getQuantity());
		}
		return list;
	}
	
}
