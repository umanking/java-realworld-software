package com.example.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BankTransactionAnalyzerSimple {

    private static final String RESOURCES = "src/main/resources/file.csv";

    public static void main(String[] args) throws IOException {

        Path path = Paths.get(RESOURCES);
        List<String> lines = Files.readAllLines(path);
        double total = 0d;
        for (String line : lines) {
            String[] columns = line.split(",");
            double amount = Double.parseDouble(columns[1]);
            total += amount;
        }

        System.out.println("the total for all transaction is " + total);

    }

}
