package com.tema.testare.gestiune.domain.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "MARKETS")
public class MarketEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "NAME")
  private String name;

  @OneToOne(mappedBy = "market", cascade = CascadeType.ALL)
  private AddressEntity address;

  @OneToMany(mappedBy = "market", cascade = CascadeType.ALL)
  private List<BankAccountEntity> bankAccounts;

  @OneToMany(mappedBy = "market", cascade = CascadeType.ALL)
  private List<EmployeeEntity> employees;

  public MarketEntity() {
    //pt GET
  }

  public MarketEntity(String name, AddressEntity address, List<BankAccountEntity> bankAccounts,
      List<EmployeeEntity> employees) {
    this.name = name;
    this.address = address;
    this.bankAccounts = bankAccounts;
    this.employees = employees;
  }

  public Integer getId() {
    return id;
  }

  public MarketEntity setId(Integer id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public MarketEntity setName(String name) {
    this.name = name;
    return this;
  }

  public AddressEntity getAddress() {
    return address;
  }

  public MarketEntity setAddress(AddressEntity address) {
    this.address = address;
    return this;
  }

  public List<BankAccountEntity> getBankAccounts() {
    return bankAccounts;
  }

  public MarketEntity setBankAccounts(List<BankAccountEntity> bankAccounts) {
    this.bankAccounts = bankAccounts;
    return this;
  }

  public List<EmployeeEntity> getEmployees() {
    return employees;
  }

  public MarketEntity setEmployees(List<EmployeeEntity> employees) {
    this.employees = employees;
    return this;
  }
}
