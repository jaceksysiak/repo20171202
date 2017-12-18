package com.caveofprogramming.service;

import org.springframework.stereotype.Service;
import com.caveofprogramming.model.StatusUpdate;
import com.caveofprogramming.model.StatusUpdateDao;

@Service
public class StatusUpdateService {
	
	private StatusUpdateDao StatusUpdateDao;
	
	public void save(StatusUpdate statusUpdate){
	    
		StatusUpdateDao.save(statusUpdate);
	}
	
	public StatusUpdate getLatest(){
		
		return StatusUpdateDao.findFirstByOrderByAddedDesc();
	}
	

}































