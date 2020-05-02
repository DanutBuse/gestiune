package com.tema.testare.gestiune;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.tema.testare.gestiune.config.H2Config;

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

@SpringBootTest(webEnvironment= WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = {
    H2Config.class,
    GestiuneApplication.class})
@AutoConfigureMockMvc
public class GestiuneFunctionalTest {

  @Autowired
  private MockMvc mvc;

  @Test
  void verifyE2EFlow() throws Exception {
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

    mvc.perform(get("/market/{id}", 1))
        .andExpect(status().isOk())
        .andExpect(mvcResult ->
            mvcResult.getResponse().getContentAsString().equals(new String(jsonStream.readAllBytes())))
        .andReturn();
  }

}
