package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day1Part1 {

    public void solvePart1() throws FileNotFoundException {
        File file = new File("C:\\Users\\jorge\\Desktop\\Programming\\AoC\\2023\\day1\\input.txt");
            Scanner s = new Scanner(file);
            Map<String, Integer> numberSet = new HashMap<>();
            numberSet.put("one", 1);
            numberSet.put("two", 2);
            numberSet.put("three", 3);
            numberSet.put("four", 4);
            numberSet.put("five", 5);
            numberSet.put("six", 6);
            numberSet.put("seven", 7);
            numberSet.put("eight", 8);
            numberSet.put("nine", 9);
            numberSet.put("zero", 0);

            Map<String, Integer> numberSet2 = new HashMap<>();
            numberSet2.put("eno", 1);
            numberSet2.put("owt", 2);
            numberSet2.put("eerht", 3);
            numberSet2.put("ruof", 4);
            numberSet2.put("evif", 5);
            numberSet2.put("xis", 6);
            numberSet2.put("neves", 7);
            numberSet2.put("thgie", 8);
            numberSet2.put("enin", 9);
            numberSet2.put("orez", 0);

            int res = 0;
            while (s.hasNextLine()) {

                String curLine = s.nextLine();
                int i = 0;
                int j = curLine.length() - 1;

                // xtwone3four
               
                while (!Character.isDigit(curLine.charAt(i))) {
                    i++;
                }
                while (!Character.isDigit(curLine.charAt(j))) {
                    j--;
                }
                String tempNum = String.valueOf(curLine.charAt(i)) + String.valueOf(curLine.charAt(j));
                res = res + Integer.valueOf(tempNum);
            }
            s.close();
            System.out.println("End Result: " + res);
    }
    
}
