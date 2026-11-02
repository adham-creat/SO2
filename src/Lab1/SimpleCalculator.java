import java.util.Locale;
import java.util.Scanner;

/**
 * Task 5: Simple Calculator with Methods.
 * Menu-driven calculator, one separate method for each arithmetic operation.
 */
public class SimpleCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // Use "." as decimal separator (e.g. 15.5), independent of the computer's language settings
        scanner.useLocale(Locale.US);

        int choice = 0;

        // Loop: allows multiple calculations, ends when the user chooses 5
        while (choice != 5) {

            // 1) Display the menu
            System.out.println("=== Simple Calculator ===");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Exit");
            System.out.print("Choose an operation (1-5): ");

            // 2) Read the selected operation
            choice = scanner.nextInt();

            if (choice == 5) {
                // Exit
                System.out.println("Thank you for using the calculator!");

            } else if (choice >= 1 && choice <= 4) {

                // 3) Ask for the two numbers
                System.out.print("Enter first number: ");
                double a = scanner.nextDouble();
                System.out.print("Enter second number: ");
                double b = scanner.nextDouble();

                // 4) Call the matching method and 5) display the result
                if (choice == 1) {
                    System.out.println("Result: " + a + " + " + b + " = " + add(a, b));
                } else if (choice == 2) {
                    System.out.println("Result: " + a + " - " + b + " = " + subtract(a, b));
                } else if (choice == 3) {
                    System.out.println("Result: " + a + " * " + b + " = " + multiply(a, b));
                } else {
                    // Division: handle division by zero
                    if (b == 0) {
                        System.out.println("Error: Division by zero!");
                    }
                    System.out.println("Result: " + a + " / " + b + " = " + divide(a, b));
                }

            } else {
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }

            System.out.println(); // empty line between two rounds
        }

        scanner.close();
    }

    // ---------- One method per operation (2 parameters, returns the result) ----------

    /** Returns a + b. */
    public static double add(double a, double b) {
        return a + b;
    }

    /** Returns a - b. */
    public static double subtract(double a, double b) {
        return a - b;
    }

    /** Returns a * b. */
    public static double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Returns a / b.
     * Division by zero is handled: instead of crashing or returning "Infinity",
     * the method returns 0.0 (as shown in the sample output of the task).
     */
    public static double divide(double a, double b) {
        if (b == 0) {
            return 0.0;
        }
        return a / b;
    }
}
