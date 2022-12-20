package com.nirmalyalabs.voicerecognition.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nirmalyalabs.voicerecognition.Entity.ops;

public interface opsRepository extends JpaRepository<ops, Long> {
	
	public List<ops> findByOrderItemsIdentityOrderId(long orderId);
}
