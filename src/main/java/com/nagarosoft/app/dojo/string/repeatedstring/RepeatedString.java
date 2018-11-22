package com.nagarosoft.app.dojo.string.repeatedstring;

/**
 *  Repeated Strings
 *
 *  <a href="https://www.hackerrank.com/challenges/repeated-string/problem?h_r=internal-search"> Repeated Strings</a>
 *
 */
public class RepeatedString {

    static long repeatedString(String string, long times) {
        if(string == null || string.isEmpty()) return 0L;

        if(!string.contains("a")) return 0L;

        long remainder = times % string.length();
        long repetitions = times / string.length();

        long timesOfA = timesOfAIn(string) * repetitions;

        timesOfA += timesOfAIn(string.substring(0, Long.valueOf(remainder).intValue()));

        return timesOfA;
    }

    private static long timesOfAIn(String string) {
        return string.chars().filter(it -> it == 'a').count();
    }
}
