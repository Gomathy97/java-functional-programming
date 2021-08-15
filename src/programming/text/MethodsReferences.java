package programming.text;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class MethodsReferences {

    public static void main(String[] args){
        List<String> courses = Arrays.asList("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        courses.stream()
                .map(String::toUpperCase) //Static reference
                .forEach(System.out::println); //Method Reference

        Supplier<String> supplier = String::new; //Constructor reference
        String s = supplier.get();
        System.out.println(s);
    }
}
