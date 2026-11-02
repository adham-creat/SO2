public class DigitSum {
    int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        DigitSum utils = new DigitSum();
        int result = utils.sumOfDigits(123);
        System.out.println(result); // Prints: 6
    }
}