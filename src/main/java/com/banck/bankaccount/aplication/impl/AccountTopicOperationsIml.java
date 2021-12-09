package com.banck.bankaccount.aplication.impl;

import com.banck.bankaccount.domain.Account;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.banck.bankaccount.aplication.AccountTopicOperation;
import com.banck.bankaccount.aplication.model.AccountTopic;

@Service
@RequiredArgsConstructor
public class AccountTopicOperationsIml implements AccountTopicOperation {

    Logger logger = LoggerFactory.getLogger(AccountTopicOperationsIml.class);
    private final AccountTopic accountKafkaProducer;

    @Override
    public void sendCreatedAccount(Account account) {
        accountKafkaProducer.sendCreatedAccount(account);
    }
}
