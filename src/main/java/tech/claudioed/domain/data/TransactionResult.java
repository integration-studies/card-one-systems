package tech.claudioed.domain.data;

public class TransactionResult {

  private final Boolean success;

  private final Boolean sleep;

  public TransactionResult(Boolean success, Boolean sleep) {
    this.success = success;
    this.sleep = sleep;
  }

  public Boolean success() {
    return success;
  }

  public Boolean sleep() {
    return sleep;
  }

}
