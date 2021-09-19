package com.awasthi027.unittesting.unittesting.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.awasthi027.unittesting.unittesting.models.ItemInfo;
import com.awasthi027.unittesting.unittesting.respositories.ItemRespository;

@Component
public class ItemBussinesService {
	
	@Autowired
	private ItemRespository itemRespository;
	
	public ItemInfo retriveHardCodedItem() {
		return new ItemInfo(1,"Helment", 5, 330);
	}
	public List<ItemInfo> retriveItems() {
		return itemRespository.findAll();
	}

}
