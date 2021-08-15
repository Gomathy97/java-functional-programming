package programming.text;


public class PossibleErrors {
    private static void improperUsage() {
        /*
            Consumer<String> consumer = () -> {};
            //Coz consumer requires an input argument to process
         */

        /*
            Supplier<String> supplier = () -> {"Gomathy"};
            //inside {} so return statement required --> () -> {return "Gomathy"}
         */

        /*
            BiConsumer<String, String> biConsumer =
                    (s1, s2) -> System.out.println(s1);
                                    System.out.println(s2); // treated as new statement and s2 is not defined

            //More than one statement in lambda expression. This needs to be inside {}
         */
     }
}
