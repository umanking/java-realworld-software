package com.example.demo.chapter_05;

import java.util.List;

public class BusinessRuleEngine {

    private final List<Action> actions;

    public BusinessRuleEngine(List<Action> actions) {
        this.actions = actions;
    }

    public void addAction(Action action) {
        actions.add(action);
    }

    public int count() {
        return actions.size();
    }

    public void run() {
        this.actions.forEach(Action::execute);
    }
}
