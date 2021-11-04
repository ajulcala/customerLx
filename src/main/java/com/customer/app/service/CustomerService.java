package com.customer.app.service;

import com.customer.app.models.documents.Customer;
import com.customer.app.models.dto.TypeCustomer;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

public interface CustomerService {
    public Mono<TypeCustomer> findTypeCustomer(String id);
    public Flux<Customer> findAll();
    public Mono<Customer> findById(String id);
    public Flux<Customer> findByDocumentNumber(String documentNumber);
    public Mono<Customer> create(Customer customer);
    public Mono<Customer> update(Customer customer);
    public Mono<Boolean> delete(String id);
}
