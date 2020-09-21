//Import libraries here
import java.util.Scanner;


/**
 * Input Class which creates a scanner object and accept input from the user
 * in different formats
 *
 * @author Xingzhe
 * @version 23/10
 */
public class Input
{
    /**
     * Constructor for objects of class Input
     */
    public void Input()
    {
        
    }    
    /**
     * Method which displays a message to the user to enter a CHARACTER input
     * which is read from the keyboard using the Scanner object and then passed 
     * to the calling method 
     * 
     * @param displayMessage A string message telling the user what input is expected
     * @param index          An integer representing the index of the character in the string to be returned
     * @return               A single character value which is entered by the user
     */
    public char acceptCharInput(String displayMessage,int index)
    {
        Scanner console =new Scanner(System .in);
        System.out.print(displayMessage);
        char temp =console.nextLine().charAt(0);
        return temp;
    }
    /**
     * Method which displays a message to the user to enter an DOUBLE input
     * which is read from the keyboard using the Scanner object and then passed 
     * to the calling method 
     * 
     * @param displayMessage A string message telling the user what input is expected
     * @return               A single double value which is entered by the user
     */
    public double acceptDoubleInput(String displayMessage)
    {
        Scanner console =new Scanner(System .in);
        System.out.print(displayMessage);
        double temp =console.nextDouble();
        return temp;
    }

    /**
     * Method which displays a message to the user to enter an INTEGER input
     * which is read from the keyboard using the Scanner object and then passed 
     * to the calling method 
     * 
     * @param displayMessage A string message telling the user what input is expected
     * @return               A single integer value which is entered by the user
     */
    public int acceptNumericInput(String displayMessage)
    {
        Scanner console =new Scanner(System .in);
        System.out.print(displayMessage);
        int temp =console.nextInt();
        return temp;
    }
    /**
     * Method which displays a message to the user to enter a STRING input
     * which is read from the keyboard using the Scanner object and then passed 
     * to the calling method 
     * 
     * @param displayMessage A string message telling the user what input is expected
     * @return               A single string object which is entered by the user
     */
    public String acceptStringInput(String displayMessage)
    {
        Scanner console =new Scanner(System .in);
        System.out.print(displayMessage);
        String temp =console.nextLine();
        return temp;
    }
}

