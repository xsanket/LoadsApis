package com.Liveasy.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.Liveasy.Entity.loadsEntity;
import com.Liveasy.Response.apiResponse;
import com.Liveasy.Service.loadsService;
import java.util.List;
import jakarta.validation.Valid;


@RestController
public class loadsController {
	
	@Autowired
	private loadsService serviceLoad;
	
	//1. post "/load"
	@PostMapping("/load")
	public ResponseEntity<apiResponse> addLoad(@Valid @RequestBody loadsEntity entityLoad) {
		try {
			this.serviceLoad.saveLoad(entityLoad);
			return new ResponseEntity<apiResponse>(new apiResponse("loads details added successfully "), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<apiResponse>(new apiResponse("failed to add loads details"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	  //2. GET “/load”
	@GetMapping("/load")
	public ResponseEntity<List<loadsEntity>> getLoad(){
		try{
			return ResponseEntity.status(HttpStatus.OK).body(serviceLoad.getAllData());
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//GET “load/{loadId}” using ShipperId
	@GetMapping("/load/{loadId}")
	public ResponseEntity<loadsEntity> getLoadById(@PathVariable ("loadId") String ShipperId ){
		try{
			return ResponseEntity.status(HttpStatus.OK).body(serviceLoad.getLoadById(ShipperId));
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping("load/{loadId}")
	public ResponseEntity<apiResponse> updateLoad(@Valid @PathVariable("loadId") String shipperId,
			@RequestBody loadsEntity entityLoad) {

		try {
			if (serviceLoad.getLoadById(shipperId) == null) {
				return new ResponseEntity<apiResponse>(new apiResponse("Invalid shipperId"), HttpStatus.NOT_FOUND);
			}
			this.serviceLoad.updateLoad(shipperId, entityLoad);
			return new ResponseEntity<>(new apiResponse("Updated Successfully"), HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<apiResponse>(new apiResponse("failed to update"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@DeleteMapping("load/{loadId}")
	public ResponseEntity<apiResponse> deleteLoad(@PathVariable("loadId") String shipperId) {
		try {
			this.serviceLoad.deleteLoad(shipperId);
			return new ResponseEntity<>(new apiResponse("Deleted Successfully "), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new apiResponse("Invalid Shepper Id or Load with this Id doese't exist"),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	


}
