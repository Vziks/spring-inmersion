package info.vziks.api.test;

import java.util.StringJoiner;

/**
 * Class StringJoin
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
public class StringJoin {

    public static void main(String[] args) {

        String str = "We are Java";
        StringJoiner stringJoiner = new StringJoiner(" ");
        stringJoiner.add("We");
        stringJoiner.add("are");
        stringJoiner.add("Java");


        System.out.println(str.equals(stringJoiner.toString()));
        System.out.println(str.equals(stringJoiner));
    }
}
