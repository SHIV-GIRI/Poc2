package com.ojas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ojas.models.Orders;

public interface OrderDao extends JpaRepository<Orders, Integer> {

} // OrderDao class  closing
