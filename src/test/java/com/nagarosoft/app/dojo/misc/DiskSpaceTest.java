package com.nagarosoft.app.dojo.misc;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

public class DiskSpaceTest {

    @Test
    void test1() {
        assertTrue(DiskSpace.isWritable(1, 1, new HashSet<>()));
    }

    @Test void test2() {
        assertFalse(DiskSpace.isWritable(1, 1, new HashSet<>(Arrays.asList(1))));
    }

    @Test void test3() {
        assertTrue(DiskSpace.isWritable(4, 2, new HashSet<>(Arrays.asList(1, 4))));
    }

    @Test void test4() {
        assertTrue(DiskSpace.isWritable(1_00, 11, new HashSet<>(Arrays.asList(10, 20, 30, 70, 80, 90))));
    }

    @Test void test5() {
        assertTrue(DiskSpace.isWritable(5, 1, new HashSet<>(Arrays.asList(1, 2, 3, 4))));
    }

    @Test void test6() {
        assertTrue(DiskSpace.isWritable(5, 1, new HashSet<>(Arrays.asList(2, 3, 4, 5))));
    }

    @Test void test7() {
        assertTrue(DiskSpace.isWritable(10, 9, new HashSet<>(Arrays.asList(1))));
    }

}
