package homework;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPractice {
    private String[] readString(String[] strings) {
        String regex = "^[а-яА-ЯёЁa-zA-Z]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(String.join(" ", strings));
        if (!matcher.find()) {
            throw new WrongInputException("You should enter either Cyrillic or Latin letters");
        }
        return strings;
    }

    private String findUniqueCharactersStringBuilder(String[] strings) {
        String joinedString = String.join("", strings);
        String repeatedSymbols = findRepeatedSymbols(joinedString);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < joinedString.length(); i++) {
            char current = joinedString.charAt(i);
           if (!repeatedSymbols.contains(String.valueOf(current))) {
               result.append(current);
           }
        }
        if (result.length() == 0) {
            throw new AbsentUniqueSymbolsException("Unique symbols are absent");
        }
        return result.toString();
    }

    private String findRepeatedSymbols(String joinedString) {
        StringBuilder repeatedSymbols = new StringBuilder();
        for (int i = 0; i < joinedString.length(); i++) {
            for (int j = i + 1; j < joinedString.length(); j++) {
                char current = joinedString.charAt(j);
                if (joinedString.charAt(i) == current) {
                    repeatedSymbols.append(current);
                    break;
                }
            }
        }
        return repeatedSymbols.toString();
    }

    public void displayOutput(String[] strings) {
        String[] result = readString(strings);
        System.out.println("You entered : " + Arrays.toString(result));
        System.out.println("Number of arguments: " + result.length);
        System.out.println("Unique symbols: " + findUniqueCharactersStringBuilder(strings));
    }
}
