import java.io.*;
import java.nio.channels.ScatteringByteChannel;
import java.util.*;

/**
 * Game class is a class that start the game
 * @author Xingzhe
 * @version 23/10
 */
public class Game
{
    /**
     * Declare class fields
     * Two fields,playerName and gameTotal
     */
    private String playerName;
    private int gameTotal;

    /**
     * Constructor of objects of class Game
     * Give gameTotal and playerName an initial value
     */
    public Game()
    {
        playerName = "";
        gameTotal = 0;
    }

    /**
     * Non Default Constructor for objects of class Gamd
     * @param newPlayerName String and newGameTotal int to define the player name and gamet total
     */
    public Game(String newPlayerName, int newGameTotal)
    {
        playerName = newPlayerName;
        gameTotal = newGameTotal;
    }

    /**
     * A method that start the game
     * return void and no parameters
     */
    public void startGame()
    {
        //display the menu:
        Input input = new Input();
        boolean a = true;
        while(a)
        {
        playerName = input.acceptStringInput("Please input your name:");
        if(playerName.length() < 3 || playerName.length() > 10 ||playerName.trim().contains(" "))
        {
            if(playerName.length() < 3 || playerName.length() > 10 )
            {
                //validate the length of name
                System.out.println("Invalid ! Your name must between 3 to 10.Please try again!");
                a = true;
            }else if(playerName.trim().contains(" "))
            {
                //validate whether have space
                System.out.println("Don't input space ! Please try again!");
                a = true;
            }
        }
        else
        {
            input.acceptStringInput("Hi " + playerName + "! Press enter to continue!");
            a = false;
        }
        }

        //read number
        //[2,4,8]
        int[] number = readNumber();

        //prepare the buffer
        Buffer buffer = new  Buffer();

        //start to play the game
        playGame(number,buffer);
    }

    /**
     * A method that play the game
     * @param number int[] and buffer Buffer are given to play the game
     */
    public void playGame(int[] number,Buffer buffer)
    {
        boolean keepPlay = true;
        while(keepPlay)
        {
            Input input = new Input();
            //clear screen
            System.out.println('\u000C'); 
            
            //generate random number
            RNG rng = new RNG();
            if(gameTotal == 0)
            {
                gameTotal = number[rng.generateRandomNumber()];
            }
            
            //display menu
            displayInterface(buffer);
            String option = input.acceptStringInput("Please select an option:");
            
            //choose option to split or merge
            boolean mergeSuccess = false;
            if(option.equals("1"))
            {
                boolean splitSuccess = buffer.split(gameTotal);
                if(splitSuccess)
                {
                    gameTotal = number[rng.generateRandomNumber()];
                }
                else
                {
                    System.out.println("Sorry! You can't split!");
                    input.acceptStringInput("Press enter to continue!");
                }
            }
            else if(option.equals("2"))
            {
                mergeSuccess = buffer.merge(gameTotal);
                if(mergeSuccess)
                {
                    gameTotal *= 2;
                }
                else
                {
                    System.out.println("Sorry! You can't merge!");
                    input.acceptStringInput("Press enter to continue");
                }
            }
            else
            {
                System.out.println("Invalidation!Please try again!");
                input.acceptStringInput("Press enter to continue");
            }
            keepPlay = check(buffer,mergeSuccess);
            if(!keepPlay)
            {
                System.out.println('\u000C'); 
                displayInterface(buffer);
                System.out.println("Game over!");
                if(gameTotal ==256)
                {
                    System.out.println("You win! You get 256!");
                }
                int bufferMax = buffer.findMaxValue();
                //check gameTotal and buffer who big?
                if(bufferMax > gameTotal)
                {
                    bufferMax = bufferMax;
                }else
                {
                    bufferMax = gameTotal;
                }
                writeResult(bufferMax);
            }
        }
    }

    /**
     * A method to rite the result
     * @param max int are given to the method
     */
    private void writeResult(int max)
    {
        try {
            FileWriter fileWriter = new FileWriter("outcome.txt");
            fileWriter.write(playerName + " " + "finish the game with the score:"+ max);
            fileWriter.close();
        } catch (IOException e) 
        {
            e.printStackTrace();
        }

    }

    /**
     * A method thad check the state of the game
     * @param buffer Buffer and mergeSuccess boolean are given to the method
     * return a single boolean
     */
    public boolean check(Buffer buffer,boolean mergeSuccess)
    {
        if(gameTotal == 256)
        {
            System.out.println('\u000C');
            displayInterface(buffer);
            return false;
        }
        
        //if buffer full && cannot merge
        if(buffer.getList().size() == buffer.getMaxElements()
            &&!buffer.checkMerge(gameTotal))
        {
            return false;
        }
        return true;
    }

    /**
     * A method to display the interface
     * @param buffer Buffer is given to the method
     */
    public void displayInterface(Buffer buffer)
    {
        //display interface
        System.out.println("Buffer:" + "\n" + buffer.printBuffer());
        System.out.println("GameTotal:" + gameTotal);
        System.out.println("1:Split");
        System.out.println("2:Merge");
    }

    /**
     * A method that reading the file
     * return a array of int 
     */
    public int[] readNumber()
    {
        int[] newDeck = new int[3];
        try {
            FileReader fileReader = new FileReader("DMultiples.txt");
            Scanner console = new Scanner(fileReader);
            String temp = console.nextLine();
            System.out.println(temp);
            console.close();
            //2,4,8
            String[] deck = temp.split(",");
            int i = 0;
            for(String s:deck)
            {
                newDeck[i]= Integer.parseInt(s);
                i++;
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Not find the file!");
        }
        return newDeck;
    }

    /**
     * Accessor Method to get the player name of the game
     * @return a single String which contains the player namd
     */
    public String getPlayerName()
    {
        return playerName;
    }

    /**
     * Accessor Method to get the game total of the game
     * @return a single int which contains the game total
     */
    public int getGameTotal()
    {
        return gameTotal;
    }
    
    /**
     * Mutator Method to set the player name of the game
     * @param newPlayerName a String which contains the player name
     */
    public void setPlayerName(String newPlayerName)
    {
        playerName = newPlayerName;
    }

    /**
     * Mutator Method to set the game total of the game
     * @param newGameTotal an int which contains the game total
     */
    public void setGameTotal(int newGameTotal)
    {
        gameTotal = newGameTotal;
    }
}
