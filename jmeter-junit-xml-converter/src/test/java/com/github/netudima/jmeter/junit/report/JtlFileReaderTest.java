package com.github.netudima.jmeter.junit.report;

import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class JtlFileReaderTest {

    @Test
    public void testParseCsvJtl() throws Exception {
        JtlFileReader jtlFileReader = new JtlFileReader();
        JtlRecordProcessor processor = mock(JtlRecordProcessor.class);
        jtlFileReader.parseCsvJtl(TestUtils.getTestFilePath("/csv_with_failures.jtl"), processor);
        verify(processor, times(5)).process(any(JtlRecord.class));
        verify(processor, times(1)).process(new JtlRecord(
                "Failed response assert",
                false,
                "Internal Server Error",
                "Value expected to be 'SUCCESS', but found 'FAILED'"
        ));
    }
}