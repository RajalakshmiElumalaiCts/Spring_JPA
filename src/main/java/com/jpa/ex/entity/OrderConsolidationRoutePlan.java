package com.jpa.ex.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "OrderConsolidationRoutePlan", schema = "ORD")
public class OrderConsolidationRoutePlan {
	
	private static final long serialVersionUID = -3043681668101600177L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderConsolidationRoutePlanID")
	private int orderConsolidationRoutePlanID;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "OrderConsolidationID", nullable = false)
	private OrderConsolidation orderConsolidationID;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "routePlanGroupID")
	private RoutePlanGroup routePlanGroupID;

}
