
/**
 * Creates and fills an ArrayList with methods to modify it
 *
 * @Korey Tulley
 * @5/1/21
 */
import java.util.*;
public class NxNKT
{
    public int n;
    public ArrayList<Integer> box;
    public NxNKT(int n)
    {
        this.n = n;
        this.box = new ArrayList<>(n*n);
        for (int i = 0; i < n*n; i++)
        {
            box.add(i+1);
        }
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < box.size(); i++)
        {
            if (i != 0 && ((i) % n) == 0)
            {
                result.append("\n");
            }
            if (box.get(i)<=9)
            {
                result.append(" ");
            }
            result.append(box.get(i)+"  ");
        }
        return result.toString();
    }

    public void printMe()
    {
        System.out.println(toString());
        for(int i=0; i < n; i++)
        {
            System.out.println("The row sum for row "+(i+1)+" is "+this.addRow(i+1));
            System.out.println("The col sum for col "+(i+1)+" is "+this.addCol(i+1));
        }
        System.out.println("The first diagonal sum "+this.addDiag1());
        System.out.println("The second diagonal sum "+this.addDiag2());
    }

    public int addRow(int rr)
    {
        int rowSum = 0;
        for(int i = 0; i < n; i++)
        {
            rowSum = box.get(i+((rr-1)*n)) + rowSum;
        }
        return rowSum;
    }

    public void shake()
    {
        Random rn = new Random();
        int random1 = rn.nextInt(box.size());
        int random2 = rn.nextInt(box.size());
        /** for debug only
         * System.out.println("The total is "+total);
         * System.out.println("The first element was "+ random1);
         * System.out.println("The second element was " + random2);
        */
        Collections.swap(box, random1, random2);
    }

    public int addCol(int cc)
    {
        int colSum = 0;
        for(int i = 0; i < n; i++)
        {
            colSum = box.get((i*n)+(cc-1)) + colSum;
        }
        return colSum;
    }

    public int addDiag1()
    {
        //This is top left to bottom right
        int diag1 = 0;
        for(int i = 0; i < n; i++)
        {
            diag1 = box.get((n*i)+(i)) + diag1;
        }
        return diag1;
    }

    public int addDiag2()
    {
        //This is top right to bottom left
        int diag2 = 0;
        for(int i = 0; i < n; i++)
        {
            diag2 = box.get(n*(n-i-1)+i) + diag2;
        }
        return diag2;
    }

}
