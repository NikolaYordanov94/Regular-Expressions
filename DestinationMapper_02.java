package ExamPreparationPart2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String places = scanner.nextLine();

        Pattern pattern = Pattern.compile("([=|\\/])(?<destination>[A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(places);

        List<String> destinationsList = new ArrayList<>();
        int travelPoints = 0;

        while (matcher.find()){
            String destination = matcher.group("destination");
            destinationsList.add(destination);
            travelPoints += destination.length();
        }
        System.out.print("Destinations: ");
        System.out.println(String.join(", ", destinationsList));
        System.out.printf("Travel Points: %d", travelPoints);

    }
}
