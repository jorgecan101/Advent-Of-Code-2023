package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day1Part2 {

    public void solvePart2() throws FileNotFoundException {
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
            String currLine = s.nextLine();

            String num1 = "";
            String num2 = "";
            String tempStr = "";
            for (int i = 0; i < currLine.length(); i++) {
                // First thing we found was a digit number!
                if (Character.isDigit(currLine.charAt(i))) {
                    num1 = String.valueOf(currLine.charAt(i));
                    break;
                } 
                else {
                    tempStr += currLine.charAt(i);
                    if (numberSet.containsKey(tempStr)) {
                        // Double check this one
                        num1 = String.valueOf(numberSet.get(tempStr));
                        break;
                    }
                    else {
                        // need to figure out if what we're could build into a number
                        if (!canBecomeNumber(tempStr)) {
                            tempStr = String.valueOf(currLine.charAt(i));                         
                        }
                    }
                }
            }

            tempStr = "";
            // Now handle the scenario where we are going backwards
            for (int i = currLine.length() - 1;  i >= 0; i--) {
                // First thing we found was a digit number!
                if (Character.isDigit(currLine.charAt(i))) {
                    num2 = String.valueOf(currLine.charAt(i));
                    break;
                } 
                else {
                    tempStr += currLine.charAt(i);
                    if (numberSet2.containsKey(tempStr)) {
                        num2 = String.valueOf(numberSet2.get(tempStr));
                        break;
                    }
                    else {
                        if (!canBecomeNumberRev(tempStr)) {
                            tempStr = String.valueOf(currLine.charAt(i));                         

                        }
                    }
                }
            }
            res = res + Integer.valueOf(num1 + num2);
        }
        s.close();
        System.out.println("End Result: " + res);
    }

    private boolean canBecomeNumber(String str) {

        // remove edge cases
        if (str.length() >= 5) {
            return false;
        }

        // if length is 1
        if (str.length() == 1) {
            if (str.charAt(0) == 'o' || str.charAt(0) == 't' || str.charAt(0) == 'f' || 
            str.charAt(0) == 's' || str.charAt(0) == 'e' || str.charAt(0) == 'n' || str.charAt(0) == 'z') {
                return true;
            }
        }

        // if length is 2
        if (str.length() == 2) {

            if ((str.charAt(0) == 'o' && str.charAt(1) == 'n') ||
                (str.charAt(0) == 't' && str.charAt(1) == 'w') ||
                (str.charAt(0) == 't' && str.charAt(1) == 'h') ||
                (str.charAt(0) == 'f' && str.charAt(1) == 'o') ||
                (str.charAt(0) == 'f' && str.charAt(1) == 'i') ||
                (str.charAt(0) == 's' && str.charAt(1) == 'i') ||
                (str.charAt(0) == 's' && str.charAt(1) == 'e') ||
                (str.charAt(0) == 'e' && str.charAt(1) == 'i') ||
                (str.charAt(0) == 'n' && str.charAt(1) == 'i') ||
                (str.charAt(0) == 'z' && str.charAt(1) == 'e')) {
                    return true;
            }
        }
        // if length is 3 then we know that it couldn't have been 3 letter numbers
        // do checking for three, four, five, seven, eight, nine, zero
        if (str.length() == 3) {

            if ((str.charAt(0) == 't' && str.charAt(1) == 'h' && str.charAt(2) == 'r') ||
                (str.charAt(0) == 'f' && str.charAt(1) == 'o' && str.charAt(2) == 'u') ||
                (str.charAt(0) == 'f' && str.charAt(1) == 'i' && str.charAt(2) == 'v') ||
                (str.charAt(0) == 's' && str.charAt(1) == 'e' && str.charAt(2) == 'v') ||
                (str.charAt(0) == 'e' && str.charAt(1) == 'i' && str.charAt(2) == 'g') ||
                (str.charAt(0) == 'n' && str.charAt(1) == 'i' && str.charAt(2) == 'n') ||
                (str.charAt(0) == 'z' && str.charAt(1) == 'e' && str.charAt(2) == 'r')) {
                return true;
            }
        }

        // if length is 4 then check for three, seven, and eight
        if (str.length() == 4) {
            if ((str.charAt(0) == 't' && str.charAt(1) == 'h' && str.charAt(2) == 'r' && str.charAt(3) == 'e')
                || (str.charAt(0) == 'e' && str.charAt(1) == 'i' && str.charAt(2) == 'g' && str.charAt(3) == 'h')
                || (str.charAt(0) == 's' && str.charAt(1) == 'e' && str.charAt(2) == 'v' && str.charAt(3) == 'e')) {
                    return true;
            }
        }
        return false;
    }

    private boolean canBecomeNumberRev(String str) {

        // remove edge cases
        if (str.length() >= 5) {
            return false;
        }

        // if length is 1
        if (str.length() == 1) {
            if (str.charAt(0) == 'e' || str.charAt(0) == 'o' || str.charAt(0) == 'r' || 
            str.charAt(0) == 'x' || str.charAt(0) == 'n' || str.charAt(0) == 't') {
                return true;
            }
        }

        // if length is 2
        if (str.length() == 2) {
            if ((str.charAt(0) == 'e' && str.charAt(1) == 'n') ||
                (str.charAt(0) == 'o' && str.charAt(1) == 'w') ||
                (str.charAt(0) == 'e' && str.charAt(1) == 'e') ||
                (str.charAt(0) == 'r' && str.charAt(1) == 'u') ||
                (str.charAt(0) == 'e' && str.charAt(1) == 'v') ||
                (str.charAt(0) == 'x' && str.charAt(1) == 'i') ||
                (str.charAt(0) == 'n' && str.charAt(1) == 'e') ||
                (str.charAt(0) == 't' && str.charAt(1) == 'h') ||
                (str.charAt(0) == 'e' && str.charAt(1) == 'n') ||
                (str.charAt(0) == 'o' && str.charAt(1) == 'r')) {
                    return true;
            }
        }

        // if length is 3 then we know that it couldn't have been 3 letter numbers
        // do checking for three, four, five, seven, eight, nine, zero
        if (str.length() == 3) {
            if ((str.charAt(0) == 'e' && str.charAt(1) == 'e' && str.charAt(2) == 'r') ||
                (str.charAt(0) == 'r' && str.charAt(1) == 'u' && str.charAt(2) == 'o') ||
                (str.charAt(0) == 'e' && str.charAt(1) == 'v' && str.charAt(2) == 'i') ||
                (str.charAt(0) == 'n' && str.charAt(1) == 'e' && str.charAt(2) == 'v') ||
                (str.charAt(0) == 't' && str.charAt(1) == 'h' && str.charAt(2) == 'g') ||
                (str.charAt(0) == 'e' && str.charAt(1) == 'n' && str.charAt(2) == 'i') ||
                (str.charAt(0) == 'o' && str.charAt(1) == 'r' && str.charAt(2) == 'e')) {
                return true;
            }
        }

        // if length is 4 then check for eerht, neves, and thgie
        if (str.length() == 4) {
            if ((str.charAt(0) == 'e' && str.charAt(1) == 'e' && str.charAt(2) == 'r' && str.charAt(3) == 'h')
                || (str.charAt(0) == 'n' && str.charAt(1) == 'e' && str.charAt(2) == 'v' && str.charAt(3) == 'e')
                || (str.charAt(0) == 't' && str.charAt(1) == 'h' && str.charAt(2) == 'g' && str.charAt(3) == 'i')) {
                    return true;
            }
        }
        return false;
    }
}