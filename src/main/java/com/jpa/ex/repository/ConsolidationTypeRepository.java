package com.jpa.ex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.jpa.ex.entity.ConsolidationType;

@RepositoryRestResource(path = "consolidationtypes")
public interface ConsolidationTypeRepository 
extends JpaRepository<ConsolidationType, String>{//ConsolidationType - entity of the table which will be hit by this repository
	//'String' - argument refers the data type of primary key of the entity 'ConsolidationType'
	
	//'findByCode' - 'code' is the field of 'ConsolidationType' entity, which refers the column 'ConsolidationTypeCode'
	@RestResource(path = "consolidationtypes", rel = "consolidationtypes")
	public List<String> findByCode(@Param("codes")List<String> codes);
	
	public String findByCode(String code);
}
