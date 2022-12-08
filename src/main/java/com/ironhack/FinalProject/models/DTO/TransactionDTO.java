package com.ironhack.FinalProject.models.DTO;

import java.math.BigDecimal;

public class TransactionDTO {
    private BigDecimal amount;
    private Long destinyAccountId;
    private Long originAccountId;
    private String recipientName;


    public TransactionDTO(BigDecimal balance, Long destinyAccountId, Long originAccountId, String recipientName) {
        this.amount = balance;
        this.destinyAccountId = destinyAccountId;
        this.originAccountId = originAccountId;
        this.recipientName = recipientName;
    }



    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getDestinyAccountId() {
        return destinyAccountId;
    }

    public void setDestinyAccountId(Long destinyAccountId) {
        this.destinyAccountId = destinyAccountId;
    }

    public Long getOriginAccountId() {
        return originAccountId;
    }

    public void setOriginAccountId(Long originAccountId) {
        this.originAccountId = originAccountId;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }


}
