package com.github.netudima.jmeter.junit.report;

public class JtlRecord {
    private final String label;
    private final boolean success;
    private final String failureMessage;

    public JtlRecord(String label, boolean success, String failureMessage) {
        this.label = label;
        this.success = success;
        this.failureMessage = failureMessage;
    }

    public String getLabel() {
        return label;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getFailureMessage() {
        return failureMessage;
    }
}
