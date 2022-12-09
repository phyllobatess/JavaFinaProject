package com.ironhack.FinalProject.models.DTO;

import java.math.BigDecimal;

public class ThirdPartyTransferenceDto {
    private Long accountId;
    private String secretKey;
    private BigDecimal amount;

    public ThirdPartyTransferenceDto(Long accountId, String secretKey, BigDecimal amount) {
        this.accountId = accountId;
        this.secretKey = secretKey;
        this.amount = amount;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
