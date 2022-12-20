package com.nirmalyalabs.voicerecognition.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nirmalyalabs.voicerecognition.Entity.Ordermaster;

public interface OrderMasterRepository extends JpaRepository<Ordermaster, Long> {
 
	public List<Ordermaster> findByCustid(long custid);
	public List<Ordermaster> findByOrderId(long orderId);
}
