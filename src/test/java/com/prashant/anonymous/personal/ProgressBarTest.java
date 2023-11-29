package com.prashant.anonymous.personal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProgressBarTest {

    private ProgressBar progressBar;

    @BeforeEach
    void setUp() {
        progressBar = new ProgressBar();
    }

    @Test
    void showProgressBar() {
        progressBar.showProgressBar();
    }
}