package com.github.netudima.jmeter.junit.report;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

public class JtlToJUnitReportTransformerTest {

    @Rule
    public TemporaryFolder tmpFolder = new TemporaryFolder();

    @Test
    public void testTransform() throws Exception {
        JtlToJUnitReportTransformer transformer = new JtlToJUnitReportTransformer();
        File output = tmpFolder.newFile("test.xml");

        transformer.transform(TestUtils.getTestFilePath("/csv_with_failures.jtl"),
                output.getAbsolutePath(), "testSuiteName");

        assertThat(output).hasSameContentAs(TestUtils.getTestFile("/csv_with_failures_converted.xml"));
    }
}