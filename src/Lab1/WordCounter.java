import java.util.Scanner;

/**
 * Task 6: Word Counter Program.
 * Analyzes a sentence or paragraph and prints statistics about
 * characters, words, sentences, vowels, consonants and the longest word.
 */
public class WordCounter {

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
