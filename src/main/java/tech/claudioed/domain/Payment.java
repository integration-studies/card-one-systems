package tech.claudioed.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Payment {

  private final String id;

  private final BigDecimal amount;

  @JsonFormat(pattern = "EEE, dd MMM yyyy HH:mm:ss")
  private final LocalDateTime approvedAt;

  public Payment(String id, BigDecimal amount, LocalDateTime approvedAt) {
    this.id = id;
    this.amount = amount;
    this.approvedAt = approvedAt;
  }

  public String getId() {
    return id;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public LocalDateTime getApprovedAt() {
    return approvedAt;
  }
}
