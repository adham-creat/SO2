package Slide1;

public class ComparisonOperators {
    public static void main(String[] args) {
        int a = 7, b = 4;
         boolean parentheses = (a > b)  == (a <=b);
        boolean priorities = a > b == a <= b;
        boolean not3 = a != b;
        boolean not31 = a == b;

        System.out.println(parentheses);
        System.out.println(priorities);
        System.out.println(not3);
        System.out.println(not31);

    }

}