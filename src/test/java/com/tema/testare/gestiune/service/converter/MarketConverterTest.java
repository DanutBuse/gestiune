package com.tema.testare.gestiune.service.converter;

import static org.assertj.core.api.Assertions.assertThat;

import com.tema.testare.gestiune.domain.dto.AddressDto;
import com.tema.testare.gestiune.domain.dto.BankAccountDto;
import com.tema.testare.gestiune.domain.dto.EmployeeDto;
import com.tema.testare.gestiune.domain.dto.MarketDto;
import com.tema.testare.gestiune.domain.dto.type.BankAccountType;
import com.tema.testare.gestiune.domain.entity.AddressEntity;
import com.tema.testare.gestiune.domain.entity.BankAccountEntity;
import com.tema.testare.gestiune.domain.entity.EmployeeEntity;
import com.tema.testare.gestiune.domain.entity.MarketEntity;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class MarketConverterTest {

  AddressDto addressDto = new AddressDto("city", "street", "1234", 123);

  BankAccountDto bankAccountDto = new BankAccountDto("accNumber", "bankName", BankAccountType.CREDIT);

  List<BankAccountDto> bankAccountDtos = Arrays.asList(bankAccountDto, bankAccountDto);

  EmployeeDto employeeDto = new EmployeeDto("firstName",
      "lastName", 23, addressDto, "jobTitle", bankAccountDtos);

  List<EmployeeDto> employeeDtos = Arrays.asList(employeeDto, employeeDto);

  MarketDto marketDto = new MarketDto("name", addressDto, bankAccountDtos, employeeDtos);

  AddressEntity addressEntity = new AddressEntity("city", "street", "1234", 123);


  BankAccountEntity bankAccountEntity = new BankAccountEntity("accNumber", "bankName", BankAccountType.CREDIT.name());

  List<BankAccountEntity> bankAccountEntities = Arrays.asList(bankAccountEntity, bankAccountEntity);

  EmployeeEntity employeeEntity = new EmployeeEntity("firstName",
      "lastName", 23, addressEntity, "jobTitle", bankAccountEntities);

  List<EmployeeEntity> employeeEntities = Arrays.asList(employeeEntity, employeeEntity);

  MarketEntity marketEntity = new MarketEntity("name", addressEntity, bankAccountEntities, employeeEntities);


  @Test
  void shouldConvertFromDto() {
    //When
    MarketEntity conversionResult = MarketConverter.fromDto(marketDto);

    //Then
    assertThat(conversionResult.getBankAccounts().get(0).getBankName())
        .isEqualTo(marketEntity.getBankAccounts().get(0).getBankName());
    assertThat(conversionResult.getBankAccounts().get(0).getBankAccountType())
        .isEqualTo(marketEntity.getBankAccounts().get(0).getBankAccountType());
    assertThat(conversionResult.getBankAccounts().get(0).getAccountNumber())
        .isEqualTo(marketEntity.getBankAccounts().get(0).getAccountNumber());

    assertThat(conversionResult.getAddress().getStreetNumber()).isEqualTo(marketEntity.getAddress().getStreetNumber());
    assertThat(conversionResult.getAddress().getPostalCode()).isEqualTo(marketEntity.getAddress().getPostalCode());
    assertThat(conversionResult.getAddress().getStreet()).isEqualTo(marketEntity.getAddress().getStreet());
    assertThat(conversionResult.getAddress().getCity()).isEqualTo(marketEntity.getAddress().getCity());

    assertThat(conversionResult.getName()).isEqualTo(marketEntity.getName());

    assertThat(conversionResult.getEmployees().get(0).getJobTitle())
        .isEqualTo(marketEntity.getEmployees().get(0).getJobTitle());
    assertThat(conversionResult.getEmployees().get(0).getLastName())
        .isEqualTo(marketEntity.getEmployees().get(0).getLastName());
    assertThat(conversionResult.getEmployees().get(0).getFirstName())
        .isEqualTo(marketEntity.getEmployees().get(0).getFirstName());
    assertThat(conversionResult.getEmployees().get(0).getAge())
        .isEqualTo(marketEntity.getEmployees().get(0).getAge());
  }

  @Test
  void shouldConvertFromEntity() {
    //When
    MarketDto conversionResult = MarketConverter.fromEntity(marketEntity);

    //Then
    assertThat(conversionResult).isEqualTo(marketDto);
  }
}