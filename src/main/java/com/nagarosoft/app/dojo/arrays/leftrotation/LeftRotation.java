package com.nagarosoft.app.dojo.arrays.leftrotation;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * Taken from hackerrank
 *
 * A left rotation operation on an array shifts each of the array's elements  unit to the left. For example, if  left rotations are performed on array , then the array would become .
 *
 * @see <a href="https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays">Hacker rank</a>
 */
public class LeftRotation {


    public int[] rotate(int[] array, int times) {
        if(times < 0) throw new IllegalArgumentException("times must be grater than zero");

        if(times == 0 || times == array.length) return array;

        LinkedList<Integer> arrayLinked =  new LinkedList<>(Arrays.stream(array).boxed().collect(Collectors.toList()));

        for(int i = 0; i < times; i++) {
            arrayLinked.addLast(arrayLinked.pop());
        }

        return arrayLinked.stream().mapToInt(i->i).toArray();
    }

}
