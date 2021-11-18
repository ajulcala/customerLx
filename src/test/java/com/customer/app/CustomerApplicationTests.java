package com.customer.app;

import com.customer.app.models.documents.Customer;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerApplicationTests {
  @Autowired
  private WebTestClient client;

  @Test
  public void listarTest() {
    client.get()
        .uri("/customer/list")
        .accept(MediaType.APPLICATION_JSON)
        .exchange()
        .expectStatus().isOk()
        .expectHeader().contentType(MediaType.APPLICATION_JSON)
        .expectBodyList(Customer.class)
        .consumeWith(r -> {
          List<Customer> customer = r.getResponseBody();
          Assertions.assertTrue(!(customer.size() <= 0));
        });
  }

  @Test
  public void seeDni() {
    client.get()
        .uri("/customer/documentNumber/{number}", Collections.singletonMap("number", "12345678"))
        .accept(MediaType.APPLICATION_JSON)
        .exchange()
        .expectStatus().isOk()
        .expectHeader().contentType(MediaType.APPLICATION_JSON)
        .expectBody(Customer.class)
        .consumeWith(r -> {
          Customer customer = r.getResponseBody();
          Assertions.assertTrue(!(customer.getNames().isEmpty()));
          Assertions.assertTrue(!(customer.getAddress().isEmpty()));
        });
  }

}
