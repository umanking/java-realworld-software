package com.example.demo.chapter_04;

import java.util.Map;

public class Document {

    private final Map<String, String> attributes;

    public Document(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }
}
