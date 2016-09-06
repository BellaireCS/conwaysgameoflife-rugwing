import java.util.*;
import java.lang.*;
public class Runner
{
    public static void main(String[] args) throws InterruptedException
    {
        game conGame = new game(15,15);
        
        conGame.setCell(1,0,1);
        conGame.setCell(2,1,1);
        conGame.setCell(2,2,1);
        conGame.setCell(1,2,1);
        conGame.setCell(0,2,1);
        while(true)
        {

        System.out.print(conGame);
        Thread.sleep(100);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        conGame.update();
        }
    }



}
