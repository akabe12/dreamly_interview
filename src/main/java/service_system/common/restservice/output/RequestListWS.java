package main.java.service_system.common.restservice.output;

import main.java.service_system.common.hibernate.Request;

import java.util.ArrayList;
import java.util.List;

/**
 * Serializable class to transfer requests as a list through a REST call.
 *
 * Created by skeane on 3/12/2023.
 */
public class RequestListWS {

    private final List<Request> requests = new ArrayList<>();

    public RequestListWS(List<Request> requestList) {
        this.requests.addAll(requestList);
    }

    public List<Request> getRecords() {
        return requests;
    }

}
