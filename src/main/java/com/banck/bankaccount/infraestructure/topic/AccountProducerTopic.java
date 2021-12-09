package com.banck.bankaccount.infraestructure.topic;

import com.banck.bankaccount.domain.Account;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import com.banck.bankaccount.aplication.model.AccountTopic;

@Component
public class AccountProducerTopic implements AccountTopic {

    @Autowired
    private KafkaTemplate<String, Account> accountKafkaTemplate;
    private final String TOPIC_ACCOUNT = "topic-cuentas-bancarias";

    @Override
    public void sendCreatedAccount(Account account) {
        List<Account> ss = new ArrayList();
        ss.add(account);
        ss.add(account);
        ss.add(account);
        ss.add(account);
        Flux.just(ss).subscribe(k -> {

            k.stream().forEach(w -> {
                this.accountKafkaTemplate.send(TOPIC_ACCOUNT, w);
                System.out.println("Cuenta ->" + w.getAccount());
            });
        });
    }
}
