package ru.netology.creditapplicationservice.model;

public enum CreditStatus {
    PROCESSING("PROCESSING"),
    APPROVED("APPROVED"),
    REJECTED("REJECTED");
    private String code;

    CreditStatus(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
