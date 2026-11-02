import java.util.Locale;
import java.util.Scanner;

/**
 * Task 4: Grade Manager.
 * Stores grades of several students in an array, calculates statistics
 * (average, highest, lowest, passed, failed) and prints a grade report.
 */
public class GradeManager {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // Use "." as decimal separator (e.g. 85.5), independent of the computer's language settings.
        // Without this, a German system would expect "85,5" and "85.5" would crash.
        scanner.useLocale(Locale.US);

        // 1) Ask how many students
        System.out.print("How many students do you want to enter grades for? ");
        int numberOfStudents = scanner.nextInt();

        // 2) Create the array that stores the grades
        double[] grades = new double[numberOfStudents];

        // 3) Read each student's grade (0-100)
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("Enter grade for student " + (i + 1) + " (0-100): ");
            grades[i] = scanner.nextDouble();
        }

        // 4) Calculate the statistics
        double sum = 0;
        double highest = grades[0]; // start with the first grade as reference
        double lowest = grades[0];
        int passed = 0;
        int failed = 0;

        for (int i = 0; i < numberOfStudents; i++) {
            sum += grades[i];

            if (grades[i] > highest) {
                highest = grades[i];
            }
            if (grades[i] < lowest) {
                lowest = grades[i];
            }

            if (grades[i] >= 60) {
                passed++;
            } else {
                failed++;
            }
        }

        double average = sum / numberOfStudents;

        // 5) Print the report: each student with numerical and letter grade
        System.out.println();
        System.out.println("=== Grade Report ===");
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.printf(Locale.US, "Student %d: %.1f (%s)%n",
                    i + 1, grades[i], getLetterGrade(grades[i]));
        }

        // Statistics
        System.out.println();
        System.out.println("=== Statistics ===");
        System.out.printf(Locale.US, "Average Grade: %.1f%n", average);
        System.out.printf(Locale.US, "Highest Grade: %.1f%n", highest);
        System.out.printf(Locale.US, "Lowest Grade: %.1f%n", lowest);
        System.out.println("Students Passed: " + passed);
        System.out.println("Students Failed: " + failed);

        scanner.close();
    }

    /**
     * Converts a numerical grade into a letter grade.
     * A: 90-100, B: 80-89, C: 70-79, D: 60-69, F: 0-59
     * (checked from the top, so 89.5 counts as B and 90 as A)
     */
    public static String getLetterGrade(double grade) {
        if (grade >= 90) {
            return "A";
        } else if (grade >= 80) {
            return "B";
        } else if (grade >= 70) {
            return "C";
        } else if (grade >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    /**
     * Task 6: Word Counter Program.
     * Analyzes a sentence or paragraph and prints statistics about
     * characters, words, sentences, vowels, consonants and the longest word.
     */
    public static class WordCounter {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            // 1) Read the text
            System.out.println("Enter a sentence or paragraph to analyze:");
            String text = scanner.nextLine();

            // ---------- Character statistics ----------
            int totalChars = text.length();   // all characters including spaces
            int charsWithoutSpaces = 0;       // all characters except spaces
            int vowelCount = 0;
            int consonantCount = 0;
            int sentenceCount = 0;

            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);

                // Count every character that is not a whitespace (letters, digits, punctuation)
                if (!Character.isWhitespace(c)) {
                    charsWithoutSpaces++;
                }

                // Vowels and consonants: only letters count
                if (Character.isLetter(c)) {
                    if (isVowel(c)) {
                        vowelCount++;
                    } else {
                        consonantCount++;
                    }
                }

                // Sentences: count a sentence end at '.', '!' or '?'.
                // If several follow each other ("?!" or "..."), they count only once:
                // so we only count when the NEXT character is not an end mark.
                if (isSentenceEnd(c)) {
                    boolean lastChar = (i == text.length() - 1);
                    if (lastChar || !isSentenceEnd(text.charAt(i + 1))) {
                        sentenceCount++;
                    }
                }
            }

            // ---------- Word statistics ----------
            int wordCount = 0;
            String longestWord = "";

            String trimmed = text.trim();
            if (!trimmed.isEmpty()) {
                // Split at one or more whitespace characters
                String[] words = trimmed.split("\\s+");
                wordCount = words.length;

                for (String word : words) {
                    String cleaned = removePunctuation(word);
                    // ">" (not ">=") keeps the FIRST word if two words are equally long
                    if (cleaned.length() > longestWord.length()) {
                        longestWord = cleaned;
                    }
                }
            }

            // ---------- Report ----------
            System.out.println();
            System.out.println("=== TEXT ANALYSIS REPORT ===");
            System.out.println();
            System.out.println("Original text: \"" + text + "\"");
            System.out.println();
            System.out.println("Character Statistics:");
            System.out.println("- Total characters (with spaces): " + totalChars);
            System.out.println("- Total characters (without spaces): " + charsWithoutSpaces);
            System.out.println("- Number of vowels: " + vowelCount);
            System.out.println("- Number of consonants: " + consonantCount);
            System.out.println();
            System.out.println("Word Statistics:");
            System.out.println("- Total number of words: " + wordCount);
            System.out.println("- Longest word: \"" + longestWord + "\"");
            System.out.println();
            System.out.println("Sentence Statistics:");
            System.out.println("- Total number of sentences: " + sentenceCount);

            scanner.close();
        }

        /** Returns true if c is a vowel (a, e, i, o, u), upper or lower case. */
        public static boolean isVowel(char c) {
            char lower = Character.toLowerCase(c); // handles uppercase and lowercase
            return lower == 'a' || lower == 'e' || lower == 'i'
                    || lower == 'o' || lower == 'u';
        }

        /** Returns true if c ends a sentence: '.', '!' or '?'. */
        public static boolean isSentenceEnd(char c) {
            return c == '.' || c == '!' || c == '?';
        }

        /** Returns the word without punctuation, e.g. "analysis." becomes "analysis". */
        public static String removePunctuation(String word) {
            String result = "";
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (Character.isLetterOrDigit(c)) {
                    result += c;
                }
            }
            return result;
        }
    }
}
