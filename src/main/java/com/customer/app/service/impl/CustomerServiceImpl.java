package com.customer.app.service.impl;

import com.customer.app.models.dao.CustomerDao;
import com.customer.app.models.documents.Customer;
import com.customer.app.models.dto.TypeCustomer;
import com.customer.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreaker;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
@Service
public class CustomerServiceImpl implements CustomerService {
    private final WebClient webClient;
    private final ReactiveCircuitBreaker reactiveCircuitBreaker;

    @Value("${config.base.typecustomer}")
    private String url;

    public CustomerServiceImpl(ReactiveResilience4JCircuitBreakerFactory circuitBreakerFactory) {
        this.webClient = WebClient.builder().baseUrl(this.url).build();
        this.reactiveCircuitBreaker = circuitBreakerFactory.create("typeCustomer");
    }

    @Autowired
    private CustomerDao dao;

    @Override
    public Mono<TypeCustomer> findTypeCustomer(String id) {
        return reactiveCircuitBreaker.run(webClient.get().uri(this.url,id).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(TypeCustomer.class),
                throwable -> {
                    return this.getDefaultTypeCustomer();
                });
    }

    /**
     *
     * @return null if it does not find a Customer
     */
    public Mono<TypeCustomer> getDefaultTypeCustomer() {
        Mono<TypeCustomer> tcustomer = Mono.just(new TypeCustomer("0", null, null));
        return tcustomer;
    }

    @Override
    public Flux<Customer> findAll() {
        return null;
    }

    @Override
    public Mono<Customer> findById(String id) {
        return null;
    }

    @Override
    public Flux<Customer> findByDocumentNumber(String documentNumber) {
        return dao.findByDocumentNumber(documentNumber);
    }

    @Override
    public Mono<Customer> create(Customer customer) {
        return dao.save(customer);
    }

    @Override
    public Mono<Customer> update(Customer customer) {
        return dao.findById(customer.getId()).flatMap(c -> {
            return dao.save(customer);
        });
    }

    @Override
    public Mono<Boolean> delete(String id) {
        return dao.findById(id)
                .flatMap(dc -> dao.delete(dc).then(Mono.just(Boolean.TRUE)))
                .defaultIfEmpty(Boolean.FALSE);
    }


}
