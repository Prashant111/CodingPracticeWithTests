package org.example.practice.string_operation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WildcardExpressionTest {
    private WildcardExpression wildcardExpression;

    @BeforeEach
    void setUp() {
        wildcardExpression = new WildcardExpression();
    }

    @Test
    void expressionMatching() {
        assertTrue(wildcardExpression.expressionMatching("", ""));
    }

    @Test
    void expressionMatching2() {
        assertFalse(wildcardExpression.expressionMatching("aa", "a"));
    }

    @Test
    void expressionMatching3() {
        assertTrue(wildcardExpression.expressionMatching("aab", "c*a*b"));
    }
}