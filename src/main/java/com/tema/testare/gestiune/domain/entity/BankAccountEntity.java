package com.tema.testare.gestiune.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "BANK_ACCOUNT")
public class BankAccountEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "ACCOUNT_NUMBER")
  private String accountNumber;

  @Column(name = "BANK_NAME")
  private String bankName;

  @Column(name = "ACCOUNT_TYPE")
  private String bankAccountType;

  @ManyToOne
  @JoinColumn(name = "MARKET")
  private MarketEntity market;

  @ManyToOne
  @JoinColumn(name = "EMPLOYEE")
  private EmployeeEntity employee;

  public BankAccountEntity() {

  }

  public BankAccountEntity(String accountNumber, String bankName, String bankAccountType) {
    this.accountNumber = accountNumber;
    this.bankName = bankName;
    this.bankAccountType = bankAccountType;
  }

  public Integer getId() {
    return id;
  }

  public BankAccountEntity setId(Integer id) {
    this.id = id;
    return this;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public BankAccountEntity setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  public String getBankName() {
    return bankName;
  }

  public BankAccountEntity setBankName(String bankName) {
    this.bankName = bankName;
    return this;
  }

  public String getBankAccountType() {
    return bankAccountType;
  }

  public BankAccountEntity setBankAccountType(String bankAccountType) {
    this.bankAccountType = bankAccountType;
    return this;
  }

  public MarketEntity getMarket() {
    return market;
  }

  public BankAccountEntity setMarket(MarketEntity market) {
    this.market = market;
    return this;
  }

  public EmployeeEntity getEmployee() {
    return employee;
  }

  public BankAccountEntity setEmployee(EmployeeEntity employee) {
    this.employee = employee;
    return this;
  }
}
