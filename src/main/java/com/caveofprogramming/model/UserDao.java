package com.caveofprogramming.model;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserDao extends CrudRepository<SiteUser, Long>{

	SiteUser findByEmail(String email);
}
