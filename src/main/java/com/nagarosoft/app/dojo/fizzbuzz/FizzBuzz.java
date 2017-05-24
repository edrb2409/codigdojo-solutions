package com.nagarosoft.app.dojo.fizzbuzz;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by edrb on 5/12/17.
 */
public class FizzBuzz {

    private int _limit;

   public FizzBuzz limit(int aLimit) {
       _limit = aLimit;
       return this;
   }

   public String print() {
       return "[" + IntStream
               .rangeClosed(1, _limit)
               .boxed()
               .map(Helper::convert)
               .collect(Collectors.joining(",")) + "]";
   }


    public static class Helper {

        public static String convert(int number) {
            if(number == 0) return "0";

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
