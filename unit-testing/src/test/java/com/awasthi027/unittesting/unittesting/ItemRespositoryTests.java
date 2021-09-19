package com.awasthi027.unittesting.unittesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.awasthi027.unittesting.unittesting.respositories.ItemRespository;

@RunWith(SpringRunner.class)
@DataJpaTest
class ItemRespositoryTests {

	@Autowired
	private ItemRespository itemRespository;
	
	
	@Test
	void findAll() {
		assertEquals(itemRespository.findAll().size(), 3);
	}

}
