package day1;

import java.io.FileNotFoundException;

public class Day1 {
    public static void main(String args[]) {
        // Read from file
        // get string from file
        // iterate through start and end of str at same time meeting at middle
        // stop once number is found & combine number str into new str
        // add up numbers at the end

        try {
            Day1Part1 pt1 = new Day1Part1();
            pt1.solvePart1();

            Day1Part2 pt2 = new Day1Part2();
            pt2.solvePart2();
        } catch (FileNotFoundException e) {
            System.err.println(e.toString());
        }
    }
}