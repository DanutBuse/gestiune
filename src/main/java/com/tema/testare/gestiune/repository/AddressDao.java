package com.tema.testare.gestiune.repository;

import com.tema.testare.gestiune.domain.entity.AddressEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDao extends JpaRepository<AddressEntity, Integer> {

}
