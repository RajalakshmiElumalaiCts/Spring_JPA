package com.jpa.ex.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "ConsolidationType", schema="ORD")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "code", scope = String.class)
public class ConsolidationType {
	
	private static final long serialVersionUID = 4895049681831951544L;	
	@Id
	@Column(name = "ConsolidationTypeCode")
	@Size(max = 10, message = "max_size_violation")
	private String code;
	
	@Column(name = "ConsolidationTypeDescription", nullable = false)
	@Size(max = 80, message = "max_size_violation")
	private String description;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "consolidationTypeCode")
	private List<OrderConsolidation> orderConsolidations;

}
