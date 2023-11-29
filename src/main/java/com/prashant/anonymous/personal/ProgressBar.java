package com.prashant.anonymous.personal;

public class ProgressBar {
    public void showProgressBar() {
        for (int i = 0; i < 101; i++) {
            showProgress(i, 100);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
    }
    public void showProgress(int progress, int total) {
        System.out.printf("[%s%s]%d%%\r",
                          getProgressString('█', (progress * 100) / total),
                          getProgressString('=', ((total - progress) * 100) / total),
                          (progress * 100) / total);
    }

    private String getProgressString(char c, int occurrence) {
        return String.valueOf(c).repeat(occurrence);
    }
}
