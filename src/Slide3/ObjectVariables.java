// Student.java class definition
class Student {
    String name;
    int matrNumber;
    int enrolledYear;
}

// Main class to run the program
public class ObjectVariables {
    public static void main(String[] args) {
        // 1. Create a new Student object
        Student lena = new Student();

        // 2. Print default value of enrolledYear (outputs 0)
        System.out.println("Enrolled: " + lena.enrolledYear);

        // 3. Assign values using the dot operator
        lena.name = "Lena";
        lena.matrNumber = 591753;
        lena.enrolledYear = 2012;

        // 4. Print updated value of enrolledYear (outputs 2012)
        System.out.println("Enrolled: " + lena.enrolledYear);
    }
}