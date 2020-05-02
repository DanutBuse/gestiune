package com.tema.testare.gestiune.repository;

import com.tema.testare.gestiune.domain.entity.EmployeeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<EmployeeEntity, Integer> {

}
