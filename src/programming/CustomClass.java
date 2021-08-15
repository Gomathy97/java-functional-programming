package programming;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course{
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(" : ");
        stringBuilder.append(category);
        stringBuilder.append(" : ");
        stringBuilder.append(reviewScore);
        stringBuilder.append(" : ");
        stringBuilder.append(noOfStudents);
        return stringBuilder.toString();
    }
}
public class CustomClass {

    public static void main(String[] args){
        List<Course> courses = Arrays.asList(
                new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 90, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000)
        );

        Predicate<Course> reviewGT90 = course -> course.getReviewScore() > 90;
        Predicate<Course> reviewLT90 = course -> course.getReviewScore() < 90;
        Predicate<Course> reviewGT95 = course -> course.getReviewScore() > 95;

        /*
            ----------------------
            Match Operators
            ----------------------
         */

        //All Courses with review score > 90
        System.out.println("All Courses with review score > 90 \n" +
                courses.stream()
    //                .filter(course -> course.getReviewScore() >= 90)
                    .allMatch(reviewGT90)
        );
        //false

        //None of the Courses with review score > 90
        System.out.println("None of the Courses with review score > 90 \n" +
                courses.stream()
                    .noneMatch(reviewLT90)
        );
        //true

        //Any course with review score > 95
        System.out.println("Any course with review score > 95 \n" +
                courses.stream()
                        .anyMatch(reviewGT95)
        );
        //true

        /*
            -----------------------------
            Sort comparing operators
            -----------------------------
         */

        //Sort courses based on students in increasing order
        //Comparator<Course> comparingIncreasing = Comparator.comparing(Course::getNoOfStudents);
        Comparator<Course> comparingIncreasing = Comparator.comparingInt(Course::getNoOfStudents); //using primitive comparing to avoid boxing and unboxing
        sortingOnCourses(courses, comparingIncreasing, "Sort courses based on students in increasing order");
        //[FullStack : FullStack : 91 : 14000, Spring Boot : Framework : 95 : 18000, Spring : Framework : 98 : 20000, Docker : Cloud : 92 : 20000,
        // Kubernetes : Cloud : 91 : 20000, AWS : Cloud : 92 : 21000, Azure : Cloud : 90 : 21000, API : Microservices : 97 : 22000,
        // Microservices : Microservices : 96 : 25000]

        //Sort courses based on students in decreasing order
        Comparator<Course> comparingDecreasing = Comparator.comparing(Course::getNoOfStudents).reversed();
        sortingOnCourses(courses, comparingDecreasing, "Sort courses based on students in decreasing order");
        //[Microservices : Microservices : 96 : 25000, API : Microservices : 97 : 22000, AWS : Cloud : 92 : 21000, Azure : Cloud : 90 : 21000,
        // Spring : Framework : 98 : 20000, Docker : Cloud : 92 : 20000, Kubernetes : Cloud : 91 : 20000,
        // Spring Boot : Framework : 95 : 18000, FullStack : FullStack : 91 : 14000]

        //Sort courses based on students and review score in increasing order
        Comparator<Course> comparingStud_ReviewInc = Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore);
        sortingOnCourses(courses, comparingStud_ReviewInc, "Sort courses based on students and review score in increasing order");
        //[FullStack : FullStack : 91 : 14000, Spring Boot : Framework : 95 : 18000, Kubernetes : Cloud : 91 : 20000, Docker : Cloud : 92 : 20000,
        // Spring : Framework : 98 : 20000, Azure : Cloud : 90 : 21000, AWS : Cloud : 92 : 21000, API : Microservices : 97 : 22000,
        // Microservices : Microservices : 96 : 25000]

        //Sort courses based on students and review score in decreasing order
        Comparator<Course> comparingStud_ReviewDec = Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore).reversed();
        sortingOnCourses(courses, comparingStud_ReviewDec, "Sort courses based on students and review score in decreasing order");
        //[Microservices : Microservices : 96 : 25000, API : Microservices : 97 : 22000, AWS : Cloud : 92 : 21000, Azure : Cloud : 90 : 21000,
        // Spring : Framework : 98 : 20000, Docker : Cloud : 92 : 20000, Kubernetes : Cloud : 91 : 20000,
        // Spring Boot : Framework : 95 : 18000, FullStack : FullStack : 91 : 14000]

       /*
            -----------------------------
            Limit and Skip operators
            -----------------------------
        */

        //Sort courses based on students and review score in decreasing order and Pick top 5 courses
        System.out.println("Sort courses based on students and review score in decreasing order and Pick top 5 courses \n" +
                courses.stream()
                        .sorted(comparingStud_ReviewDec)
                        .limit(5)
                        .collect(Collectors.toList())
        );
        //[Microservices : Microservices : 96 : 25000, API : Microservices : 97 : 22000, AWS : Cloud : 92 : 21000, Azure : Cloud : 90 : 21000, Spring : Framework : 98 : 20000]

        //Sort courses based on students and review score in increasing order and skip 3 courses
        System.out.println("Sort courses based on students and review score in increasing order and skip 3 courses \n" +
                courses.stream()
                        .sorted(comparingStud_ReviewInc)
                        .skip(3)
                        .collect(Collectors.toList())
        );
        //[Docker : Cloud : 92 : 20000, Spring : Framework : 98 : 20000, Azure : Cloud : 90 : 21000, AWS : Cloud : 92 : 21000, API : Microservices : 97 : 22000,
        // Microservices : Microservices : 96 : 25000]

        //Sort courses based on students and review score in increasing order and skip 3 courses and pick 5 courses
        System.out.println("Sort courses based on students and review score in increasing order and skip 3 courses and pick 5 courses \n" +
                courses.stream()
                        .sorted(comparingStud_ReviewInc)
                        .skip(3)
                        .limit(5)
                        .collect(Collectors.toList())
        );
        //[Docker : Cloud : 92 : 20000, Spring : Framework : 98 : 20000, Azure : Cloud : 90 : 21000, AWS : Cloud : 92 : 21000, API : Microservices : 97 : 22000]


        /*
            -----------------------------
            Max and Min
            -----------------------------
         */

        //Get the maximum course matching comparingStud_ReviewInc
        System.out.println("Get the maximum course matching comparingStud_ReviewInc \n" +
                courses.stream()
                        .max(comparingStud_ReviewInc)
        );
        //Optional[Microservices : Microservices : 96 : 25000]

        //Get the minimum course matching comparingStud_ReviewInc
        System.out.println("Get the minimum course matching comparingStud_ReviewInc \n" +
                courses.stream()
                        .min(comparingStud_ReviewInc)
        );
        //Optional[FullStack : FullStack : 91 : 14000]

        //Get the minimum course where review is < 90
        System.out.println("Get the minimum course where review is < 90 \n" +
                courses.stream()
                        .filter(course -> course.getReviewScore() < 90)
                        .min(comparingStud_ReviewInc) //Optional.empty -- instead of returning null Optional.empty is returned
        );
        //Optional.empty

        /*
             ------------------------------------------------------
                return default value when nothing is found
             ------------------------------------------------------
         */

        //modifying the above in such a way when there's no min found return some other default course
        System.out.println("modifying the above in such a way when there's no min found return some other default course \n" +
                courses.stream()
                        .filter(reviewLT90)
                        .min(comparingStud_ReviewInc)
                        .orElse(new Course("Spring", "Framework", 98, 20000))
        );
        //Spring : Framework : 98 : 20000

        //return all the courses until the limit is met and skip the rest-- similar to while
        System.out.println("return all the courses until the limit is met -- similar to while \n" +
                courses.stream()
                        .takeWhile(reviewGT95)
                        .collect(Collectors.toList())
        );
        //[Spring : Framework : 98 : 20000]

        //inverse of the above skip all the elements until the criteria is met
        System.out.println("inverse of the above skip all the elements until the criteria is met \n" +
                courses.stream()
                        .dropWhile(reviewGT95)
                        .collect(Collectors.toList())
        );
        //[Spring Boot : Framework : 95 : 18000, API : Microservices : 97 : 22000, Microservices : Microservices : 96 : 25000,
        // FullStack : FullStack : 91 : 14000, AWS : Cloud : 92 : 21000, Azure : Cloud : 90 : 21000, Docker : Cloud : 92 : 20000, Kubernetes : Cloud : 91 : 20000]

        /*
            -----------------------------
                findFirst, findAny
            -----------------------------
         */

        //Find the first element matching the criteria reviewScore > 95
        System.out.println("Find the first element matching the criteria reviewScore > 95\n" +
            courses.stream()
                    .filter(reviewGT95)
                    .findFirst()
        );
        //Optional[Spring : Framework : 98 : 20000]

        //Find any element matching the criteria reviewScore > 95
        System.out.println("Find any element matching the criteria reviewScore > 95\n" +
                courses.stream()
                        .filter(reviewGT95)
                        .findAny()
        );
        //Optional[Spring : Framework : 98 : 20000]

        //Find the first element matching the criteria reviewScore < 90
        System.out.println("Find the first element matching the criteria reviewScore < 90 \n" +
                courses.stream()
                        .filter(reviewLT90)
                        .findFirst()
                        .orElse(new Course("No Match", "null", -1, -1))
        );
        //No Match : null : -1 : -1

        /*
            -----------------------------
            Average, Sum, Count, max
            -----------------------------
         */

        //Find the total on number of students with review > 95
        System.out.println("Find the total onnumber of students with review > 95 \n" +
                courses.stream()
                        .filter(reviewGT95)
                        .mapToInt(Course::getNoOfStudents)
                        .sum()
        );
        //67000

        //Find the number of students with review > 95
        System.out.println("Find the number of students with review > 95 \n" +
                courses.stream()
                        .filter(reviewGT95)
                        .mapToInt(Course::getNoOfStudents)
                        .count()
        );
        //3

        //Find the average on number of students with review > 95
        System.out.println("Find the average on number of students with review > 95 \n" +
                courses.stream()
                        .filter(reviewGT95)
                        .mapToInt(Course::getNoOfStudents)
                        .average()
        );
        //OptionalDouble[22333.333333333332]

        //Find the max on number of students with review > 95
        System.out.println("Find the max on number of students with review > 95 \n" +
                courses.stream()
                        .filter(reviewGT95)
                        .mapToInt(Course::getNoOfStudents)
                        .max()
        );
        //OptionalInt[25000]

        /*
            -----------------------------
            Grouping
            -----------------------------
         */

        //Group courses based on the category
        System.out.println("Group courses based on the category \n" +
            courses.stream()
                    .collect(Collectors.groupingBy(Course::getCategory))
        );
        //{Cloud=[AWS : Cloud : 92 : 21000, Azure : Cloud : 90 : 21000, Docker : Cloud : 92 : 20000, Kubernetes : Cloud : 91 : 20000],
        // FullStack=[FullStack : FullStack : 91 : 14000],
        // Microservices=[API : Microservices : 97 : 22000, Microservices : Microservices : 96 : 25000],
        // Framework=[Spring : Framework : 98 : 20000, Spring Boot : Framework : 95 : 18000]}

        //Group courses based on the category and get the count
        System.out.println("Group courses based on the category and get the count \n" +
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()))
        );
        //{Cloud=4, FullStack=1, Microservices=2, Framework=2}

        //Group courses and get the name alone in that group
        System.out.println("Group courses and get the name alone in that group \n" +
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,
                                Collectors.mapping(Course::getName, Collectors.toList())))
        );
        //{Cloud=[AWS, Azure, Docker, Kubernetes],
        // FullStack=[FullStack],
        // Microservices=[API, Microservices],
        // Framework=[Spring, Spring Boot]}

        //Group courses and get the highest reviewed course in that group
        System.out.println("Group courses and get the highest reviewed course in that group \n" +
            courses.stream()
                    .collect(Collectors.groupingBy(Course::getCategory,
                            Collectors.maxBy(Comparator.comparing(Course::getReviewScore))))
        );
        //{Cloud=Optional[AWS : Cloud : 92 : 21000],
        // FullStack=Optional[FullStack : FullStack : 91 : 14000],
        // Microservices=Optional[API : Microservices : 97 : 22000],
        // Framework=Optional[Spring : Framework : 98 : 20000]}

    }

    private static void sortingOnCourses(List<Course> courses, Comparator<Course> comparingIncreasing, String note) {
        System.out.println(note + "\n" +
                courses.stream()
                        .sorted(comparingIncreasing)
                        .collect(Collectors.toList())
        );
    }

}
