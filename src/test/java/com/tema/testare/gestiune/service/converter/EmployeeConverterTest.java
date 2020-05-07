package com.tema.testare.gestiune.service.converter;

import static org.assertj.core.api.Assertions.assertThat;

import com.tema.testare.gestiune.domain.dto.AddressDto;
import com.tema.testare.gestiune.domain.dto.BankAccountDto;
import com.tema.testare.gestiune.domain.dto.EmployeeDto;
import com.tema.testare.gestiune.domain.dto.type.BankAccountType;
import com.tema.testare.gestiune.domain.entity.AddressEntity;
import com.tema.testare.gestiune.domain.entity.BankAccountEntity;
import com.tema.testare.gestiune.domain.entity.EmployeeEntity;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

class EmployeeConverterTest {

  final AddressEntity addressEntity = new AddressEntity("city", "street", "1234", 123);

  final BankAccountEntity bankAccountEntity = new BankAccountEntity("accNumber",
      "bankName", BankAccountType.CREDIT.name());

  final BankAccountDto bankAccountDto = new BankAccountDto("accNumber", "bankName", BankAccountType.CREDIT);

  final EmployeeEntity employeeEntity = new EmployeeEntity("firstName",
      "lastName", 23, addressEntity, "jobTitle", Collections.singletonList(bankAccountEntity));

  final AddressDto addressDto = new AddressDto("city", "street", "1234", 123);

  final EmployeeDto employeeDto = new EmployeeDto("firstName",
      "lastName", 23, addressDto, "jobTitle", Collections.singletonList(bankAccountDto));

  @Test
  void shouldConvertFromDto() {
    //When
    List<EmployeeEntity> conversionResult = EmployeeConverter.fromDto(Collections.singletonList(employeeDto));

    //Then
    assertThat(conversionResult).hasSize(1);
    assertThat(conversionResult.get(0).getAddressEntity().getStreetNumber())
        .isEqualTo(employeeEntity.getAddressEntity().getStreetNumber());
    assertThat(conversionResult.get(0).getAddressEntity().getStreet())
        .isEqualTo(employeeEntity.getAddressEntity().getStreet());
    assertThat(conversionResult.get(0).getAddressEntity().getCity())
        .isEqualTo(employeeEntity.getAddressEntity().getCity());
    assertThat(conversionResult.get(0).getAddressEntity().getPostalCode())
        .isEqualTo(employeeEntity.getAddressEntity().getPostalCode());
    assertThat(conversionResult.get(0).getAge()).isEqualTo(employeeEntity.getAge());
    assertThat(conversionResult.get(0).getFirstName()).isEqualTo(employeeEntity.getFirstName());
    assertThat(conversionResult.get(0).getLastName()).isEqualTo(employeeEntity.getLastName());
    assertThat(conversionResult.get(0).getJobTitle()).isEqualTo(employeeEntity.getJobTitle());
    assertThat(conversionResult.get(0).getBankAccounts().get(0).getBankName())
        .isEqualTo(employeeEntity.getBankAccounts().get(0).getBankName());
    assertThat(conversionResult.get(0).getBankAccounts().get(0).getBankAccountType())
        .isEqualTo(employeeEntity.getBankAccounts().get(0).getBankAccountType());
    assertThat(conversionResult.get(0).getBankAccounts().get(0).getAccountNumber())
        .isEqualTo(employeeEntity.getBankAccounts().get(0).getAccountNumber());
  }

  @Test
  void shouldConvertFromEntity() {
    //When
    List<EmployeeDto> conversionResult = EmployeeConverter.fromEntity(Collections.singletonList(employeeEntity));

    //Then
    assertThat(conversionResult).hasSize(1);
    assertThat(conversionResult.get(0)).isEqualTo(employeeDto);
  }
}