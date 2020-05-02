package com.tema.testare.gestiune.orchestration.converter;

import com.tema.testare.gestiune.domain.dto.MarketDto;
import com.tema.testare.gestiune.domain.entity.MarketEntity;

public final class MarketConverter {

  private MarketConverter() {}

  public static MarketEntity fromDto(MarketDto marketDto) {
    return new MarketEntity(
        marketDto.getName(),
        AddressConverter.fromDto(marketDto.getAddress()),
        BankAccountConverter.fromDto(marketDto.getBankAccounts()),
        EmployeeConverter.fromDto(marketDto.getEmployees()));
  }

  public static MarketDto fromEntity(MarketEntity marketEntity) {
    return new MarketDto(
        marketEntity.getName(),
        AddressConverter.fromEntity(marketEntity.getAddress()),
        BankAccountConverter.fromEntity(marketEntity.getBankAccounts()),
        EmployeeConverter.fromEntity(marketEntity.getEmployees())
    );
  }
}
