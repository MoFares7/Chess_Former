package structure;

import constrant.Helper;
import game.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {

    static Helper position = new Helper();
    static Color color = new Color();
    static  int level = 0;
    public void getUserPlay(char[][] plan)
    {
        for (int i =0; i < position.getNumPropriety ;i++)
        {
            Scanner scanner = new Scanner(System.in);


            System.out.println("Please Enter Row Cell You Wanted to Move her");

            int input_row = scanner.nextInt();

            // check if input row smaller than number Vertical in plan
            if (input_row > position.getNumVertical)
            {
                System.out.println("Please enter a Row between 0 to 2");
                input_row = scanner.nextInt();

            }
            System.out.println("Please Enter Column Cell You Wanted to Move her");
            int input_column = scanner.nextInt();

            if (input_column > position.getNumHorizontal - 1)
            {
                System.out.println("Please Enter Column between 0 and 15");
                input_column = scanner.nextInt();
            }
            if( checkMove(plan , input_row , input_column))
            {
                continue;
            }
            if (isFinalWin())
            {
                break;
            }
        }
    }

    public static void getNextStates(char[][] plan , int row , int col )
    {
        List deepCopy = new ArrayList();

        System.out.println(color.RED +"This is Cell suggested to move them");
        System.out.println();
        for (int i = 0; i < 1; i++)
        {
            for (int j = 0; j < position.getNumHorizontal; j++)
            {
                if(level != 3)
                {
                    if(isEmpty(plan , row , col))
                    {
                        deepCopy.add(plan[i][col]);

                        System.out.println(color.ORANGE +"this is cell can move her" +"(" + level +" , " + j + ")");
                    }
                    else if(isWall(plan , row ,col)){

                        deepCopy.add(plan[i][col]);
                        System.out.println(color.ORANGE+"this is cell  move her" +"(" + level +" , " + j + ")");
                    }
                }
                else System.out.println();
            }
        }
    }
    public static boolean isWall(char[][] plan, int row, int col)
    {
        for (int i = 0; i < position.getNumVertical; i++)
        {
            for (int j = 0; j < position.getNumHorizontal; j++)
            {
                if (plan[row][col] == '_')
                {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isEmpty(char[][] plan, int row, int col)
    {
        for (int i = 0; i < position.getNumVertical; i++) {
            for (int j = 0; j < position.getNumHorizontal; j++) {
                if (plan[row][col] == ' ') {
                    return true;
                }

            }
        }
        return false;
    }
    public  boolean isFinalWin()
    {
        if(level == 3)
        {
            System.out.println( color.CYAN +  "Configuration You are Win" );
            return  true;
        }
        return  false;
    }
}
