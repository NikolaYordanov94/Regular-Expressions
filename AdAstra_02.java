package FinalExamOldExams;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String inputText  = scanner.nextLine();
        String textForCal = inputText;

        String regex = "([|\\|#])(?<foodName>[a-zA-Z\\s]+)\\1(?<expirationDate>[0-3][0-9]\\/[0-3][0-9]\\/[0-9][0-9])\\1(?<calories>[0-9]{1,5})\\1";
        String regexCal = "([|\\|#])(?<caloriesForCal>[0-9]{1,5})\\1";
        int totalCaloriesOfFood = 0;
        int daysYouCanLast = 0;

        Pattern pattern = Pattern.compile(regex);
        Pattern patternCal = Pattern.compile(regexCal);
        Matcher matcher = pattern.matcher(inputText);
        Matcher matcherCal = patternCal.matcher(textForCal);

        while (matcherCal.find()){

            int caloriesOfCurrentFood = Integer.parseInt(matcherCal.group("caloriesForCal"));
            if (caloriesOfCurrentFood >= 0 && caloriesOfCurrentFood <= 10000) {
                totalCaloriesOfFood += caloriesOfCurrentFood;
            }
        }

        daysYouCanLast = totalCaloriesOfFood / 2000;

        System.out.printf("You have food to last you for: %d days!%n", daysYouCanLast);

        while (matcher.find()){
            String nameOfFood = matcher.group("foodName");
            String dateOfExpiration  = matcher.group("expirationDate");
            int caloriesOfCurrentFood = Integer.parseInt(matcher.group("calories"));

            if (caloriesOfCurrentFood >= 0 && caloriesOfCurrentFood <= 10000) {
                System.out.printf("Item: %s, Best before: %s, Nutrition: %d%n", nameOfFood, dateOfExpiration, caloriesOfCurrentFood);
            }
            
        }
    }
}
