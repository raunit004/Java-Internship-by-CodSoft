package codsoft;
import java.util.Scanner;
class ATMinterface 
{
    double amount, accbalance=0;
    String choice;
    Scanner sc=new Scanner(System.in);
    ATMinterface()
    {
        System.out.println("***** ATM Interface *****\n");
    }
    public void input()
    {
        System.out.println("Enter your choice: \n1. Withdraw\n2. Deposit\n3. Check Balance\n4. Exit");
        choice=sc.nextLine();
        if(choice.equals("1")||choice.equalsIgnoreCase("Withdraw"))
        {
            accbalance=withdraw(accbalance);
            System.out.println("Your account balance is: "+accbalance);
        }
        else if(choice.equals("2")||choice.equalsIgnoreCase("Deposit"))
        {
            accbalance=deposit(accbalance);
            System.out.println("Your account balance is: "+accbalance);
        }
        else if(choice.equals("3")||choice.equalsIgnoreCase("Check Balance"))
        {
            accbalance=chkbalance(accbalance);
            System.out.println("Your account balance is: "+accbalance);
        }
        else if(choice.equals("4")||choice.equalsIgnoreCase("Exit"))
        {
            System.exit(0);
        }
        else
        {
            System.out.println("Invalid Input");
        }
    }
    public double withdraw(double accbalance)
    {
        System.out.println("\nYou selected Withdraw");
        System.out.print("\nEnter the amount to withdraw: ");
        amount=sc.nextDouble();
        if(accbalance<amount)
        {
            System.out.println("Insufficient Balance");
        }
        else
        {
            System.out.println("Withdrawl Succesful of Rs. "+amount);
            accbalance-=amount;
        }
        sc.skip("\n");
        return accbalance;
    }
    public double deposit(double accbalance)
    {
        System.out.println("\nYou selected Deposit");
        System.out.print("\nEnter the amount to deposit: ");
        amount=sc.nextInt();
        if(amount<0)
        {
            System.out.println("Please enter correct amount to deposit");
        }
        else
        {
            System.out.println("Deposit Succesful of Rs. "+amount);
            accbalance+=amount;
        }
        sc.skip("\n");
        return accbalance;
    }
    public double chkbalance(double accbalance)
    {
        System.out.println("\nYou selected Check Balance");
        return accbalance;
    }
}
class UserBankAccount extends ATMinterface
{
    public static void main(String ar[])
    {
        Scanner sc=new Scanner(System.in);
        UserBankAccount obj=new UserBankAccount();
        do
        {
            obj.input();
            System.out.println("\n");
        }
        while(!(obj.choice.equalsIgnoreCase("Exit"))||!(obj.choice.equals("4")));
    }
}
