package com.example.demo;

import localhost._7050.universities.GetAllUniversitiesResponse;
import localhost._7050.universities.GetUniversityResponse;
import localhost._7050.universities.University;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(Client universityClient){
        return args -> {
            String universityname = "Strathmore";
            if(args.length>0){
                universityname = args[0];
            }

            GetUniversityResponse response = universityClient.getUniversity(universityname);
            University university = response.getUniversity();
            System.err.println(
                    "University Name: "+university.getName()+
                            "\n University's Location: "+university.getLocation()+
                            "\n University year founded: "+university.getYearFounded()
            );

            GetAllUniversitiesResponse response1 = universityClient.getAllUniversities();
            List<University> universities = response1.getUniversity();
            System.err.println("\n\n==============ALL UNIVERSITIES==============\n");
            for(University university1 : universities){
                System.err.println(
                        "University Name: "+university1.getName()+
                                "\n University's Location: "+university1.getLocation()+
                                "\n University year founded: "+university1.getYearFounded()
                );
            }

        };


    }

}
