package programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StringStreams {

    public static void main(String[] args){
        List<String> courses = Arrays.asList("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        //Print all courses
        System.out.println("Print all courses");
        courses.stream()
                .forEach(System.out::println);

        //Print courses containing the word Spring
        System.out.println("Print courses containing the word Spring");
        courses.stream()
                .filter(course -> course.contains("Spring"))
                .forEach(System.out::println);

        //Print courses whose length is >= 4
        System.out.println("Print courses whose length is >= 4");
        courses.stream()
                .filter(course -> course.length() >= 4)
                .forEach(System.out::println);

        //Print number of characters in each course
        System.out.println("Print number of characters in each course");
        courses.stream()
                .mapToInt(course -> course.length())
                .forEach(System.out::println);

        //Print courses in sorted order
        System.out.println("Print courses in sorted order");
        courses.stream()
                .sorted()
                .forEach(System.out::println);

        //Custom sorting
        System.out.println("Print courses in sorted order");
        courses.stream()
//                .sorted(Comparator.reverseOrder()) //Print in reverse order
                .sorted(Comparator.comparing(course -> course.length()))// sort based on length
                .forEach(System.out::println);

        //List containing the length of the courses
        System.out.println("List containing the length of the courses");
        System.out.println(courses.stream().map(course -> course.length()).collect(Collectors.toList()));

        //Modifications on the List
        List<String> duplicate_courses = new ArrayList<>(courses);

        //Convert to UpperCase
        duplicate_courses.replaceAll(course -> course.toUpperCase());
        System.out.println(duplicate_courses);

        //remove elements based on criteria
        duplicate_courses.removeIf(course -> course.length() <= 5);
        System.out.println(duplicate_courses);
    }
}
