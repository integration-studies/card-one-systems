package tech.claudioed.domain.data;

public class TransactionRequest {

  String type;

  String subType;

  String fromAccount;

  String toAccount;

  String value;

  String time;

  String deviceType;

  public TransactionRequest(){}

  public String getType() {
    return type;
  }

  public String getSubType() {
    return subType;
  }

  public String getFromAccount() {
    return fromAccount;
  }

  public String getToAccount() {
    return toAccount;
  }

  public String getValue() {
    return value;
  }

  public String getTime() {
    return time;
  }

  public String getDeviceType() {
    return deviceType;
  }
}
