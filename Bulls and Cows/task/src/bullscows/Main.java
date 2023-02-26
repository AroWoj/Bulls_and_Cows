package bullscows;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {


    public static boolean checkEquity(String secretCode, String inCode) {
        int bulls = 0;
        int cows = 0;

        String none = "Grade: None.";
        String state = none;

        for (int i = 0; i < secretCode.length(); i++) {
            for (int j = 0; j < secretCode.length(); j++) {
                boolean isEq = secretCode.charAt(i) == inCode.charAt(j);
                if (isEq) {
                    if (i == j) bulls++;
                    else cows++;
                }

            }
        }

        if (bulls == 0 && cows != 0) state = String.format("Grade: %d cow(s).", cows);
        else if (bulls == 0 && cows == 0) state = none;
        else if (bulls != 0 && cows != 0) state = String.format("Grade: %d bull(s) and %d cow(s).", bulls, cows);
        else if (bulls != 0 && cows == 0) state = String.format("Grade: %d bulls(s).", bulls);


        System.out.println(state);
        return bulls != secretCode.length();
    }

    public static int generateInt() {
//        long pseudoRandomNumber = System.nanoTime();
//        String str = String.valueOf(pseudoRandomNumber);
//        int digit = Character.getNumericValue(str.charAt(str.length()-3));
        Random rand = new Random();
        return rand.nextInt(10);
    }

    public static char generateSymbol(int range) {
//        long pseudoRandomNumber = System.nanoTime();
//        String str = String.valueOf(pseudoRandomNumber);
//        int digit = Character.getNumericValue(str.charAt(str.length()-3));
        char[] codeTab = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        Random rand = new Random();
        int randomIdx = rand.nextInt(range);
        return codeTab[randomIdx];
    }

    public static void playGame(int keyLength, int range) {
        char[] codeTab = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        if (keyLength > 36 || keyLength < 1) {
            System.out.printf("Error. can't generate a secret with a length of %d because there aren't enough unique digits.", keyLength);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("The secret is prepared: ");
            for (int i = 0; i < keyLength; i++) sb.append('*');
            if (range <= 10) {
                sb.append(" (0-9).");
            } else {
                sb.append(" (0-9, ");
                if (range == 11) sb.append("a");
                if (range > 11) sb.append("a-");
                sb.append(codeTab[range - 1]);
                sb.append(").");
            }
            System.out.println(sb);
            System.out.println("Okay, let's start a game!");
        }
    }

    public static String generateSecretCode(int keyLength, int range) {
        char[] secretCode = new char[keyLength];
        char generatedValue;
        boolean isRepeated = false;

        for (int j = 0; j < keyLength; j++)
            do {
                generatedValue = generateSymbol(range);
                secretCode[j] = generatedValue;
                if (j == 0) {
                    isRepeated = generatedValue == 0;
                } else
                    for (int i = 0; i < j; i++) {
                        isRepeated = generatedValue == secretCode[i];
                        if (isRepeated) break;
                    }
            } while (isRepeated);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keyLength; i++) sb.append(secretCode[i]);
        return sb.toString();
    }

    public static void main(String[] args) {

        int secretCodeLength;
        int rangeOfSymbols;
        boolean isSecretCodeAndRangeCorrect = true;


        Scanner sc = new Scanner(System.in);
        System.out.print("Input the length of the secret code:\n");
        String secretCodeStr = sc.next();


        if (!secretCodeStr.matches("\\d+")) {
            System.out.printf("Error: %s isn't a valid number.\n", secretCodeStr);
            exit(0);
        }

        secretCodeLength = Integer.parseInt(secretCodeStr);

        if (secretCodeLength > 36 || secretCodeLength < 1) {
            System.out.println("Error: maximum length of secret code can not exceed 36.");
            exit(0);
        }

        System.out.println("Input the number of possible symbols in the code:");
        String rangeOfSymbolsStr = sc.next();


        if (!rangeOfSymbolsStr.matches("\\d+")) {
            System.out.printf("Error: %s isn't a valid number.\n", rangeOfSymbolsStr);
            exit(0);
        }

        rangeOfSymbols = Integer.parseInt(rangeOfSymbolsStr);
        if (rangeOfSymbols > 36 || rangeOfSymbols < 2) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            exit(0);
        }


        if (secretCodeLength > rangeOfSymbols) {
            System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols.", secretCodeLength, rangeOfSymbols);
            exit(0);
        }

        String secretCode = generateSecretCode(secretCodeLength, rangeOfSymbols);

        playGame(secretCodeLength, rangeOfSymbols);


        //System.out.println("Secretcode is: " + secretCode);
        int turnNo = 1;
        boolean isContinued;
        do {
            System.out.println("Turn:" + turnNo++);
            String inCode = sc.next();
            isContinued = checkEquity(secretCode, inCode);
        } while (isContinued);
        System.out.print("Congratulations! You guessed the secret code.");

    }
}

    