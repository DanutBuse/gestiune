package com.tema.testare.gestiune.service.converter;

import com.tema.testare.gestiune.domain.dto.BankAccountDto;
import com.tema.testare.gestiune.domain.dto.type.BankAccountType;
import com.tema.testare.gestiune.domain.entity.BankAccountEntity;

import java.util.List;
import java.util.stream.Collectors;

public final class BankAccountConverter {

  private BankAccountConverter() {}

  public static List<BankAccountEntity> fromDto(List<BankAccountDto> dtos) {
    return dtos.stream()
        .map(dto -> new BankAccountEntity(
            dto.getAccountNumber(),
            dto.getBankName(),
            dto.getBankAccountType().name()
        ))
        .collect(Collectors.toList());
  }

  public static List<BankAccountDto> fromEntity(List<BankAccountEntity> bankAccounts) {
    return bankAccounts.stream()
        .map(bankAccountEntity -> new BankAccountDto(
            bankAccountEntity.getAccountNumber(),
            bankAccountEntity.getBankName(),
            BankAccountType.valueOf(bankAccountEntity.getBankAccountType())
        ))
        .collect(Collectors.toList());

  }
}
