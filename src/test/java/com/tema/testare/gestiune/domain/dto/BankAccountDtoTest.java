package com.tema.testare.gestiune.domain.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.tema.testare.gestiune.domain.dto.type.BankAccountType;

import org.junit.jupiter.api.Test;

class BankAccountDtoTest {

  final BankAccountDto bankAccountDto = new BankAccountDto("accNumber", "bankName", BankAccountType.CREDIT);

  @Test
  void shouldReturnAccountNumber() {
    //Given
    String expectedAccountNumber = "test";

    //When
    bankAccountDto.setAccountNumber(expectedAccountNumber);

    //Then
    assertThat(bankAccountDto.getAccountNumber()).isEqualTo(expectedAccountNumber);
  }

  @Test
  void shouldReturnBankName() {
    //Given
    String expectedBankName = "test";

    //When
    bankAccountDto.setBankName(expectedBankName);

    //Then
    assertThat(bankAccountDto.getBankName()).isEqualTo(expectedBankName);
  }

  @Test
  void shouldReturnAccountType() {
    //Given
    BankAccountType expectedBankAccountType = BankAccountType.DEBIT;

    //When
    bankAccountDto.setBankAccountType(expectedBankAccountType);

    //Then
    assertThat(bankAccountDto.getBankAccountType()).isEqualTo(expectedBankAccountType);
  }

  @Test
  void shouldReturnTrueEquals() {
    //Given
    BankAccountDto anotherBankAccountDto = new BankAccountDto("accNumber", "bankName", BankAccountType.CREDIT);

    //When
    boolean isEqual = bankAccountDto.equals(anotherBankAccountDto);

    //Then
    assertThat(isEqual).isTrue();
  }

  @Test
  void shouldReturnFalseEquals() {
    //Given
    BankAccountDto anotherBankAccountDto = new BankAccountDto("accNumber2", "bankName", BankAccountType.CREDIT);

    //When
    boolean isEqual = bankAccountDto.equals(anotherBankAccountDto);

    //Then
    assertThat(isEqual).isFalse();
  }

  @Test
  void shouldBeDifferentHashCode() {
    //Given
    BankAccountDto anotherBankAccountDto = new BankAccountDto("accNumber2", "bankName", BankAccountType.CREDIT);

    //When
    boolean isEqualHashCode = bankAccountDto.hashCode() == anotherBankAccountDto.hashCode();

    //Then
    assertThat(isEqualHashCode).isFalse();
  }

  @Test
  void shouldBeSameHashCode() {
    //Given
    BankAccountDto anotherBankAccountDto = bankAccountDto;

    //When
    boolean isEqualHashCode = bankAccountDto.hashCode() == anotherBankAccountDto.hashCode();

    //Then
    assertThat(isEqualHashCode).isTrue();
  }
}