package com.tema.testare.gestiune.domain.entity;

import static org.assertj.core.api.Assertions.assertThat;

import com.tema.testare.gestiune.domain.dto.type.BankAccountType;

import org.junit.jupiter.api.Test;

class BankAccountEntityTest {
  final BankAccountEntity bankAccountEntity = new BankAccountEntity("accNumber",
      "bankName", BankAccountType.CREDIT.name());

  @Test
  void shouldReturnAccountNumber() {
    //Given
    String expectedAccountNumber = "test";

    //When
    bankAccountEntity.setAccountNumber(expectedAccountNumber);

    //Then
    assertThat(bankAccountEntity.getAccountNumber()).isEqualTo(expectedAccountNumber);
  }

  @Test
  void shouldReturnBankName() {
    //Given
    String expectedBankName = "test";

    //When
    bankAccountEntity.setBankName(expectedBankName);

    //Then
    assertThat(bankAccountEntity.getBankName()).isEqualTo(expectedBankName);
  }

  @Test
  void shouldReturnAccountType() {
    //Given
    BankAccountType expectedBankAccountType = BankAccountType.DEBIT;

    //When
    bankAccountEntity.setBankAccountType(expectedBankAccountType.name());

    //Then
    assertThat(bankAccountEntity.getBankAccountType()).isEqualTo(expectedBankAccountType.name());
  }

}