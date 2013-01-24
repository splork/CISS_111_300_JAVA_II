/*   Program Name: Unit9a_Robinson.java
      Programmer: Richard L Robinson Jr
      Date: 12/11/12
      Purpose: To Learn Java arrays
*/


// Import classes
import java.io.*;
import java.util.*;

public class unit9_robinson
{
  static Scanner console = new Scanner(System.in);
  
  public static void main (String[] args )
  {
    // variables
    int totalJudges = 0;
    int i = 0;
    int j = 0;
    int count = 0;
    double totalScore = 0.0;
    double rawScore = 0.0;
    double degreeDifficulty = 0.0;
    double highestScore = 0.0;
    double lowestScore = 0.0;
    String totalJudgesInput;
          
    // What is this program about?
    System.out.println("This is a Java Program which determines diving scores.");
    
    // Prompt user for total number of judges, store variable
    System.out.println("Please enter the total number of judges: ");
    totalJudgesInput = console.nextLine(); 
    
     while  (!isPositive(totalJudgesInput))
         {
          System.out.println("Error: Enter a valid number for total number of judges.") ;
          System.out.println("Again, please enter a full digit as the number of judges.!") ;
          totalJudgesInput = console.nextLine();
          }
    
     // change the string to an int
     totalJudges = Integer.parseInt(totalJudgesInput);
     
     
    // begin to setup the array, based off of the number of totalJudges variable
    String scores[] = new String [totalJudges];
    double doubleScores[] = new double [totalJudges];
    
    //This needs to be checked between 1.2 to 4.8
    System.out.println("Please enter the degree of difficulty for the dive: ");
    degreeDifficulty = console.nextDouble();
    if (degreeDifficulty < 1.2 || degreeDifficulty > 4.8)
    {
       System.out.println("Please enter number between 1.2 and 4.8: ");
       scores[count] = console.nextLine();
    }
    scores[count] = console.nextLine();
      
    //lets loop through until count equals total number of judges
    while (count != totalJudges)
      {
      System.out.println("Please enter the score of the dive: ");
      scores[count] = console.nextLine();
     
      
      // created method, easier to change if need be
     while (!isAcceptableScore(scores[count]))
         {
          System.out.println("Error: Please try again, entering a value more appropriate. ") ;
          System.out.println("Again, scores in all diving meets use a range from one to ten, in ½ point increments. ") ;
          scores[count] = console.nextLine();
          }   
      count++;           
    }        
    
    //create a for loop to convert string array to double 
    for(i = 0; i < scores.length; i++)      
     { 
      doubleScores[i] = Double.parseDouble(scores[i]); 
      } 
    
    // loop through the array and set everything
    for(i = 0; i < doubleScores.length; i++)
      rawScore = rawScore + doubleScores[i];
       
      if ( totalJudges > 3 )
      {
      
        totalScore = (rawScore - highestScore(doubleScores) - lowestScore(doubleScores))* degreeDifficulty ;
        System.out.println("\nThe contestant received "+ totalScore + " points.");
      }
      else
      {
          totalScore = rawScore * degreeDifficulty;
          System.out.println("\nThe contestant received "+ totalScore + " points.");
      }
      
      }     
  
  
      public static double highestScore(double[] numbers){  
      double maxValue = numbers[0];  
      for(int i=1;i < numbers.length;i++){  
        if(numbers[i] > maxValue){  
          maxValue = numbers[i];  
        }  
      }  
      return maxValue;  
    }  
      
    public static double lowestScore(double[] numbers){  
      double minValue = numbers[0];  
      for(int i=1;i<numbers.length;i++){  
        if(numbers[i] < minValue){  
          minValue = numbers[i];  
        }  
      }  
      return minValue;  
    }  
    
      // lets check to make sure the score is 1-10, including .5's
      // examples of good scores: 8, 8.5, 9, 9.5, 10
    public static boolean isAcceptableScore(String input){
        return input.matches("^[0-9](\\.[0-9])?|(10)");
    }
    
     // lets check to make sure its a positive digit
    public static boolean isPositive(String input){
        return input.matches("^\\d+$");
    }
}