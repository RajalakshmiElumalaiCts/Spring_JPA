package com.jpa.ex.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.jpa.ex.converter.DateAttributeConverter;
import com.jpa.ex.entity.Order;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "OrderConsolidation", schema = "ORD")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, 
property = "ordeConsolidationID", scope = OrderConsolidation.class)
public class OrderConsolidation {
	
	private static final long serialVersionUID = 4895049681831951544L;
	
	@Id
	@Column(name = "OrderConsolidationID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ordeConsolidationID;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "OrderID", nullable = false)
	@Valid
	@NotNull(message="mandatory_field")
	private List<Order> orders;  
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ConsolidationTypeCode", nullable = false)
	private String consolidationTypeCode;
	
	@Column(name = "ConsolidationRunNumber", nullable = true)
	private int consolidationRunNumber;
	
	@Column(name = "ConsolidationRequestDate", nullable = true)
	@Convert(converter = DateAttributeConverter.class)
	private LocalDate consolidationRequestDate;
	
	@OneToOne(fetch = FetchType.LAZY)
	private OrderConsolidationRoutePlan orderConsolidationRoutePlan;

}
