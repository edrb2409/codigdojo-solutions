package com.nagarosoft.app.dojo;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by edrb on 5/12/17.
 */
public class FizzBuzz {

    public static void main(String[] args) {
        System.out.println("[" + IntStream.rangeClosed(1, 100)
                .boxed()
                .map(Helper::convert)
                .collect(Collectors.joining(",")) + "]");
    }

    public static class Helper {

        public static String convert(int number) {
            if(isFizzBuzz(number)) return "FizzBuzz";

            if(isFizz(number)) return "Fizz";

            if(isBuzz(number)) return "Buzz";

            return String.valueOf(number);
        }

        private static boolean isFizz(int number) {
            return number % 3 == 0;
        }

        private static boolean isBuzz(int number) {
            return number % 5 == 0;
        }

        private static boolean isFizzBuzz(int number) {
            return isFizz(number) && isBuzz(number);
        }
    }

}
