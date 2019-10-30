package com.example.demo;

import localhost._7000.universities.GetUniversityResponse;
import localhost._7000.universities.University;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(Client universityClient){
        return args -> {
            String universityname = "Strathmore University";
            if(args.length>0){
                universityname = args[0];
            }

            GetUniversityResponse response = universityClient.getUniversityResponse(universityname);
            University university = response.getUniversity();
            System.err.println(
                    "University Name: "+university.getName()+
                            "\n University's Location: "+university.getLocation()+
                            "\n University year founded: "+university.getYearFounded()
            );

        };


    }

}
