package main.java.service_system.common.restservice.output;

import main.java.service_system.common.hibernate.RequestRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Serializable class to transfer request record information as a list through a REST call.
 *
 * Created by skeane on 3/12/2023.
 */
public class RequestRecordListWS {

    private final List<RequestRecord> records = new ArrayList<>();

    public RequestRecordListWS(List<RequestRecord> recordList) {
        this.records.addAll(recordList);
    }

    public List<RequestRecord> getRecords() {
        return records;
    }
}
