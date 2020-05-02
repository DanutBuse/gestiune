package com.tema.testare.gestiune.orchestration.converter;

import com.tema.testare.gestiune.domain.dto.AddressDto;
import com.tema.testare.gestiune.domain.entity.AddressEntity;

public final class AddressConverter {

  private AddressConverter() {}

  public static AddressEntity fromDto(AddressDto addressDto) {
    return new AddressEntity(
        addressDto.getCity(),
        addressDto.getStreet(),
        addressDto.getPostalCode(),
        addressDto.getStreetNumber());
  }

  public static AddressDto fromEntity(AddressEntity addressEntity) {
    return new AddressDto(
        addressEntity.getCity(),
        addressEntity.getStreet(),
        addressEntity.getPostalCode(),
        addressEntity.getStreetNumber());
  }
}
