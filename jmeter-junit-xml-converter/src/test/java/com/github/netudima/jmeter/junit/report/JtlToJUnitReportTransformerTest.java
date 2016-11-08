package com.github.netudima.jmeter.junit.report;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class JtlToJUnitReportTransformerTest {

    @Rule
    public TemporaryFolder tmpFolder = new TemporaryFolder();

    @Test
    public void testTransform() throws Exception {
        JtlToJUnitReportTransformer transformer = new JtlToJUnitReportTransformer();
        transformer.transform(
                TestUtils.getTestFilePath("/test.jtl"),
                //tmpFolder.newFile("test.xml").getAbsolutePath()
                "./target/text.xml"
        );
    }
}