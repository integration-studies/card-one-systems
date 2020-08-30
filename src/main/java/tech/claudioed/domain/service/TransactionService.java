package tech.claudioed.domain.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import tech.claudioed.domain.Payment;
import tech.claudioed.domain.data.PaymentData;
import tech.claudioed.domain.data.TransactionRequest;

@ApplicationScoped
public class TransactionService {

  private final TransactionDecider transactionDecider;

  @Inject
  public TransactionService(TransactionDecider transactionDecider) {
    this.transactionDecider = transactionDecider;
  }

  public PaymentData pay(TransactionRequest transactionRequest){
    final var transactionResult = this.transactionDecider.decide();
    final var payment = new Payment(UUID.randomUUID().toString(),
        BigDecimal.valueOf(Long.parseLong(transactionRequest.getValue())),
        LocalDateTime.now());
    return new PaymentData(payment,transactionResult);
  }

}
