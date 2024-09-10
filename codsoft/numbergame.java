package codsoft;
import java.util.Scanner;
public class numbergame 
{
    int attempts,guess,ran,maxattempts,score=0;
    Scanner sc=new Scanner(System.in);
    numbergame()
    {
        maxattempts=5;
        System.out.println("******* NUMBER GAME *******\n");
        System.out.println("RULES: ");
        System.out.println("-> Range of number is 1 to 100\n-> Maximum number of attempts is 5\n-> Score: win= +1 lose= -1");
        System.out.println("\nHow To Play: \nComputer will guess a number\nWin: your choice matches computer's choice\nLoose: your choice does not match computer's choice");
    }
    public void start()
    {
        System.out.println("\n-------Game Start-------");
        System.out.println("\nComputer has chosen a number");
        ran=1+(int)(100*Math.random());
        for(attempts=1;attempts<=maxattempts;attempts++)
        {
            System.out.println("Attempt "+(attempts)+"\nChoose a number: ");
            guess=sc.nextInt();
            if(guess<1||guess>100)
            {
                System.out.println("Wrong input");
            }
            else
            {
                if(guess==ran)
                {
                    System.out.println("Your guess is correct!\n!!!YOU WON!!!");
                    score+=1;
                    break;
                }
                else if(guess>ran&&attempts!=maxattempts)
                {
                    System.out.println("You guessed a larger number");
                }
                else if(guess<ran&&attempts!=maxattempts)
                {
                    System.out.println("You guessed a smaller number");
                }
            }
        }
        if(attempts-1==maxattempts)
        {
            System.out.println("\nYou have exhausted all "+maxattempts+" attempts");
            score-=1;
            System.out.println("Computer guess was: "+ran);
        }
    }
    public static void main(String args[])
    {
        int re,round=1;
        numbergame obj=new numbergame();
        do
        {
            obj.start();
            System.out.println("Round: \t"+round+"\tScore: "+obj.score);
            System.out.print("\nPress 0 to exit: ");
            re=new java.util.Scanner(System.in).nextInt();
            round++;
        }
        while(re!=0);
    }
}

