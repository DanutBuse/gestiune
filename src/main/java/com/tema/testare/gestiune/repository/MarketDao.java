package com.tema.testare.gestiune.repository;

import com.tema.testare.gestiune.domain.entity.MarketEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketDao extends JpaRepository<MarketEntity, Integer> {

}
