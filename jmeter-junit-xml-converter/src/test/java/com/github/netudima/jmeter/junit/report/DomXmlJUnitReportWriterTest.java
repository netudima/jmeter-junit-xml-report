package com.github.netudima.jmeter.junit.report;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class DomXmlJUnitReportWriterTest {

    @Rule
    public TemporaryFolder tmpFolder = new TemporaryFolder();

    @Test
    public void test() throws IOException {
        tmpFolder.create();
        File output = tmpFolder.newFile("test.xml");

        try(DomXmlJUnitReportWriter surefireWriter = new DomXmlJUnitReportWriter(output, "defaultTestSuite")) {

            surefireWriter.write(new JtlRecord(
                            "Success sample",
                            true,
                            "Response Message", null
                    )
            );
            surefireWriter.write(new JtlRecord(
                            "Assertion failure",
                            false,
                            "OK", "Value expected to be 'SUCCESS', but found 'FAILED'"
                    )
            );
            surefireWriter.write(new JtlRecord(
                            "Sample error",
                            false,
                            "Non HTTP response message", null
                    )
            );
}
        assertThat(output).hasSameContentAs(TestUtils.getTestFile("/DomXmlJUnitReportWriterTest.xml"));

    }

}