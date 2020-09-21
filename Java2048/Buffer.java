import java.util.*;
import java.io.*;

/**
 * Buffer class is a class that includes an arraylist  
 * which stores objects of the multiple class, and an 
 * integer which stores the maximum number of elements 
 * which can be stored in the arraylist buffer
 * @author Xingzhe
 * @versior 23/10
 */
public class Buffer
{
    /**
     * Declare class fields
     * Two fields,one arraylies named list, and an int named maxElements
     */
    private ArrayList<Multiple> list;
    private int maxElements;

    /**
     * Constructor for objects of class Buffer
     * Create an arraylist and give maxElements value of 5
     */
    public Buffer()
    {
        list = new ArrayList<>();
        maxElements = 5;
    }

    /**
     * Non Default Constructor for objects of class Buffer
     * @param newList ArrayList<Multiple> and newMaxElements int 
     * to define the new list and maxelements
     */
    public Buffer(ArrayList<Multiple> newList, int newMaxElements)
    {
        if(newList.size() < 5)
            list = newList;
        else 
            list = new ArrayList<>();
        if(newMaxElements > 0)
            maxElements = newMaxElements;
        else
            maxElements = 5;
    }

    /**
     * A method that user can split 
     * @param gameTotal int are given in this method
     * return a single boolean 
     */
    public boolean split(int gameTotal)
    {
        if(list.size() < maxElements)
        {
            Multiple multiple = new Multiple();
            multiple.setValue(gameTotal);
            list.add(multiple);
            return true;
        }
        return false;
    }

    /**
     * A method that user can merge
     * @param gameTotal int are given in this method
     * return a single boolean
     */
    public boolean merge(int gameTotal)
    {
        //
        for(Multiple multiple : list)
        {
            if(multiple.getValue() == gameTotal)
            {
                list.remove(multiple);
                return true;
            }
        }
        return false;
    }

    /**
     * A method that find the max value of the game
     * return a single int which contains the max value
     */
    public int findMaxValue()
    {
        int max = 0;
        for (int i =0; i < list.size(); i++)
        {
            if(list.get(i).getValue() > max)
            {
                max = list.get(i).getValue();
            }
        }
        return max;
    }

    /**
     * A method that check whether the user can keep merging
     * @param gameTotal int are given in this method
     * return a single boolean
     */
    public boolean checkMerge(int gameTotal)
    {
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).getValue() == gameTotal)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * A method that print the buffer
     * return a string 
     */
    public String printBuffer()
    {
        StringBuffer result = new StringBuffer();
        for(int i = 0;i < maxElements; i++)
        {
            if(i < list.size())
            {
                result.append(list.get(i).getValue()+"\r\n");
            }else
            {
                result.append("Null"+"\r\n");
            }
        }
        return result.toString();
    }

    /**
     * Accessor Method to get the list of the Buffer
     * @return an arraylist 
     */
    public ArrayList<Multiple> getList()
    {
        return list;
    }

    /**
     * Accessor Method to get the maxElements of the Buffer
     * @return a single int that contains the maxElements value
     */
    public int getMaxElements()
    {
        return maxElements;
    }
    
    /**
     * Mutator Method to set the list of the Buffer
     * @param newList ArrayList<Multiple>
     */
    public void setList(ArrayList<Multiple> newList)
    {
        if(list.size() < 5)
            list = newList;
        else
            list = new ArrayList<>();
    }

    /**
     * Mutator Method to set the maxElements value of Buffer
     * @param newElements int which contains the value of maxElements
     */
    public void setMaxElements(int newMaxElements)
    {
        if(newMaxElements > 0)
            maxElements = newMaxElements;
        else
            maxElements = 5;
    }
}


