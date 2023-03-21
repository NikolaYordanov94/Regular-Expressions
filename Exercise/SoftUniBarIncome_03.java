package RegularExpressionsExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("[^|$%.]*%(?<name>[A-Z][a-z]+)%[^|$%.]*[<](?<product>[\\w]+)[>][^|$%.]*\\|(?<count>[0-9]+)\\|[^|$%.]*?(?<price>[0-9]+[.]*[0-9]*)[$]");
        double totalPrice = 0.00;
        double totalIncome = 0.00;

        while (!input.equals("end of shift")){

            Matcher matcher = pattern.matcher(input);

            if(matcher.find()){

                String customerName = matcher.group("name");
                String productName = matcher.group("product");
                int quantity = Integer.parseInt(matcher.group("count"));
                double priceOfProduct = Double.parseDouble(matcher.group("price"));

                totalPrice = quantity * priceOfProduct;

                System.out.printf("%s: %s - %.2f%n", customerName, productName, totalPrice);

                totalIncome += totalPrice;
            }

            input = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f", totalIncome);
    }
}
