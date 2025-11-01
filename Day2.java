// Question 1
// Marks: 1/1

// sum of the elements present inside the array
// 1. Write a program to find the sum of the elements present inside the array.

// Sample Input:

// 5

// 1 2 3 4 5

// Output: the sum of the elements in the array = 15

// Sample Input2:

// 3

// 19 45 34

// Output: the sum of the elements in the array = 98


import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
        int size = input.nextInt();  
        int[] arr = new int[size];
         // read the array elements
        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }
        
        sumArray(arr,size);
        
    }
    
    public static void sumArray(int[] arr,int size)
    {
      //write logic here and display sum
      int sum = 0;
      for(int number : arr ){
          sum += number;
      }
      System.out.println("the sum of the elements in the array = "+sum);
     
    }
}


// Question 2


// Multidimensional Arrays in Java
// Instructions:

// Write a program that takes the row & columns input from the user to populate a 2D array and then prints the array.

// Sample Input & Output:

// Sample Input:
// 2
// 3
// 1 2 3
// 4 5 6

// Sample Output:
// 1 2 3
// 4 5 6
// Hints:
// 1. Use the Scanner class to read input from the user.
// 2. Create a nested for loop to iterate over the rows and columns of the array.
// 3. Use the nextInt() method of the Scanner class to read integer values from the user.
// 4. Store the input values in the array using the appropriate indices.
// 5. Print the array using a nested for loop.

import java.util.Scanner;

public class MultidimensionalArrayExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // TODO: Write your code here
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        int[][] array = new int[row][column];

        for(int i = 0; i < row; i++)
        {
            for(int j = 0 ; j < column ; j++)
            {
                array[i][j] = scanner.nextInt();
            }
        }
        for(int i = 0; i < row; i++)
        {
            for(int j = 0 ; j < column ; j++)
            {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
        scanner.close();
    }
}

// Question 3

// Reverse each word in a string
// Write a function to reverse each word in a string.

// Description :- A method has to be created that takes a string as input and extracts each word from that string and then reverse each word individually and gives the output as a reversed string. 

// Example :-

// Input:- great learning

// output :- taerg gninrael

// input :- hello guys how are you

// output :- olleh syug woh era uoy



// Explanations :- As the input string is great learning, each word has to be extracted i.e. great and learning then individually each word has to be reversed so it will be taerg and gninrael. after combining these two words into as single string the final output will be taerg gninrael.

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        //write your answer here
        String input1 = "Great Learning";
        System.out.println(reverseEachWord(input1));
    }
    public static String reverseEachWord(String inputString){
        if (inputString == null || inputString.isEmpty()){
            return inputString;
        }
        String[] words = inputString.split(" ");
        StringBuilder reversedString = new StringBuilder();

        for(String word : words){
            StringBuilder reversedWord = new StringBuilder(word);
            reversedWord.reverse();
            reversedString.append(reversedWord).append(" ");
        }
        return reversedString.toString().trim();
    }
}


// Question 4

// Equal character in string
// You are given a string s. In one move you can change any character to another character.

// You have to make a string which consists of the same character. Find the minimum move to do this task.

// Constraints:

// 1 <= s.length <= 1000

// s consists only of lowercase characters .

// Input Format

// First line contains string s.

// Output format 

// Print the minimum move to this task.

//  Input

// aabbbcccc

// output

// 5

// Explanation

// Since  character ‘c’ has maximum frequency in string s.

// So we will make all other character to ‘c’so the minimum move is 5 (convert 2 ‘a’ into ‘c’ and 3 ‘b’into ‘c’).



import java.util.*;
public class Main {

    public static void main(String[] args) {

        
        //write your answer here
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int[] freq = new int[26];

        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        int maxFreq = 0;
        for(int count : freq){
            if(count>maxFreq){
                maxFreq = count;
            }
        }
        int minMoves = s.length() - maxFreq;
        System.out.println(minMoves);
    }
}
