package com.bds.collector.infrastructure.db.mongo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Repository;

import com.bds.collector.domain.model.AccountModel;
import com.bds.collector.domain.repository.AccountRepository;
import com.bds.collector.infrastructure.db.mongo.entity.AccountEntity;
import com.bds.collector.infrastructure.db.mongo.mapper.AccountMapper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class AccountDao implements AccountRepository {
    @Autowired
    private ReactiveMongoTemplate template;

    @Override
    public Mono<AccountModel> findById(String id) {
        return AccountMapper.toModel(template.findById(id, AccountEntity.class));
    }
 
    @Override
    public Flux<AccountModel> findAll() {
        return AccountMapper.toModel(template.findAll(AccountEntity.class));
    } 

    @Override
    public Mono<AccountModel> save(AccountModel account) {
        return AccountMapper.toModel(template.save(AccountMapper.toEntity(account)));
    }
}
