package com.banck.bankaccount.aplication;

import com.banck.bankaccount.domain.Account;

public interface AccountTopicOperation {

    public void sendCreatedAccount(Account account);
}
