package FinalExamOldExams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String textToCheck = scanner.nextLine();
        long coolThreshold = 1;

        String regexEmoji = "(?<prefix>[:*]{2})(?<emoji>[A-Z][a-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regexEmoji);
        Matcher matcher = pattern.matcher(textToCheck);
        List<String> coolEmojiList = new ArrayList<>();
        List<String> allEmojiList = new ArrayList<>();

        for (int i = 0; i < textToCheck.length(); i++) {
            char currentChar = textToCheck.charAt(i);

            if((int)currentChar <= 57 && (int) currentChar >= 48){

                int numberFromChar = Character.getNumericValue(currentChar);
                coolThreshold *= numberFromChar;
            }
        }

        while (matcher.find()){

            String emoji = matcher.group("emoji");
            String prefix = matcher.group("prefix");
            StringBuilder wholeEmojiName = new StringBuilder(prefix);
            wholeEmojiName.append(emoji).append(prefix);
            long sumEmojiChars = 0;
            allEmojiList.add(wholeEmojiName.toString());

            for (int i = 0; i < emoji.length(); i++) {
                char currentEmojiChar = emoji.charAt(i);
                sumEmojiChars += currentEmojiChar;
            }
            if(sumEmojiChars >= coolThreshold){
                coolEmojiList.add(wholeEmojiName.toString());
            }
        }

        System.out.printf("Cool threshold: %d%n", coolThreshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", allEmojiList.size());

        for(String coolEmoji : coolEmojiList){
            System.out.println(coolEmoji);
        }
    }
}