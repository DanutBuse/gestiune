package com.tema.testare.gestiune.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.Objects;

@JsonInclude(Include.NON_NULL)
public class AddressDto {

  private String city;
  private String street;
  private String postalCode;
  private int streetNumber;

  public AddressDto(String city, String street, String postalCode, int streetNumber) {
    this.city = city;
    this.street = street;
    this.postalCode = postalCode;
    this.streetNumber = streetNumber;
  }

  public String getCity() {
    return city;
  }

  public AddressDto setCity(String city) {
    this.city = city;
    return this;
  }

  public String getStreet() {
    return street;
  }

  public AddressDto setStreet(String street) {
    this.street = street;
    return this;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public AddressDto setPostalCode(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }

  public int getStreetNumber() {
    return streetNumber;
  }

  public AddressDto setStreetNumber(int streetNumber) {
    this.streetNumber = streetNumber;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddressDto that = (AddressDto) o;
    return streetNumber == that.streetNumber &&
        Objects.equals(city, that.city) &&
        Objects.equals(street, that.street) &&
        Objects.equals(postalCode, that.postalCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(city, street, postalCode, streetNumber);
  }
}
