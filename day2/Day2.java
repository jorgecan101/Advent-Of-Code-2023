package day2;

import java.io.FileNotFoundException;

public class Day2 {
    public static void main (String args[]) {

        try {
            Day2Part1 pt1 = new Day2Part1();
            pt1.solvePart1();

            Day2Part2 pt2 = new Day2Part2();
            pt2.solvePart2();
        } catch (FileNotFoundException e) {
            System.err.println(e.toString());
        }
    }
}