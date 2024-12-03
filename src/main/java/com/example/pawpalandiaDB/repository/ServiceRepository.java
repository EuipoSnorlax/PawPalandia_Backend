package com.example.pawpalandiaDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pawpalandiaDB.model.ServiceEntity;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {

}
