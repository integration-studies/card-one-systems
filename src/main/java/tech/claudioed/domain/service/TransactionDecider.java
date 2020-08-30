package tech.claudioed.domain.service;

import java.util.concurrent.atomic.AtomicLong;
import javax.enterprise.context.ApplicationScoped;
import tech.claudioed.domain.data.TransactionResult;

@ApplicationScoped
public class TransactionDecider {

  private static final Integer jump4Deny = 20;

  private static final Integer jump4Sleep = 23;

  private final AtomicLong counter4Deny = new AtomicLong();

  private final AtomicLong counter4sleep = new AtomicLong();

  public TransactionResult decide(){
    var jumpDennyResult = this.counter4Deny.addAndGet(1);
    var counterSleepResult = this.counter4sleep.addAndGet(1);
    if ((jumpDennyResult % jump4Deny) == 0){
      return new TransactionResult(false,false);
    }
    if ((counterSleepResult % jump4Sleep) == 0){
      return new TransactionResult(false,true);
    }
    return new TransactionResult(true,false);
  }

}
