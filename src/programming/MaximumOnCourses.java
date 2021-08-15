package programming;

import java.util.Arrays;
import java.util.List;

public class MaximumOnCourses {

    public static void main(String[] args){
        List<String> courses = Arrays.asList("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        //Find courses of length 4 and convert it to uppercase and return the first of it
        System.out.println("Find courses of length 11 and convert it to uppercase and return the first of it \n" +
            courses.stream().peek(System.out::println)
                    .filter(course -> course.length() > 11)
                    .map(course -> course.toUpperCase()).peek(System.out::println)
                    .findFirst()
        );
        //Spring
        //Spring Boot
        //API
        //Microservices
        //MICROSERVICES
        //Find courses of length 11 and convert it to uppercase and return the first of it
        //Optional[MICROSERVICES]

        /*
            Reason -- LazyLoad
            Only when the terminal operation is know it executes here findFirst()
         */
    }
}
