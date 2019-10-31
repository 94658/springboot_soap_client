package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WebClientConfig {

@Bean
public Jaxb2Marshaller marshaller(){
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    //Note! this package must match the package in the <generatePackage>
    marshaller.setContextPath("localhost._7050.universities");
    return marshaller;
}

 @Bean
public Client quoteClient(Jaxb2Marshaller marshaller) {
    Client client = new Client();
    client.setDefaultUri("http://localhost:7050/universities");
    client.setMarshaller(marshaller);
    client.setUnmarshaller(marshaller);
    return client;
    }


}
