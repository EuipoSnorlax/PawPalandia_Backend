package com.example.pawpalandiaDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pawpalandiaDB.model.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
