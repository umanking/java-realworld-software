package com.example.demo.chapter_03;

public class HtmlExporter implements Exporter {

    @Override
    public String export(SummaryStatistics summaryStatistics) {
        String result = "<!doctype html>";
        result += "</html>";

        return result;
    }
}
