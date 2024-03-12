package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2Part2 {
    public void solvePart2() throws FileNotFoundException {
        // what is the fewest number of cubes of each color that could be possible

        File file = new File("C:\\Users\\jorge\\Desktop\\Programming\\AoC\\2023\\day2\\input.txt");
        Scanner s = new Scanner(file);

        // value to be summed
        int sum = 0;

        while (s.hasNextLine()) {
            String currLine = s.nextLine();
            // Parse text based on semicolons ; keep game number as potential value to add
            String parsedStrings[] = currLine.split(";");
            String tmpStr[] = parsedStrings[0].split(":");
            parsedStrings[0] = tmpStr[1];
            int currGameBlue = 0;
            int currGameRed = 0;
            int currGameGreen = 0;
            for (String i : parsedStrings) {
                String innerStrParsed[] = i.split(", ");
                for (String j : innerStrParsed) {
                    int singleVal = Integer.valueOf(j.replaceAll("[^\\d]", ""));
                    if (j.contains("green") && singleVal > currGameGreen) {
                        currGameGreen = singleVal;
                    }
                    if (j.contains("red") && singleVal > currGameRed) {
                        currGameRed = singleVal;
                    }
                    if (j.contains("blue") && singleVal > currGameBlue) {
                        currGameBlue = singleVal;
                    }
                }
            }

            sum = sum + (currGameBlue * currGameGreen * currGameRed);
        }
        System.out.println("Result: " + sum);
        s.close();
    }
}
