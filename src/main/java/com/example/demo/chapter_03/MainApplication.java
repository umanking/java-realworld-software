package com.example.demo.chapter_03;

import java.io.IOException;

public class MainApplication {

    public static void main(String[] args) throws IOException {
        BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        bankStatementAnalyzer.analyze("file", new BankStatementCSVParser());
    }

}
