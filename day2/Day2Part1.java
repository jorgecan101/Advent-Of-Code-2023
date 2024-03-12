package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Day2Part1 {
    public void solvePart1() throws FileNotFoundException {
        // Based on 12 RED, 13 GREEN, 14 BLUE , what games are possible?

        File file = new File("C:\\Users\\jorge\\Desktop\\Programming\\AoC\\2023\\day2\\input.txt");
        Scanner s = new Scanner(file);

        HashMap<String, String> possibleChoices = new HashMap<>();
        possibleChoices.put("red", "12");
        possibleChoices.put("green", "13");
        possibleChoices.put("blue", "14");

        // value to be summed
        int sum = 0;

        while (s.hasNextLine()) {
            String currLine = s.nextLine();
            // Parse text based on semicolons ; keep game number as potential value to add
            String parsedStrings[] = currLine.split(";");
            String tmpStr[] = parsedStrings[0].split(":");
            parsedStrings[0] = tmpStr[1];
            boolean isValid = true;

            for (String i : parsedStrings) {
                // System.out.println(i);
                String innerStrParsed[] = i.split(", ");
                for (String j : innerStrParsed) {
                    int singleVal = Integer.valueOf(j.replaceAll("[^\\d]", ""));
                    // System.out.println(j +  " and singleVal: " + singleVal);
                    if (j.contains("green") && singleVal > Integer.valueOf(possibleChoices.get("green"))) {
                        // failed so we can just skip
                        isValid = false;
                        break;
                    }
                    else if (j.contains("red") && singleVal > Integer.valueOf(possibleChoices.get("red"))) {
                        // failed so we can just skip
                        isValid = false;
                        break;
                    }
                    else if (j.contains("blue") && singleVal > Integer.valueOf(possibleChoices.get("blue"))) {
                        // failed so we can just skip
                        isValid = false;
                        break;
                    }
                }
            }
            if (isValid) {
                // Add to the sum
                String formattedGameStr = tmpStr[0].replaceAll("[^\\d]", "");
                sum = sum + Integer.valueOf(formattedGameStr);
                // System.out.println(formattedGameStr + " and sum: " + sum);
            } 
        }
        System.out.println("Result: " + sum);
        s.close();
    }
}
