package com.github.netudima.jmeter.junit.report;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;

public class DomXmlJUnitReportWriterTest {

    @Rule
    public TemporaryFolder tmpFolder = new TemporaryFolder();

    @Test
    public void test() throws IOException {
        tmpFolder.create();
        try(DomXmlJUnitReportWriter surefireWriter =
                new DomXmlJUnitReportWriter(tmpFolder.getRoot() + "/" + "test.xml", "default test suite")) {
            surefireWriter.write(new JtlRecord(
                            "Remove directory config source directory:policy-assignments using Java API",
                            true,
                            null
                    )
            );

            surefireWriter.write(new JtlRecord(
                            "Retrieve config source directory:assign9145979183351985501.xml using REST API",
                            false,
                            "Test failed: text expected to equal /\n" +
                                    "\n" +
                                    "****** received  : [[[ConfigSource is not registered: directory:assign9145979183351985501.xml                                ]]]\n" +
                                    "\n" +
                                    "****** comparison: [[[<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                                    "<object id=\"9145979183351985501\">\n" +
                                    "    <polic...]]]\n" +
                                    "\n" +
                                    "/"
                    )
            );
        }
    }

}