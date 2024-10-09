package com.bds.collector.application.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bds.collector.application.account.dto.RegisterEmailDto;
import com.bds.collector.domain.repository.AccountRepository;

import reactor.core.publisher.Mono;

@Service
public class RegisterEmailService {
    @Autowired
    private AccountRepository accountRepository;

    public Mono<ResponseEntity<RegisterEmailDto.Response>>  bussines() {
        return accountRepository.save(null).map(account -> ResponseEntity.status(HttpStatus.CREATED).body(null));
    }
}
