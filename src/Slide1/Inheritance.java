package Slide1;

public class Inheritance {

        public static void main(String[] args) {
            // Create an object of the Dog class
            Dog myDog = new Dog();

            // Call the inherited method from Animal
            myDog.eat();

            // Call the method from Dog
            myDog.bark();
        }
    }


    class Animal {
        public void eat() {
            System.out.println("Eating...");
        }
    }

    class Dog extends Animal { // Dog inherits from Animal
        public void bark() {
            System.out.println("Barking...");
        }
    }

