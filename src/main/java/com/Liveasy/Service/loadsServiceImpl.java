package com.Liveasy.Service;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.Liveasy.Entity.loadsEntity;
import com.Liveasy.Repository.loadsRepo;

@Service
public class loadsServiceImpl implements loadsService {
	
	@Autowired
	private loadsRepo repoLoad;
	
	@Override
	public void saveLoad(loadsEntity entityLoad) {
        try {        
            String randomShipperIdString = UUID.randomUUID().toString();
            entityLoad.setShipperId(randomShipperIdString);       
            repoLoad.save(entityLoad);        
           // System.out.println("Your gen. shipper id is : " + randomShipperIdString);
        } 
        catch (Exception e) {
        	e.printStackTrace();
            //System.out.println("Failed to add load why?==>: " + e.getMessage());
            throw new RuntimeException("Failed to add load", e);
        }
    }

	
	//Fetching data
	@Override
	public List<loadsEntity> getAllData() {		
		return (List<loadsEntity>) repoLoad.findAll();
	}

	//fetch data using Id
	@Override
	public loadsEntity getLoadById(String shipperId) {	
		return repoLoad.findByShipperId(shipperId);
	}

	//update data 
	@Override
	public void updateLoad(String shipperId, loadsEntity entityLoad) {
		entityLoad.setShipperId(shipperId);
		repoLoad.save(entityLoad);
		
	}

	//Delete Data
	@Override
	public void deleteLoad(String shipperId) {
		loadsEntity deletePayload = repoLoad.findByShipperId(shipperId);
		repoLoad.delete(deletePayload);
		
	}
	
	

	
	

}
