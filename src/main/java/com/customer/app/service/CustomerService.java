package com.customer.app.service;

import com.customer.app.models.documents.Customer;
import com.customer.app.models.dto.TypeCustomer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * My <b>lombok</b>.
 * My annotations of lombok
 *
 * @Data
 */
public interface CustomerService {
  public Mono<TypeCustomer> findTypeCustomer(String id);

  public Flux<Customer> findAll();

  public Mono<Customer> findById(String id);

  public Mono<Customer> findByDocumentNumber(String documentNumber);

  public Mono<Customer> create(Customer customer);

  public Mono<Customer> update(Customer customer);

  public Mono<Boolean> delete(String id);
}
