package main.java.service_system.common.restservice;

import java.util.ArrayList;
import java.util.List;

/**
 * Serializable class to transfer request record information as a list through a REST call.
 *
 * Created by skeane on 3/12/2023.
 */
public class RequestRecordListWS {

    private final List<RequestRecordWS> records = new ArrayList<>();

    public RequestRecordListWS(List<RequestRecordWS> recordWSList) {
        this.records.addAll(recordWSList);
    }

    public List<RequestRecordWS> getRecords() {
        return records;
    }
}
