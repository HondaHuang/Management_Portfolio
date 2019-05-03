package com.hh.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hh.demo.model.ClientPOC;

public interface ClientPocDAO extends JpaRepository<ClientPOC, Integer>{

	@Query(value = "SELECT * FROM clientpoc c WHERE c.id NOT IN (SELECT clientpocs_id FROM project_clientpocs)", nativeQuery = true)
	public List<ClientPOC> getUnassignedClientpocs();
}
