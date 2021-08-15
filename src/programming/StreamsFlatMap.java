package programming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsFlatMap {
    public static void main(String[] args){
        List<String> courses = Arrays.asList("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        //Space separated Joins
        System.out.println("Space separated Joins \n" + courses.stream().collect(Collectors.joining(" ")));

        //Comma separated Joins
        System.out.println("Space separated Joins \n" + courses.stream().collect(Collectors.joining(", ")));

        //Split each character to list
        //FlatMap -- each element of Stream replaced with content of the mapped stream
        //Stream of strings
        System.out.println("FlatMap -- each element of Stream replaced with content of the mapped stream");
        System.out.println(courses.stream()
                .map(course -> course.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList()));
    }
}
