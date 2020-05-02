package com.tema.testare.gestiune.domain.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AddressDtoTest {

  final AddressDto addressDto = new AddressDto("city", "street", "1234", 123);

  @Test
  void shouldReturnCity() {
    //Given
    String cityExpected = "test";

    //When
    addressDto.setCity(cityExpected);

    //Then
    assertThat(addressDto.getCity()).isEqualTo(cityExpected);
  }

  @Test
  void shouldReturnStreet() {
    //Given
    String streetExpected = "test";

    //When
    addressDto.setStreet(streetExpected);

    //Then
    assertThat(addressDto.getStreet()).isEqualTo(streetExpected);
  }

  @Test
  void shouldReturnPostalCode() {
    //Given
    String postalCodeExpected = "test";

    //When
    addressDto.setPostalCode(postalCodeExpected);

    //Then
    assertThat(addressDto.getPostalCode()).isEqualTo(postalCodeExpected);
  }

  @Test
  void shouldReturnStreetNumber() {
    //Given
    int streetNumberExpected = 123;

    //When
    addressDto.setStreetNumber(streetNumberExpected);

    //Then
    assertThat(addressDto.getStreetNumber()).isEqualTo(streetNumberExpected);
  }

  @Test
  void shouldReturnTrueEquals() {
    //Given
    AddressDto anotherAddressDto = new AddressDto("city", "street", "1234", 123);

    //When
    boolean isEqual = addressDto.equals(anotherAddressDto);

    //Then
    assertThat(isEqual).isTrue();
  }

  @Test
  void shouldReturnFalseEquals() {
    //Given
    AddressDto anotherAddressDto = new AddressDto("cityy", "streeyt", "123y4", 123);

    //When
    boolean isEqual = addressDto.equals(anotherAddressDto);

    //Then
    assertThat(isEqual).isFalse();
  }

  @Test
  void shouldBeDifferentHashCode() {
    //Given
    AddressDto anotherAddressDto = new AddressDto("city", "streeet", "1234", 123);

    //When
    boolean isEqualHashCode = addressDto.hashCode() == anotherAddressDto.hashCode();

    //Then
    assertThat(isEqualHashCode).isFalse();
  }

  @Test
  void shouldBeSameHashCode() {
    //Given
    AddressDto anotherAddressDto = addressDto;

    //When
    boolean isEqualHashCode = addressDto.hashCode() == anotherAddressDto.hashCode();

    //Then
    assertThat(isEqualHashCode).isTrue();
  }
}