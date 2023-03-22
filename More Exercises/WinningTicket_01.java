package RegularExpressionsMoreExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinningTicket_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<String> ticketsList = Arrays.stream(input.split("\\s+,\\s+")).collect(Collectors.toList());

        String regexWinTicket = "[A-Za-z0-9]*(?<sequence>[@|#|$|\\^]{6,})[A-Za-z0-9]*\\1[A-Za-z0-9]*";
        Pattern patternWinTicket = Pattern.compile(regexWinTicket);

        for (int i = 0; i < ticketsList.size(); i++) {
            String currentTicket = ticketsList.get(i);

            Matcher matcherWinTicket = patternWinTicket.matcher(currentTicket);

            if(currentTicket.length() == 20){

                if(matcherWinTicket.find()){

                    String sequence = matcherWinTicket.group("sequence");

                    if(sequence.length() == 10){
                        System.out.printf("ticket \"%s\" - %d%c Jackpot!%n", currentTicket, sequence.length(), sequence.charAt(0));
                    }else{
                        System.out.printf("ticket \"%s\" - %d%c%n", currentTicket, sequence.length(), sequence.charAt(0));
                    }

                }else{
                    System.out.printf("ticket \"%s\" - no match%n", currentTicket);
                }

            }else{
                System.out.println("invalid ticket");
            }
        }
    }
}
