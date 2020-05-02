package com.tema.testare.gestiune.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "ADDRESS")
public class AddressEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "CITY")
  private String city;

  @Column(name = "STREET")
  private String street;

  @Column(name = "POSTAL_CODE")
  private String postalCode;

  @Column(name = "STREET_NUMBER")
  private Integer streetNumber;

  @OneToOne(mappedBy = "addressEntity")
  private EmployeeEntity employee;

  @OneToOne
  @JoinColumn(name = "MARKET")
  private MarketEntity market;

  public AddressEntity() {

  }

  public AddressEntity(String city, String street, String postalCode, Integer streetNumber) {
    this.city = city;
    this.street = street;
    this.postalCode = postalCode;
    this.streetNumber = streetNumber;
  }

  public Integer getId() {
    return id;
  }

  public AddressEntity setId(Integer id) {
    this.id = id;
    return this;
  }

  public String getCity() {
    return city;
  }

  public AddressEntity setCity(String city) {
    this.city = city;
    return this;
  }

  public String getStreet() {
    return street;
  }

  public AddressEntity setStreet(String street) {
    this.street = street;
    return this;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public AddressEntity setPostalCode(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }

  public Integer getStreetNumber() {
    return streetNumber;
  }

  public AddressEntity setStreetNumber(Integer streetNumber) {
    this.streetNumber = streetNumber;
    return this;
  }

  public EmployeeEntity getEmployee() {
    return employee;
  }

  public AddressEntity setEmployee(EmployeeEntity employee) {
    this.employee = employee;
    return this;
  }

  public MarketEntity getMarket() {
    return market;
  }

  public AddressEntity setMarket(MarketEntity market) {
    this.market = market;
    return this;
  }
}
