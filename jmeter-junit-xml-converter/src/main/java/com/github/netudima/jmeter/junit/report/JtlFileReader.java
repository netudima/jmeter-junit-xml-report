package com.github.netudima.jmeter.junit.report;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class JtlFileReader {
    public enum JMeterJtlHeader {
        timeStamp,
        elapsed,
        label,
        responseCode,
        responseMessage,
        threadName,
        dataType,
        success,
        failureMessage,
        bytes,
        grpThreads,
        allThreads,
        latency,
        IdleTime
    }

    public void parseCsvJtl(String path, JtlRecordProcessor recordProcessor) throws IOException {
        try (Reader in = new FileReader(path)) {
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
            for (CSVRecord record : records) {
                String label = record.get(JMeterJtlHeader.label);
                boolean success = Boolean.parseBoolean(record.get(JMeterJtlHeader.success));
                String failureMessage = record.get(JMeterJtlHeader.failureMessage);
                String responseMessage = record.get(JMeterJtlHeader.responseMessage);
                recordProcessor.process(new JtlRecord(label, success, responseMessage, failureMessage));
            }
        }

    }
}
