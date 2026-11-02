import java.util.Scanner;

/**
 * Task 1: Name Management System (everything in ONE file).
 *
 * Platform independence: Java source code is compiled ONCE into bytecode
 * (.class files). The bytecode runs on any system that has a JVM
 * (Windows, Linux, macOS, ...) without recompiling.
 *
 * Note: a .java file may contain several classes, but only ONE of them
 * can be "public" and it must have the same name as the file (Main).
 */

/**
 * Person class: stores a person's name and the date of the last name change.
 * The date is stored separately as day, month and year (as required by the task).
 */
class Person {

    // Attributes (private = encapsulation, only accessible through methods)
    private String firstName;
    private String lastName;
    private int changeDay;    // day of the last name change
    private int changeMonth;  // month of the last name change
    private int changeYear;   // year of the last name change

    /**
     * Constructor: creates a person with a starting name and the date
     * when this name became valid.
     */
    public Person(String firstName, String lastName,
                  int changeDay, int changeMonth, int changeYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.changeDay = changeDay;
        this.changeMonth = changeMonth;
        this.changeYear = changeYear;
    }

    /**
     * Checks the three-year rule: the new date must be at least
     * 3 years after the date of the last name change.
     *
     * Idea: shift the old date by 3 years and compare year -> month -> day.
     *
     * @return true if the name may be changed on the given date
     */
    public boolean canChangeName(int day, int month, int year) {
        int allowedYear = changeYear + 3; // earliest allowed year (same day and month)

        if (year != allowedYear) {
            return year > allowedYear;    // later year = OK, earlier year = not OK
        }
        if (month != changeMonth) {
            return month > changeMonth;   // same year: compare month
        }
        return day >= changeDay;          // same year and month: compare day
    }

    /**
     * Changes the name and stores the new change date.
     * Only call this after canChangeName(...) returned true.
     */
    public void changeName(String newFirstName, String newLastName,
                           int day, int month, int year) {
        this.firstName = newFirstName;
        this.lastName = newLastName;
        this.changeDay = day;
        this.changeMonth = month;
        this.changeYear = year;
    }

    /** Returns all attributes as readable text (used for printing). */
    @Override
    public String toString() {
        return "First name: " + firstName
                + ", Last name: " + lastName
                + ", Name valid since: " + changeDay + "." + changeMonth + "." + changeYear;
    }
}

/**
 * Main class: contains the program with the menu loop.
 */
public class nameManagementSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 1) Hamburg greeting for "Good day!"
        System.out.println("Moin!");

        // 2) Create three Person objects with starting data
        //    (name + date when this name became valid)
        Person person_1 = new Person("Anna", "Schmidt", 15, 3, 2020);
        Person person_2 = new Person("Ben", "Meyer", 1, 6, 2021);
        Person person_3 = new Person("Clara", "Fischer", 20, 9, 2022);

        int choice = -1; // menu choice

        // 3) Menu loop: repeat until the user enters 0
        while (choice != 0) {

            System.out.println();
            System.out.println("Which person wants to change their name?");
            System.out.println("1, 2 or 3 = person | 4 = show all | 0 = exit");
            System.out.print("Your choice: ");
            choice = readInt(scanner);

            if (choice == 0) {
                // Exit
                System.out.println("Program terminated. Tschüss!");

            } else if (choice == 4) {
                // Show the attributes of all objects
                System.out.println("Person 1 -> " + person_1);
                System.out.println("Person 2 -> " + person_2);
                System.out.println("Person 3 -> " + person_3);

            } else if (choice >= 1 && choice <= 3) {
                // Select the chosen person
                Person selected;
                if (choice == 1) {
                    selected = person_1;
                } else if (choice == 2) {
                    selected = person_2;
                } else {
                    selected = person_3;
                }

                // Ask for the new data
                System.out.print("New first name: ");
                String newFirstName = scanner.nextLine();
                System.out.print("New last name: ");
                String newLastName = scanner.nextLine();
                System.out.print("Valid from - day: ");
                int day = readInt(scanner);
                System.out.print("Valid from - month: ");
                int month = readInt(scanner);
                System.out.print("Valid from - year: ");
                int year = readInt(scanner);

                // Check the three-year rule
                if (selected.canChangeName(day, month, year)) {
                    selected.changeName(newFirstName, newLastName, day, month, year);
                    System.out.println("Name changed successfully!");
                    System.out.println("Person " + choice + " -> " + selected);
                } else {
                    // Not successful: error message, program continues
                    System.out.println("Error: A name can only be changed every 3 years!");
                }

            } else {
                System.out.println("Invalid choice. Please enter 0, 1, 2, 3 or 4.");
            }
        }

        scanner.close();
    }

    /**
     * Helper method: reads a whole line and converts it to int.
     * Using nextLine() everywhere avoids the well-known Scanner problem
     * where nextInt() leaves the line break in the buffer and the next
     * nextLine() returns an empty string.
     * (As allowed by the task, inputs are assumed to be valid numbers.)
     */
    private static int readInt(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine().trim());
    }
}
