package com.tema.testare.gestiune.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import com.tema.testare.gestiune.domain.dto.AddressDto;
import com.tema.testare.gestiune.domain.dto.BankAccountDto;
import com.tema.testare.gestiune.domain.dto.EmployeeDto;
import com.tema.testare.gestiune.domain.dto.MarketDto;
import com.tema.testare.gestiune.domain.dto.type.BankAccountType;
import com.tema.testare.gestiune.domain.entity.MarketEntity;
import com.tema.testare.gestiune.service.converter.MarketConverter;
import com.tema.testare.gestiune.repository.BankAccountDao;
import com.tema.testare.gestiune.repository.MarketDao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;


class MarketServiceTest {

  AddressDto addressDto = new AddressDto("city", "street", "1234", 123);

  BankAccountDto bankAccountDto = new BankAccountDto("accNumber", "bankName", BankAccountType.CREDIT);

  List<BankAccountDto> bankAccountDtos = Arrays.asList(bankAccountDto, bankAccountDto);

  EmployeeDto employeeDto = new EmployeeDto("firstName",
      "lastName", 23, addressDto, "jobTitle", bankAccountDtos);

  List<EmployeeDto> employeeDtos = Arrays.asList(employeeDto, employeeDto);

  MarketDto marketDto = new MarketDto("name", addressDto, bankAccountDtos, employeeDtos);

  @Mock
  MarketDao marketDao;

  @InjectMocks
  MarketService marketService;

  @BeforeEach
  void setup() {
    initMocks(this);
  }

  @Test
  void shouldReturnSavedEntityId() {
    //Given
    MarketEntity marketEntity = new MarketEntity();
    marketEntity.setId(1);
    when(marketDao.save(any(MarketEntity.class))).thenReturn(marketEntity);

    //When
    String id = marketService.createMarket(marketDto);

    //Then
    verify(marketDao, times(1)).save(any(MarketEntity.class));
    assertThat(id).isEqualTo(marketEntity.getId().toString());
  }

  @Test
  void shouldReturnMarketBasedOnId() {
    //Given
    Integer id = 3;
    MarketEntity marketEntity = MarketConverter.fromDto(marketDto);
    marketEntity.setId(id);
    when(marketDao.getOne(id)).thenReturn(marketEntity);

    //When
    MarketDto marketDto = marketService.retrieveMarket(Integer.toString(id));

    //Then
    verify(marketDao, times(1)).getOne(id);
    assertThat("name").isEqualTo(marketDto.getName());
  }

}