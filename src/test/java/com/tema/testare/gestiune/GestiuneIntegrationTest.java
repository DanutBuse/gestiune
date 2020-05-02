package com.tema.testare.gestiune;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.tema.testare.gestiune.config.H2Config;
import com.tema.testare.gestiune.domain.entity.AddressEntity;
import com.tema.testare.gestiune.domain.entity.BankAccountEntity;
import com.tema.testare.gestiune.domain.entity.EmployeeEntity;
import com.tema.testare.gestiune.domain.entity.MarketEntity;
import com.tema.testare.gestiune.repository.AddressDao;
import com.tema.testare.gestiune.repository.BankAccountDao;
import com.tema.testare.gestiune.repository.EmployeeDao;
import com.tema.testare.gestiune.repository.MarketDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

@SpringBootTest(webEnvironment= WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = {
		H2Config.class,
		GestiuneApplication.class})
@AutoConfigureMockMvc
class GestiuneIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private MarketDao marketDao;

	@Autowired
	private BankAccountDao bankAccountsDao;

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private AddressDao addressDao;

	@Test
	void verifyDatabaseStorage() throws Exception {
		File initialFile = new File("src/test/resources/json/maximal-market");
		InputStream jsonStream = new FileInputStream(initialFile);

		MvcResult result =
				mvc.perform(post("/market")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new String(jsonStream.readAllBytes())))
				.andExpect(status().isCreated())
				.andReturn();

		String locationHeader = result.getResponse().getHeader("location");
		assertThat(locationHeader).contains("/market/1");

		MarketEntity market = marketDao.findById(1).orElse(null);
		assertThat(market).isNotNull();

		List<EmployeeEntity> employees = employeeDao.findAll();
		List<BankAccountEntity> bankAccounts = bankAccountsDao.findAll();
		List<AddressEntity> addresses = addressDao.findAll();

		assertThat(market.getName()).isEqualTo("numeMarket");
		assertThat(market.getAddress().getCity()).isEqualTo("cityMarket");
		assertThat(market.getAddress().getStreetNumber()).isEqualTo(23);
		assertThat(market.getAddress().getStreet()).isEqualTo("streetMarket");
		assertThat(market.getAddress().getPostalCode()).isEqualTo("postalCodeMarket");

		assertThat(employees).hasSize(2);
		assertThat(employees.get(0).getFirstName()).isEqualTo("emp1FirstName");
		assertThat(employees.get(0).getLastName()).isEqualTo("emp1LastName");
		assertThat(employees.get(0).getJobTitle()).isEqualTo("emp1JobTitle");
		assertThat(employees.get(0).getAge()).isEqualTo(30);
		assertThat(employees.get(0).getAddressEntity().getCity()).isEqualTo("cityEmp1");
		assertThat(employees.get(0).getAddressEntity().getStreet()).isEqualTo("streetEmp1");
		assertThat(employees.get(0).getAddressEntity().getPostalCode()).isEqualTo("postalCodeEmp1");
		assertThat(employees.get(0).getAddressEntity().getStreetNumber()).isEqualTo(233);

		assertThat(employees.get(1).getFirstName()).isEqualTo("emp2FirstName");
		assertThat(employees.get(1).getLastName()).isEqualTo("emp2LastName");
		assertThat(employees.get(1).getJobTitle()).isEqualTo("emp2JobTitle");
		assertThat(employees.get(1).getAge()).isEqualTo(31);
		assertThat(employees.get(1).getAddressEntity().getCity()).isEqualTo("cityEmp2");
		assertThat(employees.get(1).getAddressEntity().getStreet()).isEqualTo("streetEmp2");
		assertThat(employees.get(1).getAddressEntity().getPostalCode()).isEqualTo("postalCodeEmp2");
		assertThat(employees.get(1).getAddressEntity().getStreetNumber()).isEqualTo(233);

		assertThat(bankAccounts).hasSize(6);
		assertThat(bankAccounts.get(0).getAccountNumber()).isEqualTo("123443123");
		assertThat(bankAccounts.get(0).getBankAccountType()).isEqualTo("DEBIT");
		assertThat(bankAccounts.get(0).getBankName()).isEqualTo("HSBC");
		assertThat(bankAccounts.get(0).getMarket().getId()).isEqualTo(1);

		assertThat(bankAccounts.get(1).getAccountNumber()).isEqualTo("123441223");
		assertThat(bankAccounts.get(1).getBankAccountType()).isEqualTo("CREDIT");
		assertThat(bankAccounts.get(1).getBankName()).isEqualTo("HSBC");
		assertThat(bankAccounts.get(1).getMarket().getId()).isEqualTo(1);

		assertThat(bankAccounts.get(2).getAccountNumber()).isEqualTo("123443144");
		assertThat(bankAccounts.get(2).getBankAccountType()).isEqualTo("DEBIT");
		assertThat(bankAccounts.get(2).getBankName()).isEqualTo("HSBC");
		assertThat(bankAccounts.get(2).getEmployee().getId()).isEqualTo(1);

		assertThat(bankAccounts.get(3).getAccountNumber()).isEqualTo("123441244");
		assertThat(bankAccounts.get(3).getBankAccountType()).isEqualTo("CREDIT");
		assertThat(bankAccounts.get(3).getBankName()).isEqualTo("HSBC");
		assertThat(bankAccounts.get(3).getEmployee().getId()).isEqualTo(1);

		assertThat(bankAccounts.get(4).getAccountNumber()).isEqualTo("123443155");
		assertThat(bankAccounts.get(4).getBankAccountType()).isEqualTo("DEBIT");
		assertThat(bankAccounts.get(4).getBankName()).isEqualTo("HSBC");
		assertThat(bankAccounts.get(4).getEmployee().getId()).isEqualTo(2);

		assertThat(bankAccounts.get(5).getAccountNumber()).isEqualTo("123441233");
		assertThat(bankAccounts.get(5).getBankAccountType()).isEqualTo("CREDIT");
		assertThat(bankAccounts.get(5).getBankName()).isEqualTo("HSBC");
		assertThat(bankAccounts.get(5).getEmployee().getId()).isEqualTo(2);

		assertThat(addresses).hasSize(3);
		assertThat(addresses.get(0).getEmployee().getId()).isEqualTo(1);
		assertThat(addresses.get(1).getEmployee().getId()).isEqualTo(2);
		assertThat(addresses.get(2).getMarket().getId()).isEqualTo(1);

	}

}
