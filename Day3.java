// Question 1

// Classes & Objects in Java


// Instructions:

// Write a program that takes input from the user and creates an object of a class named 'Person'. The 'Person' class should have two member variables: 'name' and 'age'. The program should prompt the user to enter their name and age, create a 'Person' object with the entered values, and then display the name and age of the person.

// Sample Input & Output:

// Sample Input:
// John
// 25

// Sample Output:
// Name: John
// Age: 25
// Hints:
// 1. Use the 'Scanner' class to read input from the user.
// 2. Create a class named 'Person' with two member variables: 'name' and 'age'.
// 3. Use the 'new' keyword to create an object of the 'Person' class.
// 4. Use the dot operator to access the member variables of the 'Person' object.
// 5. Print the name and age of the person using the 'System.out.println()' method.

import java.util.Scanner;

public class Person {
    // TODO: Define the 'Person' class with 'name' and 'age' member variables
        String name;
        int age;
    public static void main(String[] args) {
        // TODO: Write your code here
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        int age = sc.nextInt();

        Person p = new Person();
        p.name = name;
        p.age = age;

        System.out.println("Name: " + p.name);
        System.out.println("Age: " + p.age);
    }
}

// Question 2

// Sum of All Numbers
// Find the sum of the digits using recursion



// Input:

// 4246

// Output:

// 16

// Explanation:

// 4+2+4+6 is 16

// Input:

// -32

// Output:

// 5

// Explanation:

// 3+2

// Input value ranges in the range of Integer data type.

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        //write your answer here
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int result = sumOfDigits(number);
        System.out.println(result);
    }
    public static int sumOfDigits(int n){
        if(n==0)
        {
            return 0;
        }
        return (n % 10) + sumOfDigits(n / 10);
    }
}

// Question 3

// Book Class
// Create a Java class named Book to represent a book. The class should have the following features:

// Instance Variables:

// title (String): to store the title of the book.

// author (String): to store the name of the author.

// year (int): to store the publication year of the book.



// Constructors:

// A default constructor that initializes the title, author, and year to default values ("Not specified", "Unknown", and 0, respectively).

// A parameterized constructor that takes values for title, author, and year and initializes the corresponding instance variables.



// Methods: A method named displayInfo that prints the details of the book (title, author, and year).



// Application: In the main method, create two instances of the Book class using both the default constructor and the parameterized constructor.

// Call the displayInfo method on each instance to display the details of the books. Your goal is to implement the Book class with appropriate constructors and methods as described.

// Sample Output:

// Book 1:
// Title: Not specified
// Author: Unknown
// Year: 0


// Book 2:
// Title: "Java Programming"
// Author: "Sakshi"
// Year: 2024

 public class Book{
    String title;
    String author;
    int year;

    Book(){
        title = "Not specified";
        author = "Unknown";
        year = 0;
    }
    Book(String t , String a, int y){
        title = t;
        author = a;
        year = y;
    }
     public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year: " + year);
        System.out.println();
    }
    
   


    public static void main(String[] args) {

        //write your answer here
        System.out.println("Book 1:");
      // call displayInfo();
        Book b1 = new Book();
        b1.displayInfo();

        System.out.println("Book 2:");
        // call displayInfo();
        Book b2 = new Book("Java Programming", "Sakshi", 2024);
        b2.displayInfo();
    }
       
    
}


// Question 4

// constructor overloading
// Create one default constructor to initialize the fields as default values to calculate volume of the cube and one parameterized constructor to pass parameters and initialize them accordingly. You can pass 3 integer parameters at runtime 
// (While using parameterized constructor, the program, should also display the output with the default constructor also)

// Sample output- with parametrized constructor
// Constructor without parameter
// Volume is 1000.0
// Constructor with parameter
// Volume is 192.0


import java.util.Scanner;
 public class Cuboid{
    double length, breadth, height;

    Cuboid(){
        length = 10;
        breadth = 10;
        height = 10;

        System.out.println("Constructor without parameter");
        double volume = length*breadth*height;
        System.out.println("Volume is " + volume);
    }
    Cuboid(double l, double b, double h){
        length = l;
        breadth = b;
        height = h;
        System.out.println("Constructor with parameter");
        double volume = length* breadth*height;
        System.out.println("Volume is " + volume);
    }


    public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
	Cuboid c1 = new Cuboid();

    double l = s.nextDouble();
    double b = s.nextDouble();
    double h = s.nextDouble();

    Cuboid c2 = new Cuboid(l,b,h);
    }
}
