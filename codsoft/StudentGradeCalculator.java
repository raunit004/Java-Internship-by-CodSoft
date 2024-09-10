package codsoft;
import java.util.Scanner;
public class StudentGradeCalculator 
{
    double tmarks=400, omarks, mmarks, smarks, hmarks, emarks,avgmarks;
    String grade;
    Scanner sc=new Scanner(System.in);
    StudentGradeCalculator()
    {
        System.out.println("******* STUDENT GRADE CALCULATOR *******\n");
    }
    public void input()
    {
        System.out.print("Enter marks obtained in English out of 100: ");
        emarks=sc.nextDouble();
        System.out.print("Enter marks obtained in Hindi out of 100: ");
        hmarks=sc.nextDouble();
        System.out.print("Enter marks obtained in Maths out of 100: ");
        mmarks=sc.nextDouble();
        System.out.print("Enter marks obtained in Science out of 100: ");
        smarks=sc.nextDouble();
    }
    public void calculate()
    {
        omarks=emarks+hmarks+mmarks+smarks;
        avgmarks=omarks/4;
        if(avgmarks<35)
        {
            grade="E";
        }
        else if(avgmarks<50&&avgmarks>=35)
        {
            grade="D";
        }
        else if(avgmarks<70&&avgmarks>=50)
        {
            grade="C";
        }
        else if(avgmarks<85&&avgmarks>=70)
        {
            grade="B";
        }
        else if(avgmarks<=100&&avgmarks>=85)
        {
            grade="A";
        }
    }
    public void display()
    {
        System.out.println("\n---RESULT---\n");
        System.out.println("Total marks: "+tmarks+"\nObtained marks: "+omarks+"\nAverage marks: "+avgmarks+"\nGrade: "+grade);
    }
    public static void main(String ar[])
    {
        StudentGradeCalculator obj=new StudentGradeCalculator();
        obj.input();
        obj.calculate();
        obj.display();
    }
}
