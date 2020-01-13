package com.db.awmd.challenge.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class Account {

  @NotNull
  @NotEmpty
  private String accountId;
  
  @NotNull
  @NotEmpty
  private String creditAccountId;
  
  @NotNull(message = "Maturity amount is required")
  @Min(value=1, message="must be equal or greater than 1")  
  //@Max(value=10000000, message="must be equal or less than 10000000")  
  long amount;

  @NotNull
  @Min(value = 0, message = "Initial balance must be positive.")
  private BigDecimal balance;

  public Account(String accountId) {
    this.accountId = accountId;
    this.balance = BigDecimal.ZERO;
  }

  @JsonCreator
  public Account(@JsonProperty("accountId") String accountId,
    @JsonProperty("balance") BigDecimal balance) {
    this.accountId = accountId;
    this.balance = balance;
  }

  public String getAccountId() {
    return accountId;
  }

  public String getCreditAccountId() {
    return creditAccountId;
  }

  public void setCreditAccountId(String creditAccountId) {
    this.creditAccountId = creditAccountId;
  }

  public long getAmount() {
    return amount;
  }

  public void setAmount(long amount) {
    this.amount = amount;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }
}
