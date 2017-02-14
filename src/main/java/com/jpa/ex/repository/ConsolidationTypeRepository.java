package com.jpa.ex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "consolidationtypes")
public interface ConsolidationTypeRepository extends JpaRepository<String, Integer>{
	
	@RestResource(path = "consolidationtypes", rel = "consolidationtypes")
	public List<String> findByConsolidationTypeCode(@Param("codes")List<String> codes);
	
	public String findByConsolidationTypeCode(String code);
}
