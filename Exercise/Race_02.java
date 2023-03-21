package RegularExpressionsExercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String names = scanner.nextLine();
        List<String> racersNames = Arrays.stream(names.split(", ")).collect(Collectors.toList());
        //състезател -> дистанция
        Map<String, Integer> racersDistances = new LinkedHashMap<>();
        racersNames.forEach(name -> racersDistances.put(name, 0));
        String input = scanner.nextLine();
        //Regex
        String regexLetters = "[A-Za-z]+";
        Pattern patternLetter = Pattern.compile(regexLetters);
        String regexDigit = "[0-9]";
        Pattern patternDigit = Pattern.compile(regexDigit);
        while (!input.equals("end of race")){
            //име на състезателя -> само от буквите
            StringBuilder nameBuilder = new StringBuilder();
            Matcher matchLetter = patternLetter.matcher(input); //всички букви
            while (matchLetter.find()){
                nameBuilder.append(matchLetter.group());
            }
            //дистанция на състезателя -> сума от цифрите
            int distance = 0;
            Matcher matcherDigit = patternDigit.matcher(input); //всички цифри
            while (matcherDigit.find()){
                distance += Integer.parseInt(matcherDigit.group());
            }

            String racerName = nameBuilder.toString(); //име на състезател

            if(racersDistances.containsKey(racerName)){
                int currentDistance = racersDistances.get(racerName);
                racersDistances.put(racerName, currentDistance + distance);
            }

            input = scanner.nextLine();
        }

        //речник, който съдържа: съзтезател -> премината дистанция

        List<String> nameOfFirstThree = racersDistances.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        System.out.println("1st place: " + nameOfFirstThree.get(0));
        System.out.println("2nd place: " + nameOfFirstThree.get(1));
        System.out.println("3rd place: " + nameOfFirstThree.get(2));
    }
}
