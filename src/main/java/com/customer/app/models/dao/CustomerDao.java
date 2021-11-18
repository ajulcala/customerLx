package com.customer.app.models.dao;

import com.customer.app.models.documents.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

/**
 * My <b>interface</b>.
 * In this interface custom the queries of mongo
 *
 * @interface
 */
public interface CustomerDao extends ReactiveMongoRepository<Customer, String> {
  Flux<Customer> findByDocumentNumber(String documentNumber);
}
