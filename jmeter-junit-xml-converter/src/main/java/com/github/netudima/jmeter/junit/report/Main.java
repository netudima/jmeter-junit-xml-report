package com.github.netudima.jmeter.junit.report;

import java.io.IOException;

public class Main {
    public static void main(String ... args) throws IOException {
        if (args.length != 2) {
            System.out.println("please provide 2 arguments: jtlFileToRead jUnitReportFileToWrite");
        }
        String jtlFileToRead = args[0];
        String jUnitReportFileToWrite = args[1];
        JtlToJUnitReportTransformer transformer = new JtlToJUnitReportTransformer();
        transformer.transform(jtlFileToRead, jUnitReportFileToWrite);
    }
}
