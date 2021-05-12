package com.ojas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ojas.models.Products;

public interface ProductDao extends JpaRepository<Products, Integer> {

} // ProductDao class closing
