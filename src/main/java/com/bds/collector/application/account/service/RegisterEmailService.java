package com.bds.collector.application.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bds.collector.application.account.dto.RegisterEmailDto.Response;
import com.bds.collector.application.account.dto.RegisterEmailDto.Request;
import com.bds.collector.domain.model.AccountModel;
import com.bds.collector.domain.repository.AccountRepository;

import reactor.core.publisher.Mono;

@Service
public class RegisterEmailService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public Mono<ResponseEntity<Response>> bussines(Request request) throws Exception {
        if (!request.getTermCondition().isConfirm()) {
            throw new Exception();
        }

        if (!request.getPassword().equals(request.getConfirmPassword())) {
            throw new Exception();
        }

        return accountRepository.save(AccountModel.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build())
                .map(account -> ResponseEntity.status(HttpStatus.CREATED).body(Response.builder().build()));
    }
}
