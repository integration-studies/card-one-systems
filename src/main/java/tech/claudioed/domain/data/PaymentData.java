package tech.claudioed.domain.data;

import tech.claudioed.domain.Payment;

/**
 * @author claudioed on 29/08/20.
 * Project card-one-systems
 */
public class PaymentData {

  private final Payment payment;

  private final TransactionResult operation;

  public PaymentData(Payment payment, TransactionResult operation) {
    this.payment = payment;
    this.operation = operation;
  }

  public Payment getPayment() {
    return payment;
  }

  public TransactionResult getOperation() {
    return operation;
  }

  public boolean success(){
    return this.operation.success();
  }

  public boolean sleep(){
    return this.operation.sleep();
  }

}
