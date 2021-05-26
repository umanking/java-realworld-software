package com.example.demo.chapter_03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {

    private static final String RESOURCES = "src/main/resources/file.csv";

    public void analyze(String fileName, BankStatementParser bankStatementParser) throws IOException {
        Path path = Paths.get(RESOURCES);
        List<String> lines = Files.readAllLines(path);

        List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);
    }

    public static void collectSummary(BankStatementProcessor bankStatementProcessor) {
        System.out.println("all transaction total amount is " + bankStatementProcessor.calculateTotalAmount());

        System.out.println("transaction in January" + bankStatementProcessor.selectInMonth(Month.JANUARY));

        System.out.println("transaction in February" + bankStatementProcessor.selectInMonth(Month.FEBRUARY));

        System.out.println("the total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));

    }

}
