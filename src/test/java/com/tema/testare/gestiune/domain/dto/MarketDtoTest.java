package com.tema.testare.gestiune.domain.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.tema.testare.gestiune.domain.dto.type.BankAccountType;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class MarketDtoTest {

  AddressDto addressDto = new AddressDto("city", "street", "1234", 123);
  BankAccountDto bankAccountDto = new BankAccountDto("accNumber", "bankName", BankAccountType.CREDIT);
  List<BankAccountDto> bankAccountDtos = Arrays.asList(bankAccountDto, bankAccountDto);
  EmployeeDto employeeDto = new EmployeeDto("firstName",
      "lastName", 23, addressDto, "jobTitle", bankAccountDtos);
  List<EmployeeDto> employeeDtos = Arrays.asList(employeeDto, employeeDto);
  MarketDto marketDto = new MarketDto("name",addressDto, bankAccountDtos, employeeDtos);

  @Test
  void shouldReturnName() {
    //Given
    String expectedName = "test";

    //When
    marketDto.setName(expectedName);

    //Then
    assertThat(marketDto.getName()).isEqualTo(expectedName);
  }

  @Test
  void shouldReturnAddress() {
    //Given
    final AddressDto anotherAddress = new AddressDto("cityy", "streett", "1234", 123);

    //When
    marketDto.setAddress(anotherAddress);

    //Then
    assertThat(marketDto.getAddress()).isEqualTo(anotherAddress);
  }

  @Test
  void shouldReturnBankAccounts() {
    //Given
    BankAccountDto anotherBankAccount = new BankAccountDto("accNumber2",
        "bankName2", BankAccountType.DEBIT);
    List<BankAccountDto> otherBankAccounts = Arrays.asList(bankAccountDto, anotherBankAccount);

    //When
    marketDto.setBankAccounts(otherBankAccounts);

    //Then
    assertThat(marketDto.getBankAccounts()).containsExactlyInAnyOrder(bankAccountDto, anotherBankAccount);
  }

  @Test
  void shouldReturnEmployees() {
    //Given
    EmployeeDto anotherEmployeeDto = new EmployeeDto("firstName2",
        "lastName2", 23, addressDto, "jobTitle", bankAccountDtos);
    List<EmployeeDto> otherEmployees = Arrays.asList(employeeDto, anotherEmployeeDto);

    //When
    marketDto.setEmployees(otherEmployees);

    //Then
    assertThat(marketDto.getEmployees()).containsExactlyInAnyOrder(employeeDto, anotherEmployeeDto);
  }

  @Test
  void shouldReturnTrueEquals() {
    //Given
    MarketDto anotherMarketDto = new MarketDto("name",addressDto, bankAccountDtos, employeeDtos);

    //When
    boolean isEqual = marketDto.equals(anotherMarketDto);

    //Then
    assertThat(isEqual).isTrue();
  }

  @Test
  void shouldReturnFalseEquals() {
    //Given
    MarketDto anotherMarketDto = new MarketDto("name2",addressDto, bankAccountDtos, employeeDtos);

    //When
    boolean isEqual = marketDto.equals(anotherMarketDto);

    //Then
    assertThat(isEqual).isFalse();
  }

  @Test
  void shouldReturnEqualHashCode() {
    //Given
    MarketDto anotherMarketDto = new MarketDto("name2",addressDto, bankAccountDtos, employeeDtos);

    //When
    boolean isEqualHashCode = marketDto.hashCode() == anotherMarketDto.hashCode();

    //Then
    assertThat(isEqualHashCode).isFalse();
  }

  @Test
  void shouldContainFieldsToString() {
    //When
    String toString = marketDto.toString();

    //Then
    assertThat(toString).contains("name", bankAccountDto.toString(), employeeDto.toString(), addressDto.toString());
  }
}