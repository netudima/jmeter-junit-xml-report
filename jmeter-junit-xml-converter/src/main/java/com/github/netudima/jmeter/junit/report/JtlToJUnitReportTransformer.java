package com.github.netudima.jmeter.junit.report;

import java.io.IOException;

public class JtlToJUnitReportTransformer {

    public void transform(String jtlFile, String junitReportFile, String testSuiteName) throws IOException {
        try (final DomXmlJUnitReportWriter writer
                     = new DomXmlJUnitReportWriter(junitReportFile, testSuiteName)) {
            JtlFileReader reader = new JtlFileReader();
            reader.parseCsvJtl(jtlFile, new JtlRecordProcessor() {
                @Override
                public void process(JtlRecord jtlRecord) {
                    writer.write(jtlRecord);
                }
            });
        }
    }

    public void transform(String jtlFile, String junitReportFile) throws IOException {
        transform(jtlFile, junitReportFile, "");
    }
}
