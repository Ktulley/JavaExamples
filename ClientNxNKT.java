
/**
 * Write a description of class ClientNxNKT here.
 *
 * @Korey Tulley
 * @5/1/21
 */
import java.util.*;
public class ClientNxNKT
{
    public void Create(int n)
    {
        if (n <= 2)
        {
            System.out.println("Sorry this is not possible with a matrix smaller than 3x3");
        }
        else if (n == 3 || n == 4)
        {
            int sum = n == 3 ? 15 : 34;
            NxNKT box1 = new NxNKT(n);
            int total = n*n;
            boolean solved = false;
            long tries = 0;
            while (!solved)
            {
                tries++;
                box1.shake();
                solved = true;
                for(int i=0; i < n; i++)
                {
                    if (box1.addRow(i+1) != sum || box1.addCol(i+1) != sum)
                    {
                        solved = false;
                        break;
                    }
                }
                solved = solved && box1.addDiag1() == sum && box1.addDiag2() == sum;
            } 
            System.out.println(box1);
            System.out.println("KOREY GOT IT:  "+tries+" tries, sum="+sum);
        }
        else if (n >= 5)
        {
            System.out.println("Doesn't support 5+");
        }
        else
        {
            System.out.print("Sorry the program only accepts positive whole integers");
        }
    }
}
