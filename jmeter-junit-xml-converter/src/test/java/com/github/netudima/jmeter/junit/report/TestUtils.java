package com.github.netudima.jmeter.junit.report;

public class TestUtils {
    public static String getTestFilePath(String file) {
        return TestUtils.class.getResource(file).getFile();
    }
}
