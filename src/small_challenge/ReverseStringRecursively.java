package small_challenge;

import java.util.Scanner;

public class ReverseStringRecursively {
    public static void main(String[] args) {
        simpleReverseString();
    }

    private static void simpleReverseString() {
        String str = "Hello";
        String reversed = reverseString(str);
        System.out.println("The reversed string is: " + reversed);
    }

    private static void reverseStringFromScanner() {
        System.out.println("Enter your username: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        scanner.close();
        String reversed = reverseString(userInput);
        System.out.println("The reversed string is: " + reversed);
    }

    public static String reverseString(String str) {
        if (str.isEmpty())
            return str;
        //Calling Function Recursively
        return reverseString(str.substring(1)) + str.charAt(0);
    }
}
