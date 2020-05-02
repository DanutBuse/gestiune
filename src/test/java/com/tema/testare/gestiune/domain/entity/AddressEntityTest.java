package com.tema.testare.gestiune.domain.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AddressEntityTest {

  final AddressEntity addressEntity = new AddressEntity("city", "street", "1234", 123);

  @Test
  void shouldReturnCity() {
    //Given
    String cityExpected = "test";

    //When
    addressEntity.setCity(cityExpected);

    //Then
    assertThat(addressEntity.getCity()).isEqualTo(cityExpected);
  }

  @Test
  void shouldReturnStreet() {
    //Given
    String streetExpected = "test";

    //When
    addressEntity.setStreet(streetExpected);

    //Then
    assertThat(addressEntity.getStreet()).isEqualTo(streetExpected);
  }

  @Test
  void shouldReturnPostalCode() {
    //Given
    String postalCodeExpected = "test";

    //When
    addressEntity.setPostalCode(postalCodeExpected);

    //Then
    assertThat(addressEntity.getPostalCode()).isEqualTo(postalCodeExpected);
  }

  @Test
  void shouldReturnStreetNumber() {
    //Given
    int streetNumberExpected = 123;

    //When
    addressEntity.setStreetNumber(streetNumberExpected);

    //Then
    assertThat(addressEntity.getStreetNumber()).isEqualTo(streetNumberExpected);
  }
}