package com.github.netudima.jmeter.junit.report;

import java.io.IOException;

public class Main {
    public static void main(String ... args) throws IOException {
        if (args.length < 2) {
            System.out.println("please provide at least 2 arguments: " +
                    "   jtlFileToRead jUnitReportFileToWrite [testSuiteName]");
        }
        String jtlFileToRead = args[0];
        String jUnitReportFileToWrite = args[1];
        String testSuiteName = (args.length >= 3) ? args[2] : null;
        JtlToJUnitReportTransformer transformer = new JtlToJUnitReportTransformer();
        if (testSuiteName != null) {
            transformer.transform(jtlFileToRead, jUnitReportFileToWrite, testSuiteName);
        } else {
            transformer.transform(jtlFileToRead, jUnitReportFileToWrite);
        }
    }
}
