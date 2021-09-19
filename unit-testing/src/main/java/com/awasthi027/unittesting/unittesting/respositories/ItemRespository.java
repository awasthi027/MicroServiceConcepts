package com.awasthi027.unittesting.unittesting.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.awasthi027.unittesting.unittesting.models.ItemInfo;

@Repository
public interface ItemRespository extends JpaRepository<ItemInfo, Integer>{
      public List<ItemInfo> findAll();
}
