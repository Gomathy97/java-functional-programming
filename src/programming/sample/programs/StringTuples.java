package programming.sample.programs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringTuples {

    private static void tuplesWithSameLength(List<String> courses){
        List<String> courses_copy = List.copyOf(courses);
        System.out.println(courses.stream()
                        .flatMap(course -> courses_copy.stream()
                                .filter(course_2 -> course.length() == course_2.length())
                                .map(course_2 -> List.of(course, course_2)))
                        .filter(list -> !list.get(0).equals(list.get(1)))
                        .collect(Collectors.toList())
        );
    }

    public static void main(String[] args){
        List<String> courses = Arrays.asList("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        tuplesWithSameLength(courses);
    }
}
