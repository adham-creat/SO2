import java.util.Scanner;

/**
 * Task 3: Roman Numeral Converter.
 * Converts a Roman numeral (e.g. "MCMXCIV") into an integer (e.g. 1994).
 */
public class RomanConverter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 1) Ask the user for a Roman numeral
        System.out.print("Enter a Roman numeral: ");
        String roman = scanner.nextLine().trim().toUpperCase(); // allow lower case input too

        // 2) Convert it
        int result = romanToInt(roman);

        // 3) Display the result
        System.out.println(roman + " = " + result);

        scanner.close();
    }

    /**
     * Converts a Roman numeral string into an integer.
     *
     * Rule: go through the string from left to right.
     *  - If the current symbol is SMALLER than the next one -> subtract it (e.g. the I in IV)
     *  - Otherwise -> add it
     */
    public static int romanToInt(String roman) {

        int total = 0;

        // Process the string character by character
        for (int i = 0; i < roman.length(); i++) {

            int current = getValue(roman.charAt(i));

            // Is there a next character, and is it bigger than the current one?
            if (i < roman.length() - 1) {
                int next = getValue(roman.charAt(i + 1));

                if (current < next) {
                    total -= current; // subtraction case (IV, IX, XL, XC, CD, CM)
                } else {
                    total += current; // normal addition case
                }
            } else {
                // Last character: nothing comes after it, so always add
                total += current;
            }
        }

        return total;
    }

    /**
     * Returns the value of a single Roman numeral symbol.
     * Returns 0 for any character that is not a Roman symbol.
     */
    public static int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default:  return 0;
        }
    }
}
