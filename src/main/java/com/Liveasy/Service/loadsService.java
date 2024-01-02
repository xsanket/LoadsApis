package com.Liveasy.Service;
import java.util.List;
import com.Liveasy.Entity.loadsEntity;

public interface loadsService {
	
	//save the data into database
	public void saveLoad(loadsEntity entityLoad); 
	
	//Fetching the data in list object
	public List<loadsEntity> getAllData();

	//Fetching specific data using id
	public loadsEntity getLoadById(String shipperId);

	//Updating load using id
	public void updateLoad(String shipperId , loadsEntity entityLoad);
	
	//Deleting Load using Id
	public void deleteLoad(String shipperId);

}
