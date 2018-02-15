package com.caveofprogramming.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caveofprogramming.model.dto.SearchResult;
import com.caveofprogramming.model.entity.Profile;
import com.caveofprogramming.model.repository.ProfileDao;

@Service
public class SearchService {
	
	@Autowired
	private ProfileDao profileDao;
	
	public List<SearchResult> search(String text){
		
		return profileDao.findByInterestsName(text).stream().map(SearchResult::new).collect(Collectors.toList());
	}

}
































































