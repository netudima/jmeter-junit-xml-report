package com.github.netudima.jmeter.junit.report;

import java.io.File;

public class TestUtils {
    public static String getTestFilePath(String file) {
        return TestUtils.class.getResource(file).getFile();
    }

    public static File getTestFile(String file) {
            return new File(getTestFilePath(file));
        }
}
