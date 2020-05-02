package com.tema.testare.gestiune.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.List;
import java.util.Objects;

@JsonInclude(Include.NON_NULL)
public class MarketDto {

  private String name;
  private AddressDto address;
  private List<BankAccountDto> bankAccounts;
  private List<EmployeeDto> employees;

  public MarketDto(String name, AddressDto address, List<BankAccountDto> bankAccounts, List<EmployeeDto> employees) {
    this.name = name;
    this.address = address;
    this.bankAccounts = bankAccounts;
    this.employees = employees;
  }

  public String getName() {
    return name;
  }

  public MarketDto setName(String name) {
    this.name = name;
    return this;
  }

  public AddressDto getAddress() {
    return address;
  }

  public MarketDto setAddress(AddressDto address) {
    this.address = address;
    return this;
  }

  public List<BankAccountDto> getBankAccounts() {
    return bankAccounts;
  }

  public MarketDto setBankAccounts(List<BankAccountDto> bankAccounts) {
    this.bankAccounts = bankAccounts;
    return this;
  }

  public List<EmployeeDto> getEmployees() {
    return employees;
  }

  public MarketDto setEmployees(List<EmployeeDto> employees) {
    this.employees = employees;
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
    MarketDto marketDto = (MarketDto) o;
    return name.equals(marketDto.name) &&
        address.equals(marketDto.address) &&
        bankAccounts.equals(marketDto.bankAccounts) &&
        employees.equals(marketDto.employees);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, address, bankAccounts, employees);
  }

  @Override
  public String toString() {
    return "MarketDto{" +
        "name='" + name + '\'' +
        ", address=" + address +
        ", bankAccounts=" + bankAccounts +
        ", employees=" + employees +
        '}';
  }
}
