package com.tema.testare.gestiune.domain.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.tema.testare.gestiune.domain.dto.type.BankAccountType;

import org.junit.jupiter.api.Test;

import java.util.Collections;

class EmployeeDtoTest {

  final BankAccountDto bankAccountDto = new BankAccountDto("accNumber", "bankName", BankAccountType.CREDIT);

  final AddressDto addressDto = new AddressDto("city", "street", "1234", 123);

  final EmployeeDto employeeDto = new EmployeeDto("firstName",
      "lastName", 23, addressDto, "jobTitle", Collections.singletonList(bankAccountDto));

  @Test
  void shouldReturnFirstName() {
    //Given
    String expectedFirstName = "test";

    //When
    employeeDto.setFirstName(expectedFirstName);

    //Then
    assertThat(employeeDto.getFirstName()).isEqualTo(expectedFirstName);
  }

  @Test
  void shouldReturnLastName() {
    //Given
    String expectedLastName = "test";

    //When
    employeeDto.setLastName(expectedLastName);

    //Then
    assertThat(employeeDto.getLastName()).isEqualTo(expectedLastName);
  }

  @Test
  void shouldReturnAge() {
    //Given
    int expectedAge = 23;

    //When
    employeeDto.setAge(expectedAge);

    //Then
    assertThat(employeeDto.getAge()).isEqualTo(expectedAge);
  }

  @Test
  void shouldReturnBankAccounts() {
    //Given
    final BankAccountDto anotherBankAccountDto = new BankAccountDto("accNumber2", "bankName", BankAccountType.CREDIT);

    //When
    employeeDto.setBankAccounts(Collections.singletonList(anotherBankAccountDto));

    //Then
    assertThat(employeeDto.getBankAccounts().get(0).getAccountNumber()).isEqualTo("accNumber2");
  }

  @Test
  void shouldReturnAddress() {
    //Given
    final AddressDto addressDto = new AddressDto("city1", "street1", "12341", 1231);

    //When
    employeeDto.setAddress(addressDto);

    //Then
    assertThat(employeeDto.getAddress()).isEqualTo(addressDto);
  }

  @Test
  void getJobTitle() {
    //Given
    String expectedJobTitle = "test";

    //When
    employeeDto.setJobTitle(expectedJobTitle);

    //Then
    assertThat(employeeDto.getJobTitle()).isEqualTo(expectedJobTitle);
  }

  @Test
  void shouldReturnTrueEquals() {
    //Given
    EmployeeDto anotherEmployeeDto = new EmployeeDto("firstName",
        "lastName", 23, addressDto, "jobTitle", Collections.singletonList(bankAccountDto));

    //When
    boolean isEqual = employeeDto.equals(anotherEmployeeDto);

    //Then
    assertThat(isEqual).isTrue();
  }

  @Test
  void shouldReturnFalseEquals() {
    //Given
    EmployeeDto anotherEmployeeDto = new EmployeeDto("firstName",
        "lastName", 233, addressDto, "jobTitle", Collections.singletonList(bankAccountDto));

    //When
    boolean isEqual = employeeDto.equals(anotherEmployeeDto);

    //Then
    assertThat(isEqual).isFalse();
  }

  @Test
  void shouldBeDifferentHashCode() {
    //Given
    EmployeeDto anotherEmployeeDto = new EmployeeDto("firstName",
        "lastName", 233, addressDto, "jobTitle", Collections.singletonList(bankAccountDto));

    //When
    boolean isEqualHashCode = employeeDto.hashCode() == anotherEmployeeDto.hashCode();

    //Then
    assertThat(isEqualHashCode).isFalse();
  }

  @Test
  void shouldBeSameHashCode() {
    //Given
    EmployeeDto anotherEmployeeDto = employeeDto;

    //When
    boolean isEqualHashCode = employeeDto.hashCode() == anotherEmployeeDto.hashCode();

    //Then
    assertThat(isEqualHashCode).isTrue();
  }
}