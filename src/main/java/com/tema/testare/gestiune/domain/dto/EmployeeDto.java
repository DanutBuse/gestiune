package com.tema.testare.gestiune.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.List;
import java.util.Objects;

@JsonInclude(Include.NON_NULL)
public class EmployeeDto {

  private String firstName;
  private String lastName;
  private int age;
  private AddressDto address;
  private String jobTitle;
  private List<BankAccountDto> bankAccounts;

  public EmployeeDto(String firstName, String lastName, int age, AddressDto address, String jobTitle,
      List<BankAccountDto> bankAccounts) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.address = address;
    this.jobTitle = jobTitle;
    this.bankAccounts = bankAccounts;
  }

  public String getFirstName() {
    return firstName;
  }

  public EmployeeDto setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public EmployeeDto setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public int getAge() {
    return age;
  }

  public EmployeeDto setAge(int age) {
    this.age = age;
    return this;
  }

  public AddressDto getAddress() {
    return address;
  }

  public EmployeeDto setAddress(AddressDto address) {
    this.address = address;
    return this;
  }

  public String getJobTitle() {
    return jobTitle;
  }

  public EmployeeDto setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
    return this;
  }

  public List<BankAccountDto> getBankAccounts() {
    return bankAccounts;
  }

  public EmployeeDto setBankAccounts(List<BankAccountDto> bankAccounts) {
    this.bankAccounts = bankAccounts;
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
    EmployeeDto that = (EmployeeDto) o;
    return age == that.age &&
        Objects.equals(firstName, that.firstName) &&
        Objects.equals(lastName, that.lastName) &&
        Objects.equals(address, that.address) &&
        Objects.equals(jobTitle, that.jobTitle) &&
        Objects.equals(bankAccounts, that.bankAccounts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, age, address, jobTitle, bankAccounts);
  }
}
