
/**
 * RNG class is a class that generate random number.
 * Give a number from mini to max
 * @author Xingzhe
 * @version 22/10
 */
public class RNG
{
    /**
     * Declare class fields
     * Two fields,maximumValue and minimumValue.
     */
    private int maximumValue;
    private int minimumValue;

    /**
     * Constructor for objects of class RNG
     * Give minimumValue value of 0, and give maximumValue value of 1.
     */
    public RNG()
    {
        minimumValue=0;
        maximumValue=1;
    }

    /**
     * Non Default Constructor for objects of class RNG
     * @param newMinimumValue and newMaximumValue int to define the new minimum value and maximum value
     */
    public RNG(int newMinimumValue,int newMaximumValue)
    {
        minimumValue = newMinimumValue;
        maximumValue = newMaximumValue;
    }

    /**
     * Accessor Method to get the maximum value of the RNG
     * @return A single int which contains the maximum value
     */
    public int getMaximumValue()
    {
        return maximumValue;
    }

    /**
     * Accessor Method to get the minimum value of the RNG
     * @return A single int which contains the minimum value
     */
    public int getMinimumValue()
    {
        return minimumValue;
    }

    /**
     * Mutator Method to set the maximum value of the RNG
     * @param newMaximumValue A single int which contains the maximum value
     */
    public void setMaximumValue(int newMaximumValue)
    {
        maximumValue=newMaximumValue;
    }

    /**
     * Mutator Method to set the minimum value of the RNG
     * @param newMinimumValue A single int which contains the minimum value
     */
    public void setMinimumValue(int newMinimumValue)
    {
        minimumValue=newMinimumValue;
    }

    /**
     * A method that generate a random number
     * return a single int which contains a random number
     */
    public int generateRandomNumber()
    {
        return (int) (Math.random()*(maximumValue-minimumValue+1)+minimumValue);//Generating random number/
    }

}
