package com.example.demo.chapter_05;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class BusinessRuleEngineTest {

    @Test
    void shouldHaveNoRulesInitially() {
        BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(List.of());

        assertEquals(0, businessRuleEngine.count());

    }

    @Test
    void shouldAddTwoActions() {
        BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(List.of());
        businessRuleEngine.addAction(()-> {});
        businessRuleEngine.addAction(()-> {});

        assertEquals(2, businessRuleEngine.count());
    }

    @Test
    void shouldExecuteOneAction() {
        BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(new ArrayList<>());
        Action mockAction = mock(Action.class);

        businessRuleEngine.addAction(mockAction);
        businessRuleEngine.run();

        verify(mockAction).execute();
    }
}