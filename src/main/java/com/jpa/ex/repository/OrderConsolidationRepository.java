package com.jpa.ex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.ex.entity.OrderConsolidation;


@Repository
public interface OrderConsolidationRepository extends JpaRepository<OrderConsolidation, Integer>{

}
