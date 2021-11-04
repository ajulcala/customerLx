package com.customer.app.models.dao;

import com.customer.app.models.documents.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface CustomerDao extends ReactiveMongoRepository<Customer,String> {
        Flux<Customer> findByDocumentNumber(String documentNumber);
}
