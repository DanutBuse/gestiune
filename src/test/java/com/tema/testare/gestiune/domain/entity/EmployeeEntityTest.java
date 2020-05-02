package com.tema.testare.gestiune.domain.entity;

import static org.assertj.core.api.Assertions.assertThat;

import com.tema.testare.gestiune.domain.dto.type.BankAccountType;

import org.junit.jupiter.api.Test;

import java.util.Collections;

class EmployeeEntityTest {

  final AddressEntity addressEntity = new AddressEntity("city", "street", "1234", 123);

  final BankAccountEntity bankAccountEntity = new BankAccountEntity("accNumber", "bankName", BankAccountType.CREDIT.name());

  final EmployeeEntity employeeEntity = new EmployeeEntity("firstName",
      "lastName", 23, addressEntity, "jobTitle", Collections.singletonList(bankAccountEntity));

  @Test
  void shouldReturnFirstName() {
    //Given
    String expectedFirstName = "test";

    //When
    employeeEntity.setFirstName(expectedFirstName);

    //Then
    assertThat(employeeEntity.getFirstName()).isEqualTo(expectedFirstName);
  }

  @Test
  void shouldReturnLastName() {
    //Given
    String expectedLastName = "test";

    //When
    employeeEntity.setLastName(expectedLastName);

    //Then
    assertThat(employeeEntity.getLastName()).isEqualTo(expectedLastName);
  }

  @Test
  void shouldReturnAge() {
    //Given
    int expectedAge = 23;

    //When
    employeeEntity.setAge(expectedAge);

    //Then
    assertThat(employeeEntity.getAge()).isEqualTo(expectedAge);
  }

  @Test
  void shouldReturnBankAccounts() {
    //Given
    BankAccountEntity anotherBankAccountEntity = new BankAccountEntity("accNumber2", "bankName", BankAccountType.CREDIT.name());

    //When
    employeeEntity.setBankAccounts(Collections.singletonList(anotherBankAccountEntity));

    //Then
    assertThat(employeeEntity.getBankAccounts().get(0).getAccountNumber()).isEqualTo("accNumber2");
  }

  @Test
  void shouldReturnAddress() {
    //Given
    final AddressEntity anotherAddressEntity = new AddressEntity("city1", "street1", "12341", 1231);

    //When
    employeeEntity.setAddressEntity(anotherAddressEntity);

    //Then
    assertThat(employeeEntity.getAddressEntity()).isEqualTo(anotherAddressEntity);
  }

  @Test
  void getJobTitle() {
    //Given
    String expectedJobTitle = "test";

    //When
    employeeEntity.setJobTitle(expectedJobTitle);

    //Then
    assertThat(employeeEntity.getJobTitle()).isEqualTo(expectedJobTitle);
  }
}