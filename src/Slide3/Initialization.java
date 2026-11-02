class Student1 {
    String name = "Unknown";
    int matrNumber;
    int enrolledYear = 2019;
}

public class Initialization {
    public static void main(String[] args) {
        Student1 lena = new Student1();

        System.out.println("Name: " + lena.name);
        System.out.println("Number: " + lena.matrNumber);
        System.out.println("Enrolled: " + lena.enrolledYear);

        lena.name = "Lena";
        System.out.println("Name: " + lena.name);
    }
}