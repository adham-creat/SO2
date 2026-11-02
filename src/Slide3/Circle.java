 public class Circle {
     double x, y;
     double radius;

     // Full constructor
     public Circle(double x, double y, double radius) {
         this.x = x;
         this.y = y;
         this.radius = radius;
     }

     // Default constructor (delegates to the full constructor)
     Circle() {
         this(0.0, 0.0, 1.0);
     }

     // Constructor with radius only (delegates)
     Circle(double radius) {
         this(0.0, 0.0, radius);
     }

     // Copy constructor (copies the fields of another Circle object)
     Circle(Circle circle) {
         this(circle.x, circle.y, circle.radius);
     }


     // Display method to show circle details on the screen
     public void display() {
         System.out.println("Circle -> x: " + x + ", y: " + y + ", Radius: " + radius);
     }


     public static void main(String[] args) {
         Circle circle1 = new Circle();
         Circle circle2 = new Circle(2.5);
         Circle circle3 = new Circle(circle2);
         Circle circle4 = new Circle(-1.2, 7.1, 3.0);

         System.out.println("Circle 1:");
         circle1.display();

         System.out.println("Circle 2:");
         circle2.display();

         System.out.println("Circle 3 (Kopie von Circle 2):");
         circle3.display();

         System.out.println("Circle 4:");
         circle4.display();
     }

 }