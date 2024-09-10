package codsoft;
import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.Scanner;

public class Quiz 
{
    ArrayList<String> options=new ArrayList<>();
    ArrayList<String> questions=new ArrayList<>();
    ArrayList<String> oq1=new ArrayList<>();
    ArrayList<String> oq2=new ArrayList<>();
    ArrayList<String> oq3=new ArrayList<>();
    ArrayList<String> oq4=new ArrayList<>();
    ArrayList<String> answers=new ArrayList<>();
    ArrayList<String> response=new ArrayList<>();
    int score=0, timeLimit=25;
    Timer timer;
    Quiz()
    {
        Scanner sc=new Scanner(System.in);
        options.add("a");
        options.add("b");
        options.add("c");
        options.add("d");
        questions.add("Who invented Java Programming");
        questions.add("Which of these cannot be used for a variable name in java");
        questions.add("What is the extension of java code files");
        questions.add("Which of the following is not an OOPS concept in Java");
        oq1.add("Guido van Rossum");
        oq1.add("James Gosling");
        oq1.add("Dennis Ritchie");
        oq1.add("Bjarne Stroustrup");
        oq2.add("identifier and keyword");
        oq2.add("identifier");
        oq2.add("keyword");
        oq2.add("none of the mentioned");
        oq3.add(".js");
        oq3.add(".txt");
        oq3.add(".class");
        oq3.add(".java");
        oq4.add("Polymorphism");
        oq4.add("Interface");
        oq4.add("Compilation");
        oq4.add("Encapsulation");
        answers.add("James Gosling");
        answers.add("keyword");
        answers.add(".java");
        answers.add("Compilation");
        for(int i=0;i<questions.size();i++)
        {
            System.out.println("\nQ"+(i+1)+"."+questions.get(i));
            for(int j=0;j<oq1.size();j++)
            {
                if(i==0)
                {
                    System.out.print("("+options.get(j)+")"+oq1.get(j)+"\n");
                }
                if(i==1)
                {
                    System.out.print("("+options.get(j)+")"+oq2.get(j)+"\n");
                }
                if(i==2)
                {
                    System.out.print("("+options.get(j)+")"+oq3.get(j)+"\n");
                }
                if(i==3)
                {
                    System.out.print("("+options.get(j)+")"+oq4.get(j)+"\n");
                }
            }
            timer=new Timer();
            TimerTask task=new TimerTask()
            {
                public void run() 
                {
                    System.out.println("Time's up! Press ENTER to move ahead");
                    synchronized(sc)
                    {
                        sc.notify();
                        sc.skip("");
                    }
                    timer.cancel();
                }
            };
            timer.schedule(task, timeLimit*1000);
            
            synchronized (sc)
            {
                try
                {
                    if(i==0)
                    {
                        System.out.print("Answer: ");
                        response.add(i,sc.nextLine());
                    }
                    if(i==1)
                    {
                        System.out.print("Answer: ");
                        response.add(i,sc.nextLine());
                    }
                    if(i==2)
                    {
                        System.out.print("Answer: ");
                        response.add(i,sc.nextLine());
                    }
                    if(i==3)
                    {
                        System.out.print("Answer: ");
                        response.add(i,sc.nextLine());
                    }
                }
                catch(Exception e)
                {}
                timer.cancel();
            }
            System.out.println();
        }        
        
        for(int i=0;i<questions.size();i++)
        {
            if(i==0)
            {
                if(response.get(i).equalsIgnoreCase(answers.get(i))||response.get(i).equalsIgnoreCase("b"))
                {
                    System.out.println((i+1)+". Correct");
                    score+=1;
                }
                else
                {
                    System.out.println((i+1)+". Incorrect");
                }
            }
            if(i==1)
            {
                if(response.get(i).equalsIgnoreCase(answers.get(i))||response.get(i).equalsIgnoreCase("c"))
                {
                    System.out.println((i+1)+". Correct");
                    score+=1;
                }
                else
                {
                    System.out.println((i+1)+". Incorrect");
                }
            }
            if(i==2)
            {
                if(response.get(i).equalsIgnoreCase(answers.get(i))||response.get(i).equalsIgnoreCase("d"))
                {
                    System.out.println((i+1)+". Correct");
                    score+=1;
                }
                else
                {
                    System.out.println((i+1)+". Incorrect");
                }
            }
            if(i==3)
            {
                if(response.get(i).equalsIgnoreCase(answers.get(i))||response.get(i).equalsIgnoreCase("c"))
                {
                    System.out.println((i+1)+". Correct");
                    score+=1;
                }
                else
                {
                    System.out.println((i+1)+". Incorrect");
                }
            }
        }
    }
    public void result()
    {
        System.out.println("\nYour Total score is "+score+" out of "+questions.size());
        for(int i=0;i<answers.size();i++)
        {
            System.out.println("\nQ"+(i+1)+". \n"+"The answer is "+answers.get(i));
        }
    }
    
    public static void main(String ar[])
    {
        Quiz obj=new Quiz();
        obj.result();
    }
}
