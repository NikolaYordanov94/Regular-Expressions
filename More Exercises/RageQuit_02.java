package RegularExpressionsMoreExercises;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RageQuit_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String textInput = scanner.nextLine();

        String regex = "(?<letters>[^0-9]+)(?<repetition>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(textInput);
        StringBuilder textResult = new StringBuilder();
        int countUniqueSymbols = 0;
        HashMap<Character, Character> uniqueCharMap = new HashMap<>();

        while(matcher.find()){
            String lettersString = matcher.group("letters").toUpperCase();
            int repetitionNum = Integer.parseInt(matcher.group("repetition"));

            for (int i = 0; i < repetitionNum; i++) {

                textResult.append(lettersString);
            }

            }

        for (int i = 0; i < textResult.length(); i++) {

            char currentChar = textResult.charAt(i);
            uniqueCharMap.put(currentChar, currentChar);
        }

        System.out.printf("Unique symbols used: %d%n", uniqueCharMap.size());
        System.out.println(textResult);
    }
}
