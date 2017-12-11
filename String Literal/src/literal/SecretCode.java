package literal;
import java.util.Scanner;

import java.util.regex.Pattern;

public class SecretCode {

private static String inputString;

private static int stringLength;

private static String outputString;

private StringBuilder mutator = new StringBuilder(); // For encoded characters

  

public SecretCode() {

super();

}

  

public SecretCode(String inputString) {

this.inputString = inputString;

}

  

public boolean checkStringValidity(String inputString) {

if(Pattern.matches("[a-z_]+", inputString)) {

return true;

}

return false;

}

  

public int getStringLength(String inputString) {

//Remove the white spaces and find the length

return inputString.replaceAll("\\s", "").length();

}

  

public String shiftChar(String inputString) {

//Have a string with a-z & white space

String arr = "abcdefghijklmnopqrstuvwxyz ";

//Iterate the input string character by character

for(int i = 0; i < inputString.length(); i++) {

//Get a new position by finding the current position added with new

int newPos = arr.indexOf(inputString.charAt(i)) + stringLength;

//If the new position is greater than 26, then get the

//relevant new position by subtracting with 27

if(newPos > 26) {

newPos = newPos-27;

}

//add the string builder with each new encoded character

mutator.append(arr.charAt(newPos));   

}

return mutator.toString();

}

  

public static void main(String[] args) {

boolean repeat = true;

SecretCode secCode = new SecretCode();

//To loop until the user enters the correct input

while(repeat) {

Scanner sc = new Scanner(System.in);

System.out.println("Enter the input string : ");

secCode = new SecretCode(sc.nextLine());

if(secCode.checkStringValidity(inputString)) {

stringLength = secCode.getStringLength(inputString);

repeat = false;

}

else {

System.out.println("Invalid Input");

}

}

outputString = secCode.shiftChar(inputString);

System.out.println("The encoded string : " + outputString);

}

}