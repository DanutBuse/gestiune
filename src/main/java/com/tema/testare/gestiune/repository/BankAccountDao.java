package com.tema.testare.gestiune.repository;

import com.tema.testare.gestiune.domain.entity.BankAccountEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountDao extends JpaRepository<BankAccountEntity, Integer> {

}
