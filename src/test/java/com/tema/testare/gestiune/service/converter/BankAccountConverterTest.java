package com.tema.testare.gestiune.service.converter;

import static org.assertj.core.api.Assertions.assertThat;

import com.tema.testare.gestiune.domain.dto.BankAccountDto;
import com.tema.testare.gestiune.domain.dto.type.BankAccountType;
import com.tema.testare.gestiune.domain.entity.BankAccountEntity;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

class BankAccountConverterTest {

  final BankAccountEntity bankAccountEntity = new BankAccountEntity("accNumber",
      "bankName", BankAccountType.CREDIT.name());

  final BankAccountDto bankAccountDto = new BankAccountDto("accNumber", "bankName", BankAccountType.CREDIT);

  @Test
  void shouldConvertFromDto() {
    //When
    List<BankAccountEntity> conversionResult = BankAccountConverter.fromDto(Collections.singletonList(bankAccountDto));

    //Then
    assertThat(conversionResult).hasSize(1);
    assertThat(conversionResult.get(0).getAccountNumber()).isEqualTo(bankAccountDto.getAccountNumber());
    assertThat(conversionResult.get(0).getBankAccountType()).isEqualTo(bankAccountDto.getBankAccountType().name());
    assertThat(conversionResult.get(0).getBankName()).isEqualTo(bankAccountDto.getBankName());
  }

  @Test
  void shouldConvertFromEntity() {
    //When
    List<BankAccountDto> conversionResult = BankAccountConverter.fromEntity(Collections.singletonList(bankAccountEntity));

    //Then
    assertThat(conversionResult).hasSize(1);
    assertThat(conversionResult.get(0)).isEqualTo(bankAccountDto);
  }
}