package com.tema.testare.gestiune.domain.entity;

import static org.assertj.core.api.Assertions.assertThat;

import com.tema.testare.gestiune.domain.dto.type.BankAccountType;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class MarketEntityTest {

  AddressEntity addressEntity = new AddressEntity("city", "street", "1234", 123);


  BankAccountEntity bankAccountEntity = new BankAccountEntity("accNumber", "bankName", BankAccountType.CREDIT.name());

  List<BankAccountEntity> bankAccountEntities = Arrays.asList(bankAccountEntity, bankAccountEntity);

  EmployeeEntity employeeEntity = new EmployeeEntity("firstName",
      "lastName", 23, addressEntity, "jobTitle", bankAccountEntities);

  List<EmployeeEntity> employeeEntities = Arrays.asList(employeeEntity, employeeEntity);

  MarketEntity marketEntity = new MarketEntity("name", addressEntity, bankAccountEntities, employeeEntities);

  @Test
  void shouldReturnName() {
    //Given
    String expectedName = "test";

    //When
    marketEntity.setName(expectedName);

    //Then
    assertThat(marketEntity.getName()).isEqualTo(expectedName);
  }

  @Test
  void shouldReturnAddress() {
    //Given
    AddressEntity anotherAddress = new AddressEntity("cityy", "streett", "1234", 123);

    //When
    marketEntity.setAddress(anotherAddress);

    //Then
    assertThat(marketEntity.getAddress()).isEqualTo(anotherAddress);
  }

  @Test
  void shouldReturnBankAccounts() {
    //Given
    BankAccountEntity anotherBankAccount = new BankAccountEntity("accNumber2",
        "bankName2", BankAccountType.DEBIT.name());
    List<BankAccountEntity> otherBankAccounts = Arrays.asList(bankAccountEntity, anotherBankAccount);

    //When
    marketEntity.setBankAccounts(otherBankAccounts);

    //Then
    assertThat(marketEntity.getBankAccounts()).containsExactlyInAnyOrder(bankAccountEntity, anotherBankAccount);
  }

  @Test
  void shouldReturnEmployees() {
    //Given
    EmployeeEntity anotherEmployee = new EmployeeEntity("firstName2",
        "lastName2", 23, addressEntity, "jobTitle", bankAccountEntities);
    List<EmployeeEntity> otherEmployees = Arrays.asList(employeeEntity, anotherEmployee);

    //When
    marketEntity.setEmployees(otherEmployees);

    //Then
    assertThat(marketEntity.getEmployees()).containsExactlyInAnyOrder(employeeEntity, anotherEmployee);
  }
}