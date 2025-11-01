// Question 1

// Arithmetic Operators in Java
// Instructions:

// Write a program that takes two numbers as input from the user and performs arithmetic operations on them using the arithmetic operators (sum, difference, product, quotient, remainder) in Java.

// Examples:

// # Examples: 
// 1. int num1 = 10; 
//    int num2 = 5; 
//    int sum = num1 + num2; 
//    System.out.println(sum); // Output: 15  
// Sample Input & Output:

// Sample Input:
// Enter the first number: 10
// Enter the second number: 5

// Sample Output:
// Sum: 15
// Difference: 5
// Product: 50
// Quotient: 2
// Remainder: 0
// Hints:
// 1. Use the Scanner class to read input from the user.
// 2. Declare variables to store the input values and the results of the arithmetic operations.
// 3. Use the appropriate arithmetic operators to perform the calculations.
// 4. Print the results using the System.out.println() method.
// 5. Remember to handle division by zero when calculating the quotient.

import java.util.Scanner;

public class ArithmeticOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // TODO: Write your code here
       int n1 = scanner.nextInt();
       int n2 = scanner.nextInt();

       int sum = n1+n2;
       int diff = n1-n2;
       int pro = n1*n2;
       int quo = n1/n2;
       int rem = n1%n2;

       System.out.println("Sum: "+ sum);
       System.out.println("Difference: "+ diff);
       System.out.println("Product: "+ pro);
       System.out.println("Quotient: "+ quo);
       System.out.println("Remainder: "+ rem);
        scanner.close();
    }
}

// Question 2

// Logical Operators in Java
// Instructions:

// Write a program that takes two boolean values as input and performs logical operations (AND, OR) on them using the logical operators& print the result.

// Examples:

// # Examples: 
// 1. boolean a = true; 
//    boolean b = false; 
//    boolean result = a && b; 
//    System.out.println(result); // Output: false 
// Sample Input & Output:

// Sample Input:
// true
// false

// Sample Output:
// false
// true
// Hints:
// 1. Remember to use the correct syntax for the logical operators.
// 2. Make sure to include the necessary boolean variables or values in the logical operations.
// 3. Check the output on the console to verify if the logical operations are working correctly

import java.util.Scanner;

public class LogicalOperatorsExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean input1 = scanner.nextBoolean();
        boolean input2 = scanner.nextBoolean();
        
        boolean resultAnd = input1 && input2;
        boolean resultOr = input1 || input2;

        System.out.println(resultAnd);
        System.out.println(resultOr);
        // TODO: Write your code here
    }
}

// Question 3

// Relational Operators in Java
// Instructions:

// Write a program that takes two integers as input and compares them using relational operators. Print 'true' if the first integer is greater than the second integer, and 'false' otherwise.

// Examples:

// # Examples: 
// 1. Input: 5, 3 
//    Output: true 

// 2. Input: 2, 7 
//    Output: false 
// Sample Input & Output:

// Sample Input:
// 5
// 3

// Sample Output:
// true
// Hints:
// 1. Use the '>' operator to compare the first integer with the second integer.
// 2. Remember to use the correct syntax for the relational operator.
// 3. Check the output on the console to verify if the comparison is working correctly.

import java.util.Scanner;

public class RelationalOperatorExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        // TODO: Write your code here
        boolean greater = (num1>num2);
        System.out.println(greater);
    }
}


// Question 4

// Check Number Parity
// Write a program in java to check whether the given number is an even number or not using if else statement.


//   Sample Test Case 1

//  input

// 12

// output

// No is Even

// Sample Test Case 2

// input

// 13

// output

// No is odd

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        //write your answer here
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        if(num % 2 == 0){
            System.out.println("No is Even");
        } else{
            System.out.println("No is odd");
        }
    }
}
