package com.nirmalyalabs.voicerecognition.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nirmalyalabs.voicerecognition.Entity.ItemMaster;

@Repository
public interface ItemMasterRepository extends JpaRepository<ItemMaster, Long> {

	public List<ItemMaster> findByItemnameIgnoreCase(String itemName);

	public List<ItemMaster> findByItemAliasIgnoreCaseContaining(String itemName);
}
