package com.tema.testare.gestiune.service.converter;

import com.tema.testare.gestiune.domain.dto.EmployeeDto;
import com.tema.testare.gestiune.domain.entity.EmployeeEntity;

import java.util.List;
import java.util.stream.Collectors;

public final class EmployeeConverter {

  private EmployeeConverter() {

  }

  public static List<EmployeeEntity> fromDto(List<EmployeeDto> employeeDto) {
    return employeeDto.stream()
        .map(emDto -> new EmployeeEntity(
            emDto.getFirstName(),
            emDto.getLastName(),
            emDto.getAge(),
            AddressConverter.fromDto(emDto.getAddress()),
            emDto.getJobTitle(),
            BankAccountConverter.fromDto(emDto.getBankAccounts())))
        .collect(Collectors.toList());
  }

  public static List<EmployeeDto> fromEntity(List<EmployeeEntity> employees) {
    return employees.stream()
        .map(employeeEntity -> new EmployeeDto(
            employeeEntity.getFirstName(),
            employeeEntity.getLastName(),
            employeeEntity.getAge(),
            AddressConverter.fromEntity(employeeEntity.getAddressEntity()),
            employeeEntity.getJobTitle(),
            BankAccountConverter.fromEntity(employeeEntity.getBankAccounts())))
        .collect(Collectors.toList());
  }
}
