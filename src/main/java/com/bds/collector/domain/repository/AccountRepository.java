package com.bds.collector.domain.repository;

import com.bds.collector.domain.model.AccountModel;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountRepository {
    public Mono<AccountModel> findById(String id);
    public Flux<AccountModel> findAll();
    public Mono<AccountModel> save(AccountModel account);
}
