package com.example.demo.chapter_02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSVParser implements BankStatementParser {

    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public List<BankTransaction> parseLinesFrom(List<String> lines) {
        List<BankTransaction> result = new ArrayList<>();
        for (String line : lines) {
            result.add(parseFrom(line));
        }

        return result;
    }

    public BankTransaction parseFrom(String line) {
        String[] columns = line.split(",");
        LocalDate localDate = LocalDate.parse(columns[0], DATE_PATTERN);
        double amount = Double.parseDouble(columns[1]);
        String description = columns[2];
        return new BankTransaction(localDate, amount, description);
    }

}
