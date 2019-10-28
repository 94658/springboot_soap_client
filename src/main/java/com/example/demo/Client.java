package com.example.demo;

import localhost._7000.universities.GetUniversityRequest;
import localhost._7000.universities.GetUniversityResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class Client extends WebServiceGatewaySupport {

    public GetUniversityResponse getUniversityResponse(String movieName){
        GetUniversityRequest request = new  GetUniversityRequest();
        request.setName(movieName);

        GetUniversityResponse response = (GetUniversityResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:7000/ws",
                        request,
                        new SoapActionCallback("http://localhost:7000/ws"));

        return response;
    }

//    public GetAllUniversitiesResponse  getAllMoviesResponse(){
//        GetAllMoviesRequest request = new GetAllMoviesRequest();
//
//        GetAllMoviesResponse response = (GetAllMoviesResponse) getWebServiceTemplate()
//                .marshalSendAndReceive("http://localhost:8080/ws",
//                        request,
//                        new SoapActionCallback("http://localhost:8080/ws"));
//
//        return response;
//    }

}
