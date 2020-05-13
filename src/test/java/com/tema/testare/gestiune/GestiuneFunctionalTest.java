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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest(webEnvironment= WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = {
    H2Config.class,
    GestiuneApplication.class})
@AutoConfigureMockMvc
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class GestiuneFunctionalTest {

  @Autowired
  private MockMvc mvc;

  @Test
  void shouldReceiveDTOfromGetBasedOnPostBody() throws Exception {
    String path = "src/test/resources/json/maximal-market";

    MvcResult result =
        mvc.perform(post("/market")
            .contentType(MediaType.APPLICATION_JSON)
            .content(new String(Files.readAllBytes(Paths.get(path)))))
            .andExpect(status().isCreated())
            .andReturn();

    String locationHeader = result.getResponse().getHeader("location");
    assertThat(locationHeader).contains("/market/1");

    mvc.perform(get("/market/{id}", 1))
        .andExpect(status().isOk())
        .andExpect(mvcResult ->
            mvcResult.getResponse().getContentAsString().equals(new String(Files.readAllBytes(Paths.get(path)))))
        .andReturn();
  }

}
