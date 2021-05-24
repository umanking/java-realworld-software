package com.example.demo.chapter_02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Test {

    private static final String RESOURCES = "src/main/resources/file.csv";

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(RESOURCES);
        List<String> list = Files.readAllLines(path);

        BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();
        List<BankTransaction> bankTransactions = bankStatementCSVParser.parseLinesFromCSV(list);

        System.out.println("all transaction total amount is " + calculateTotalAmount(bankTransactions));
        System.out.println("transaction in January" + selectInMonth(bankTransactions, Month.JANUARY));
    }

    public static double calculateTotalAmount(List<BankTransaction> bankTransactions) {
        double total = 0d;
        for (BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public static List<BankTransaction> selectInMonth(List<BankTransaction> bankTransactions, Month month) {
        List<BankTransaction> bankTransactionInMonth = new ArrayList<>();

        for (BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                bankTransactionInMonth.add(bankTransaction);
            }
        }

        return bankTransactionInMonth;
    }

}
