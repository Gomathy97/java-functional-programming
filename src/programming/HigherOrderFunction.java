package programming;

import java.util.function.Predicate;

//Function that returns a function
public class HigherOrderFunction {

    public static void main(String[] args){
        Predicate<Course> reviewGT95 = getReviewScorePredicate(95);
        Predicate<Course> reviewGT90 = getReviewScorePredicate(90);
    }

    //HigherOrderFunction
    private static Predicate<Course> getReviewScorePredicate(int reviewScore) {
        return course -> course.getReviewScore() > reviewScore;
    }
}
