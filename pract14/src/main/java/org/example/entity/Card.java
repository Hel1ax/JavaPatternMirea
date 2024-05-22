package org.example.entity;

public class Card {
    private String cardNumber;
    private String code;

    public Card() {
    }

    public Card(String cardNumber, String code) {
        this.cardNumber = cardNumber;
        this.code = code;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
