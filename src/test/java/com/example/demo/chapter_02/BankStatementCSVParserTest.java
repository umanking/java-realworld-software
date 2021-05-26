package com.example.demo.chapter_02;

import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BankStatementCSVParserTest {

    private final BankStatementParser bankStatementParser = new BankStatementCSVParser();

    @Test
    void 한줄만_파싱하기() {
        // Given
        String line = "30-01-2017,-100,Deliveroo";

        // When
        BankTransaction expectedBankTransaction = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -100, "Deliveroo");
        BankTransaction actualBankTransaction = bankStatementParser.parseFrom(line);

        // Then
        Assertions.assertEquals(actualBankTransaction, expectedBankTransaction);
    }
}