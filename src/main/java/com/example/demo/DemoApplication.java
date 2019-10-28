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

//            GetAllMoviesResponse response1 = movieClient.getAllMoviesResponse();
//            List<Movie> allmovies = response1.getMovie();
//            System.err.println("\n\n==============ALL MOVIES==============\n");
//            for(Movie movie1 : allmovies){
//                System.err.println(
//                        "Movie Name: "+movie1.getName()+
//                                "\n Movie's Actor(s): "+movie1.getActor()+
//                                "\n Movie's Capital: "+movie1.getCapital()+
//                                "\n Movie's Category: "+movie1.getCategory()+
//                                "\n Year Released: "+movie1.getYearReleased()+"\n"
//                );
//            }

        };


    }

}
