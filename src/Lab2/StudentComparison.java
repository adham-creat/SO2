
/*---------------------------------------------------------
//LAB 2
// Task 5: Object Comparison and Equality
// Author : Aditya Rakesh Kakadia (2868381), Adham Selo (2811093)
*/

package Lab2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

// 1. Helper class at the top
class Student {
    private int studentID;
    private String name;
    private double grade;

    public Student(int studentID, String name, double grade) {
        this.studentID = studentID;
        this.name = name;
        this.grade = grade;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        Student s = (Student) obj;
        return this.studentID == s.studentID && this.name.equals(s.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentID, name);
    }

    @Override
    public String toString() {
        return studentID + " - " + name + " (" + grade + ")";
    }
}

// 2. Main class at the bottom (Must match the file name: StudentComparison.java)
public class StudentComparison {
    public static void main(String[] args) {
        // create an array of student objects with sample data
        Student[] students = {
                new Student(1, "Omar", 95),
                new Student(2, "Rama", 82),
                new Student(3, "Sophia", 81),
                new Student(1, "Omar", 95) // duplicate student
        };

        // demonstrate equality check using equals method
        System.out.println("Is student 0 equal to student 3? " + students[0].equals(students[3]));

        // sort students by grade in descending order using comparator
        Arrays.sort(students, Comparator.comparingDouble(Student::getGrade).reversed());
        System.out.println("\nSorted by grade (descending):");
        System.out.println(Arrays.toString(students));

        // sort students by name alphabetically
        Arrays.sort(students, Comparator.comparing(Student::getName));
        System.out.println("\nSorted by name:");
        System.out.println(Arrays.toString(students));

        // find and display duplicate students by comparing each pair
        System.out.println("\nDuplicate students:");
        for (int i = 0; i < students.length; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].equals(students[j])) {
                    System.out.println("Duplicate found: " + students[i]);
                }
            }
        }

        // searching functionality using user input
        Scanner sc = new Scanner(System.in);

        // search by student id
        System.out.print("\nSearch by ID: ");
        int searchID = sc.nextInt();
        sc.nextLine(); // consume newline
        Student resultID = searchStudentByID(students, searchID);
        System.out.println(resultID != null ? "Found: " + resultID : "ID not found.");

        // search by student name
        System.out.print("Search by name: ");
        String searchName = sc.nextLine();
        Student resultName = searchStudentByName(students, searchName);
        System.out.println(resultName != null ? "Found: " + resultName : "Name not found.");

        sc.close();
    }

    // method to search student by id
    public static Student searchStudentByID(Student[] students, int id) {
        for (Student s : students) {
            if (s.getStudentID() == id) {
                return s;
            }
        }
        return null;
    }

    // method to search student by name (case-insensitive)
    public static Student searchStudentByName(Student[] students, String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }
}