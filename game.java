import java.util.*;

public class game
{
    private int[][] board;  
    public game(int r, int c)
    {
        board = new int[r][c];
    }
    public game(int[][] arr)
    {
        board = arr.clone();
    }

    public int[][] update()
    {
        int[][] updated = new int[board.length][board[0].length];
        for(int r = 0; r<board.length; r++)
        {
            for(int c = 0; c<board[0].length; c++)
            {
                int neigh = countNeighbors(r,c);
                if(neigh<2)
                {
                   updated[r][c] = 0; 
                }
                else if(neigh>3)
                {
                    updated[r][c] = 0;
                }
                else if(neigh==3)
                {
                    updated[r][c] = 1;
                }
                else
                {
                    updated[r][c] = board[r][c];
                }
            }
        }
        board = updated.clone();
        return updated;


    }

    public int getCellVal(int r, int c)
    {
        return board[r][c];
    }

    public void setCell(int r, int c, int val)
    {
        if(val==0 || val==1){
        board[r][c] = val;
        }
    }
    public int countNeighbors(int r, int c)
    {
        int count = 0;
        for(int i = -1; i<=1; i++)
        {
            int row = modRow(r+i);
            int col = modCol(c+1);

            count+=board[row][col];
            col = modCol(c);
            count+=board[row][col];
            col = modCol(c-1);              
            count+=board[row][col];
        }
        count = count-board[r][c];
        return count;
    }

    public int modRow(int r)
    {
        int rowMax = board.length;
        if(r>=0 && r<rowMax){return r;}
        if(r<0){return r+rowMax;}
        if(r>=rowMax){return r-rowMax;}

        return r;
    }
    public int modCol(int c)
    {

        int rowMax = board.length;
        if(c>=0 && c<rowMax){return c;}
        if(c<0){return c+rowMax;}
        if(c>=rowMax){return c-rowMax;}

         return c;
    }

    public String toString()
    {
        String out = "";
        for(int[] row : board)
        {
            for(int i : row)
            {
                out+=i+" ";
            }
            out+="\n";
        }
        return out;
    }
}



