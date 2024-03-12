package day3;

import java.io.FileNotFoundException;

public class Day3 {
    public static void main(String args[]) {
        try {
            Day3Part1 pt1 = new Day3Part1();
            pt1.solvePart1();

            Day3Part2 pt2 = new Day3Part2();
            pt2.solvePart2();
        } catch (FileNotFoundException e) {
            System.err.println(e.toString());
        }
    }
}