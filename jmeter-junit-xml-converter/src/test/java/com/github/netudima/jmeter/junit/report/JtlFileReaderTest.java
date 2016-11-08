package com.github.netudima.jmeter.junit.report;

import org.junit.Test;

public class JtlFileReaderTest {

    @Test
    public void testParseCsvJtl() throws Exception {
        JtlFileReader jtlFileReader = new JtlFileReader();
        jtlFileReader.parseCsvJtl(TestUtils.getTestFilePath("/test.jtl"),
                new JtlRecordProcessor() {
            @Override
            public void process(JtlRecord jtlRecord) {
                System.out.println(jtlRecord.getLabel() + " : " + jtlRecord.isSuccess());
                if (!jtlRecord.isSuccess()) {
                    System.out.println("    failure message: " + jtlRecord.getFailureMessage());
                }
            }
        });
    }
}