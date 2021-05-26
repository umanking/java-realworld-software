package com.example.demo.chapter_03;

import java.time.LocalDate;

public class BankStatementValidator {

    private String description;
    private String date;
    private String amount;

    public BankStatementValidator(String description, String date, String amount) {
        this.description = description;
        this.date = date;
        this.amount = amount;
    }

    public Notification validate() {
        Notification notification = new Notification();
        if (this.description.length() > 100) {
            notification.addError("the description is too long");
        }

        LocalDate parsedDate;
        try {
            parsedDate = LocalDate.parse(this.date);
            if (parsedDate.isAfter(LocalDate.now())) {
                notification.addError("date cannot be in the future");
            }
        } catch (Exception e) {
            notification.addError("Invalid format for date");
        }

        double amount;

        try {
            amount = Double.parseDouble(this.amount);
        } catch (NumberFormatException e) {
            notification.addError("Invalid format for amount");
        }
        return notification;
    }

}
