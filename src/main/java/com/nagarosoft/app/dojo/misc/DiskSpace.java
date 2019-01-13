package com.nagarosoft.app.dojo.misc;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Problem statement
 * You've been assigned to a task force aiming to develop a new generation of hard disk drives.
 * One of the key components you will work on, is responsible for storing the data on the drive.
 *
 * We need of a function that can determine if a certain file
 * can be stored in given a disk block in one chunk. In order to tell that there must be at least fileSize number of contiguous free disk sectors in a given block.
 *
 * You are given Set<Integer> occupiedSectors where each element is a sector between 1 and blockSize that is already occupied by some other data.
 * The sectors are free to be written to otherwise.
 *
 * Return a boolean stating if it is possible to store the file in the given block.
 *
 * Although it is an early experimental development phase, please keep in mind that, it is undesired
 * to have the so-far-excellent disk performance degraded by way-too-slow isWritable method execution.
 *
 *
 * Input
 * Method signature:
 *
 * boolean isWritable(int blockSize, int fileSize, Set<Integer> occupiedSectors)
 *
 * Constraints:
 *
 * <code>blockSize</code> will be between 1 and 1,000,000, inclusive.
 * fileSize will be between 1 and blockSize, inclusive.
 * occupiedSectors will contain between 1 and 100,000 elements, inclusive.
 * Each element of occupiedSectors will be between 1 and blockSize, inclusive.
 * Elements of occupiedSectors will be distinct.
 * Expected execution time is below 10 seconds.
 * Output
 * A boolean result telling if it is possible to store the file on a given disk block.
 */
public class DiskSpace {

    public static boolean isWritable(int blockSize, int fileSize, Set<Integer> occupiedSectors) {
        if(fileSize > blockSize) return false;

        if(fileSize > blockSize - occupiedSectors.size()) return false;

        if(occupiedSectors.isEmpty()) return true;

        int previous;
        int distance;

        List<Integer> occupiedSectorsOrdered = occupiedSectors.stream().sorted().collect(Collectors.toList());

        Iterator<Integer> iterator = occupiedSectorsOrdered.iterator();

        if (!occupiedSectorsOrdered.contains(1) || occupiedSectorsOrdered.size() == 1)
            previous = 0;
        else
            previous = -1;

        while (iterator.hasNext()) {

            if(previous == -1) {
                previous = iterator.next();
                continue;
            }

            int current = iterator.next();

            distance = current - previous - 1;

            if(!iterator.hasNext() && current != blockSize) {
                distance = blockSize - current;
            }


            if(distance >= fileSize)
                return true;
            else {
                previous = current;
            }
        }

        return false;
    }
}