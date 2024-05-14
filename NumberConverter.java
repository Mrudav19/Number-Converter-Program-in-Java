import java.util.Scanner;

public class NumberConverter {
    private String stringRepresentation;
    private double doubleRepresentation;

    public NumberConverter(String num) {
        if (num == null || num.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty.");
        }

        if (num.startsWith("-")) {
            this.stringRepresentation = num.toLowerCase();
            this.doubleRepresentation = -1 * convertToDouble(num.substring(1));
        } else {
            this.stringRepresentation = num.toLowerCase();
            this.doubleRepresentation = convertToDouble(num);
        }
    }

    public NumberConverter(double num) {
        this.doubleRepresentation = num;
        if (num < 0) {
            this.stringRepresentation = "-" + convertToString(-1 * num).toLowerCase();
        } else {
            this.stringRepresentation = convertToString(num).toLowerCase();
        }
    }

    private double convertToDouble(String input) {
        double accumulator = 0;
        String[] parts = input.split("\\.");
        int len = parts[0].length();

        for (int i = 0; i < len; i++) {
            char c = parts[0].charAt(i);
            int baseValue = Character.toLowerCase(c) - 'a';
            accumulator += baseValue * Math.pow(26, len - (i + 1));
        }

        if (parts.length > 1) {
            len = parts[1].length();
            for (int i = 0; i < len; i++) {
                char c = parts[1].charAt(i);
                int baseValue = Character.toLowerCase(c) - 'a';
                accumulator += baseValue * Math.pow(26, -(i + 1));
            }
        }
        return accumulator;
    }

    private String convertToString(double input) {
        StringBuilder result = new StringBuilder();
        int intPart = (int) input;

        if (intPart == 0) {
            result.append("A");
        }

        while (intPart > 0) {
            int digit = intPart % 26;
            char hexDigit = (char) ('A' + digit);
            result.insert(0, hexDigit);
            intPart /= 26;
        }

        if (input != (int) input) {
            result.append(".");
            double decimalPart = input - (int) input;
            int decimalCount = 0;

            while (decimalPart > 0 && decimalCount < 10) {
                decimalPart *= 26;
                int digit = (int) decimalPart;
                char hexDigit = (char) ('A' + digit);
                result.append(hexDigit);
                decimalPart -= (int) decimalPart;
                decimalCount++;
            }
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return stringRepresentation + " (" + doubleRepresentation + ")";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option: Enter 'h' to convert from Hexiacosadecimal to Decimal, 'd' to convert from Decimal to Hexiacosadecimal, or 'q' to quit:");
            String input = scanner.next();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("Thank you for using the Number Converter. Goodbye!");
                break;
            } else if (input.equalsIgnoreCase("h")) {
                System.out.println("Please enter your hexiacosadecimal number: ");
                String hexNum = scanner.next();
                try {
                    NumberConverter num = new NumberConverter(hexNum);
                    System.out.println("Decimal representation: " + num);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid input. Please try again.");
                }
            } else if (input.equalsIgnoreCase("d")) {
                System.out.println("Please enter your decimal number: ");
                try {
                    double decNum = scanner.nextDouble();
                    NumberConverter num = new NumberConverter(decNum);
                    System.out.println("Hexiacosadecimal representation: " + num);
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid decimal number.");
                    scanner.nextLine(); 
                }
            } else {
                System.out.println("INVALID INPUT");
            }
        }

        scanner.close();
    }
}
