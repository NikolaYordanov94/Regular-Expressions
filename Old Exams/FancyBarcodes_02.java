package FinalExamOldExams;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String textToCheck = scanner.nextLine();
            String regex = "[@][#]+[A-Z][a-zA-Z0-9]+[A-Z][@][#]+";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(textToCheck);

            if(matcher.find()){
                String barcodeGroup = "";
                for (int j = 0; j < textToCheck.length(); j++) {
                    char currentChar = textToCheck.charAt(j);
                    if(((int)currentChar <= 57 && (int) currentChar >= 48)){
                        barcodeGroup += currentChar;
                    }
                }
                if (barcodeGroup.equals("")){
                    System.out.println("Product group: 00");
                }else{
                    System.out.printf("Product group: %s%n", barcodeGroup);
                }

            }else{
                System.out.println("Invalid barcode");
            }
        }
    }
}
