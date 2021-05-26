package com.example.demo.chapter_02;

import java.util.List;

public interface BankStatementParser {

    List<BankTransaction> parseLinesFrom(List<String> lines);

    BankTransaction parseFrom(String line);

}
