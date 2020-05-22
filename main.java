import java.util.*;
import java.util.Scanner;
public class Main
{
  public static String[][] drawGame()
  {
     String[][] arr = new String[7][15];
    for (int i =0;i<arr.length;i++)
    {
       for (int j =0;j<arr[i].length;j++)
      {
        if (j% 2 == 0) arr[i][j] ="|";
        else arr[i][j] = " ";
        if (i==6) arr[i][j]= "_";
      }
    }
    return arr;
  }
  public static void printPattern(String[][] arr)
  {
    for (int i =0; i < arr.length;i++)
    {
      for (int j=0;j<arr[i].length;j++)
      {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }
  }
  public static void dropRedPattern(String[][] arr)
  {
    System.out.println("Drop a disk at column (0–6): ");
    Scanner scan = new Scanner (System.in);
    int c = 2 * scan.nextInt()+1;
    for (int i = 5; i >= 0; i--)
    {
      if (arr[i][c] == " ")
      {
        arr[i][c] = "Y";
        break;
      }
    }
  }
  public static void dropComputer(String[][] arr)
  {
    Random rand = new Random();
    int comp = rand.nextInt(6) + 0;
    int c = 2 * comp+1;
    for (int i = 5; i >= 0; i--)
    {
      if (arr[i][c] == " ")
      {
        arr[i][c] = "C";
        break;
      }
    }
  }
  public static String checkWinner(String[][] arr)
  {
    for (int i =0;i<6;i++)
    {
      for (int j=0;j<7;j+=2)
      {
        if ((arr[i][j+1] != " ")
        && (arr[i][j+3] != " ")
        && (arr[i][j+5] != " ")
        && (arr[i][j+7] != " ")
        && ((arr[i][j+1] == arr[i][j+3])
        && (arr[i][j+3] == arr[i][j+5])
        && (arr[i][j+5] == arr[i][j+7])))
          return arr[i][j+1];  
      }
    }
    for (int i=1;i<15;i+=2)
    {
      for (int j =0;j<3;j++)
      {
            if((arr[j][i] != " ")
            && (arr[j+1][i] != " ")
            && (arr[j+2][i] != " ")
            && (arr[j+3][i] != " ")
            && ((arr[j][i] == arr[j+1][i])
            && (arr[j+1][i] == arr[j+2][i])
            && (arr[j+2][i] == arr[j+3][i])))
              return arr[j][i];  
      }  
    }
    for (int i=0;i<3;i++)
    {
      for (int j=1;j<9;j+=2)
      {
            if((arr[i][j] != " ")
            && (arr[i+1][j+2] != " ")
            && (arr[i+2][j+4] != " ")
            && (arr[i+3][j+6] != " ")
            && ((arr[i][j] == arr[i+1][j+2])
            && (arr[i+1][j+2] == arr[i+2][j+4])
            && (arr[i+2][j+4] == arr[i+3][j+6])))
              return arr[i][j];  
      }  
    }
    for (int i=0;i<3;i++)
    {
      for (int j=7;j<15;j+=2)
      {
            if((arr[i][j] != " ")
            && (arr[i+1][j-2] != " ")
            && (arr[i+2][j-4] != " ")
            && (arr[i+3][j-6] != " ")
            && ((arr[i][j] == arr[i+1][j-2])
            && (arr[i+1][j-2] == arr[i+2][j-4])
            && (arr[i+2][j-4] == arr[i+3][j-6])))
              return arr[i][j];  
      }  
    }
    return null;
  }
  public static void main (String[] args)
  {
    String[][] arr = drawGame();
    boolean loop = true;
    int count = 0;
    printPattern(arr);
    while(loop)
    {
       if (count % 2 == 0) dropRedPattern(arr);
       else dropComputer(arr);
       count++;
       printPattern(arr);
       if (checkWinner(arr) != null)
       {
          if (checkWinner(arr) == "Y")
             System.out.println("You won.");
          else if (checkWinner(arr)== "C")
            System.out.println("The computer won.");
         loop = false;
       }
    }
  }
}
