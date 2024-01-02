package com.Liveasy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Liveasy.Entity.loadsEntity;

@Repository
public interface loadsRepo extends JpaRepository<loadsEntity, Long> {
	
	//custom query method so can find by string id instead long
	loadsEntity findByShipperId(String shipperId);
}
