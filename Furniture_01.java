package RegularExpressionsExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> furniture = new ArrayList<>();
        double totalSum = 0; //общо изхарчена сума за мебелите


        Pattern pattern = Pattern.compile(">>(?<furnitureName>[A-Za-z]+)<<(?<price>[0-9]+.?[0-9]*)!(?<quantity>[0-9]+)");

        String input = scanner.nextLine();

        while(!input.equals("Purchase")){

            Matcher matcher = pattern.matcher(input);

            if(matcher.find()){
                String furnitureName = matcher.group("furnitureName");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));

                furniture.add(furnitureName);
                double currentFurniture = price * quantity;
                totalSum += currentFurniture;
            }

            input = scanner.nextLine();
        }

        System.out.println("Bought furniture:");
        furniture.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", totalSum);
    }
}
