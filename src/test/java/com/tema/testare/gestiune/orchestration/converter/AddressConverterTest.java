package com.tema.testare.gestiune.orchestration.converter;

import static org.assertj.core.api.Assertions.assertThat;

import com.tema.testare.gestiune.domain.dto.AddressDto;
import com.tema.testare.gestiune.domain.entity.AddressEntity;

import org.junit.jupiter.api.Test;

class AddressConverterTest {

  final AddressEntity addressEntity = new AddressEntity("city", "street", "1234", 123);
  final AddressDto addressDto = new AddressDto("city", "street", "1234", 123);

  @Test
  void shouldConvertEntityToDto() {
    //When
    AddressDto conversionResult = AddressConverter.fromEntity(addressEntity);

    //Then
    assertThat(addressDto).isEqualTo(conversionResult);
  }

  @Test
  void shouldConvertDtoToEntity() {
    //When
    AddressEntity conversionResult = AddressConverter.fromDto(addressDto);

    //Then
    assertThat(addressEntity.getCity()).isEqualTo(conversionResult.getCity());
    assertThat(addressEntity.getPostalCode()).isEqualTo(conversionResult.getPostalCode());
    assertThat(addressEntity.getStreet()).isEqualTo(conversionResult.getStreet());
    assertThat(addressEntity.getStreetNumber()).isEqualTo(conversionResult.getStreetNumber());
  }
}