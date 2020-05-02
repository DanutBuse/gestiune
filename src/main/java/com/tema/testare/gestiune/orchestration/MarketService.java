package com.tema.testare.gestiune.orchestration;

import com.tema.testare.gestiune.domain.dto.MarketDto;
import com.tema.testare.gestiune.domain.entity.MarketEntity;
import com.tema.testare.gestiune.orchestration.converter.MarketConverter;
import com.tema.testare.gestiune.repository.MarketDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketService {

  @Autowired
  private MarketDao marketDao;

  public String createMarket(MarketDto marketDto) {
    MarketEntity marketEntity = MarketConverter.fromDto(marketDto);

    marketEntity.getAddress().setMarket(marketEntity);
    marketEntity.getBankAccounts()
        .forEach(bankAccountEntity -> bankAccountEntity.setMarket(marketEntity));
    marketEntity.getEmployees()
        .forEach(employeeEntity -> {
          employeeEntity.getAddressEntity().setEmployee(employeeEntity);
          employeeEntity.setMarket(marketEntity);
          employeeEntity.getBankAccounts()
              .forEach(bankAccountEntity -> bankAccountEntity.setEmployee(employeeEntity));
        });

    MarketEntity savedEntity = marketDao.save(marketEntity);
    return savedEntity.getId().toString();
  }

  public MarketDto retrieveMarket(String id) {
    MarketEntity marketEntity = marketDao.getOne(Integer.valueOf(id));
    return MarketConverter.fromEntity(marketEntity);
  }
}
