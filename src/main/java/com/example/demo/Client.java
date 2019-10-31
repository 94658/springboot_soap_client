package com.example.demo;



import localhost._7050.universities.GetAllUniversitiesRequest;
import localhost._7050.universities.GetAllUniversitiesResponse;
import localhost._7050.universities.GetUniversityRequest;
import localhost._7050.universities.GetUniversityResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class Client extends WebServiceGatewaySupport {

    private static final String ENDPOINT = "http://localhost:7050/ws";

    public GetAllUniversitiesResponse getAllUniversities() {
        GetAllUniversitiesRequest request = new GetAllUniversitiesRequest();

        return (GetAllUniversitiesResponse) getWebServiceTemplate().marshalSendAndReceive(ENDPOINT, request);
    }

    public GetUniversityResponse getUniversity(String name) {
        GetUniversityRequest request = new GetUniversityRequest();
        request.setName(name);

        return (GetUniversityResponse) getWebServiceTemplate().marshalSendAndReceive(ENDPOINT, request);

    }

}
