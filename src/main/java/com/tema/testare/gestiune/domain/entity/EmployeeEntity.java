package com.tema.testare.gestiune.domain.entity;

import com.tema.testare.gestiune.domain.dto.AddressDto;
import com.tema.testare.gestiune.repository.EmployeeDao;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "EMPLOYEE")
public class EmployeeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "FIRST_NAME")
  private String firstName;

  @Column(name = "LAST_NAME")
  private String lastName;

  @Column(name = "AGE")
  private Integer age;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "ADDRESS")
  private AddressEntity addressEntity;

  @Column(name = "JOB_TITLE")
  private String jobTitle;

  @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
  private List<BankAccountEntity> bankAccounts;

  @ManyToOne
  @JoinColumn(name = "MARKET")
  private MarketEntity market;

  public EmployeeEntity() {

  }

  public EmployeeEntity(String firstName, String lastName, Integer age, AddressEntity addressEntity, String jobTitle,
      List<BankAccountEntity> bankAccounts) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.addressEntity = addressEntity;
    this.jobTitle = jobTitle;
    this.bankAccounts = bankAccounts;
  }

  public Integer getId() {
    return id;
  }

  public EmployeeEntity setId(Integer id) {
    this.id = id;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public EmployeeEntity setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public EmployeeEntity setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public Integer getAge() {
    return age;
  }

  public EmployeeEntity setAge(Integer age) {
    this.age = age;
    return this;
  }

  public AddressEntity getAddressEntity() {
    return addressEntity;
  }

  public EmployeeEntity setAddressEntity(AddressEntity addressEntity) {
    this.addressEntity = addressEntity;
    return this;
  }

  public String getJobTitle() {
    return jobTitle;
  }

  public EmployeeEntity setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
    return this;
  }

  public List<BankAccountEntity> getBankAccounts() {
    return bankAccounts;
  }

  public EmployeeEntity setBankAccounts(List<BankAccountEntity> bankAccounts) {
    this.bankAccounts = bankAccounts;
    return this;
  }

  public MarketEntity getMarket() {
    return market;
  }

  public EmployeeEntity setMarket(MarketEntity market) {
    this.market = market;
    return this;
  }
}
