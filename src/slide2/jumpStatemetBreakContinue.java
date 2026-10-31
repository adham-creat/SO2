package slide2;

public class jumpStatemetBreakContinue {
    public static void main(String[] args) {
        System.out.println("break  " );
        for (int i = 0; i < 5; i++) { // Middle part is now a boolean (i < 10)
            if (i == 2) {                  // Uses equality operator (==)
                break;
            }
            System.out.println("i = " + i);
        }
        System.out.println("continue  " );

        for (int i = 0; i < 5; i++) { // Middle part is now a boolean (i < 10)
            if (i == 2) {                  // Uses equality operator (==)
                continue;
            }
            System.out.println("i = " + i);
        }
    }
}