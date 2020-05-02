package com.tema.testare.gestiune.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tema.testare.gestiune.domain.dto.type.BankAccountType;

import java.util.Objects;

@JsonInclude(Include.NON_NULL)
public class BankAccountDto {

  private String accountNumber;
  private String bankName;
  private BankAccountType bankAccountType;

  public BankAccountDto(String accountNumber, String bankName, BankAccountType bankAccountType) {
    this.accountNumber = accountNumber;
    this.bankName = bankName;
    this.bankAccountType = bankAccountType;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public BankAccountDto setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  public String getBankName() {
    return bankName;
  }

  public BankAccountDto setBankName(String bankName) {
    this.bankName = bankName;
    return this;
  }

  public BankAccountType getBankAccountType() {
    return bankAccountType;
  }

  public BankAccountDto setBankAccountType(BankAccountType bankAccountType) {
    this.bankAccountType = bankAccountType;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankAccountDto that = (BankAccountDto) o;
    return Objects.equals(accountNumber, that.accountNumber) &&
        Objects.equals(bankName, that.bankName) &&
        bankAccountType == that.bankAccountType;
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountNumber, bankName, bankAccountType);
  }
}
