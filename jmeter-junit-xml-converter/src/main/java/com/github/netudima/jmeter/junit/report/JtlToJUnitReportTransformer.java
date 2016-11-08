package com.github.netudima.jmeter.junit.report;

import java.io.IOException;

public class JtlToJUnitReportTransformer {

    public void transform(String jtlFile, String junitReportFile) throws IOException {
        try (final DomXmlJUnitReportWriter writer
                     = new DomXmlJUnitReportWriter(junitReportFile, jtlFile)) {
            JtlFileReader reader = new JtlFileReader();
            reader.parseCsvJtl(jtlFile, new JtlRecordProcessor() {
                @Override
                public void process(JtlRecord jtlRecord) {
                    writer.write(jtlRecord);
                }
            });
        }
    }
}
