/**
 * Multiple class is a class that stores an integer value for a given multiple which is used in the game.
 * @author Xingzhe
 * @version 23/10
 */

public class Multiple
{
    /**
     * Declare class fields
     * One field, value.
     */
    private int value;
    
    /**
     * Constructor for objects of class Multiple
     * Give the field value value of 0
     */
    public Multiple()
    {
        value = 0;
    }
    
    /**
     * Non Default Constructor for objects of class Multiple
     * @param newValue int to define the new value
     */
    public Multiple(int newValue)
    {
        value = newValue;
    }
    
    /**
     * Accesor Method to get the value of the Multiple
     * @return a single int which contains the value
     */
    public int getValue()
    {
        return value;
    }

    /**
     * Mutator Method to set the value to Multiple
     * @param newValue A single int which contains the value
     */
    public void setValue(int newValue)
    {
        value = newValue;
    }

    /**
     * A method that print the value
     * return a single String
     */
    public String display()
    {
        return "Multiple{" + "value = " + value + "}";
    }
}
