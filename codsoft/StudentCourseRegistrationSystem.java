package codsoft;
import java.util.Scanner;
import java.sql.ResultSet;
public class StudentCourseRegistrationSystem 
{
    String user, password, choice, option;
    int newID,BCAID=10101,BBAID=10201,B_TechID=10301, MCAID=20101, MBAID=20201, M_TechID=20301, SCapacity;
    Scanner sc=new Scanner(System.in);
    StudentCourseRegistrationSystem() 
    {
        user="Raunit Raj";
        password="IITM@1234";
        System.out.println("Welcome to Student Course Registration System");
        System.out.println("Your identity: \n1. Admin \n2. Student \n3. New Registration \n4. Exit");
        choice=sc.nextLine();
        
        conn c=new conn();
        
        if(choice.equals("1")||choice.equalsIgnoreCase("Admin"))
        {
            System.out.println("Please enter your details: ");
            System.out.print("Username: ");
            String username=sc.nextLine();
            System.out.print("Password: ");
            String pass=sc.nextLine();
            if(username.equals("raunit_raj")&&pass.equals(password))
            {
                System.out.println("Welcome "+user);
                System.out.println("What you would like to do: \n1. Details of Students \n2. Details of Course \n3. Add Course \n4. Delete Course");
                option=sc.nextLine();
                if(option.equals("1")||option.equalsIgnoreCase("Details of Students"))
                {
                    try
                    {
                        ResultSet rs=c.s.executeQuery("select * from Students");
                        System.out.println("Name \t\t\t ID \t\t\t Registered_Course");
                        while(rs.next())
                        {
                            String name=rs.getString("Name");
                            String ID=rs.getString("ID");
                            String Registered_Course=rs.getString("Registered_Course");
                            
                            System.out.println(name+"\t\t\t"+ID+"\t\t\t"+Registered_Course);
                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                }
                else if(option.equals("2")||option.equalsIgnoreCase("Details of Course"))
                {
                    try
                    {
                        ResultSet rs=c.s.executeQuery("select * from Courses");
                        System.out.println("Course \t\t\t\t\t\t\t Course_id \t\t\t Title \t\t\t Capacity \t\t\t Schedule \t\t\t Description");
                        while(rs.next())
                        {
                            String coursename=rs.getString("Course");
                            String courseid=rs.getString("Course_id");
                            String coursetitle=rs.getString("Title");
                            String coursecapacity=rs.getString("Capacity");
                            String courseschedule=rs.getString("Schedule");
                            String coursedescription=rs.getString("Description");
                            
                            System.out.println(coursename+"\t\t\t\t"+courseid+"\t\t\t"+coursetitle+"\t\t\t"+coursecapacity+"\t\t\t"+courseschedule+"\t\t\t"+coursedescription);
                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                }
                else if(option.equals("3")||option.equalsIgnoreCase("Add Course"))
                {
                    try
                    {
                        String newcoursename, newcourseid, newcoursetitle, newcoursecapacity, newcourseschedule, newcoursedescription;
                        System.out.print("Enter new course name: ");
                        newcoursename=sc.nextLine();
                        System.out.print("Enter new course id: ");
                        newcourseid=sc.nextLine();
                        System.out.print("Enter new course title: ");
                        newcoursetitle=sc.nextLine();
                        System.out.print("Enter new course capacity: ");
                        newcoursecapacity=sc.nextLine();
                        System.out.print("Enter new course schedule(hh-hh format): ");
                        newcourseschedule=sc.nextLine();
                        System.out.print("Enter new course description: ");
                        newcoursedescription=sc.nextLine();
                        String query="insert into Courses values('"+newcoursename+"','"+newcourseid+"','"+newcoursetitle+"','"+newcoursecapacity+"','"+newcourseschedule+"','"+newcoursedescription+"')";
                        c.s.executeUpdate(query);
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                }
                else if(option.equals("4")||option.equalsIgnoreCase("Delete Course"))
                {
                    try
                    {
                        String deletecoursename;
                        System.out.print("Enter new course name: ");
                        deletecoursename=sc.nextLine();
                        String query="delete from Courses where Course='"+deletecoursename+"'";
                        c.s.executeUpdate(query);
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                }
                
            }
            else
            {
                System.out.println("Wrong username or password!!!");
            }
        }
        else if(choice.equals("2")||choice.equalsIgnoreCase("Student"))
        {
            System.out.println("Please enter your details: ");
            System.out.print("Name: ");
            String Sname=sc.nextLine();
            System.out.print("ID: ");
            String Sid=sc.nextLine();
            String query="select * from Students where Name='"+Sname+"'and ID='"+Sid+"'";
            try
            {
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next())
                {
                    System.out.println("Welcome "+Sname);
                    System.out.println("Enter your choice: \n1. See your course \n2. Delete your course");
                    String select=sc.nextLine();
                    if(select.equals("1")||select.equalsIgnoreCase("See your course"));
                    {
                        try
                        {
                            ResultSet r=c.s.executeQuery("select * from Students where Name='"+Sname+"'");
                            while(r.next())
                            {
                                String name=r.getString("Name");
                                String ID=r.getString("ID");
                                String Registered_Course=r.getString("Registered_Course");
                            
                                System.out.println(name+"\t\t\t"+ID+"\t\t\t"+Registered_Course);
                            }
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                    }
                    if(select.equals("2")||select.equalsIgnoreCase("Delete your course"))
                    {
                        System.out.println("Warning!!! Are you sure you want to delete your course? \nPress Y for yes and N for no");
                        String del=sc.nextLine();
                        if(del.equals("Y"))
                        {
                            System.out.print("Enter your id: ");
                            String cid=sc.nextLine();
                            System.out.print("Enter your course: ");
                            String course=sc.nextLine();
                            if(cid.equals(Sid))
                            {
                                //String query1="selcet * from Students where Name='"+Sname+"'";
                                String query2="select Capacity from Courses where Title='"+course+"'";
                                String query3="delete from Students where Name='"+Sname+"'";
                                //String query4="update Courses set Capacity='"+capacity+"' where Title='"+course+"'";
                                int capacity;
                                try
                                {
                                    ResultSet f=c.s.executeQuery(query2);
                                    if(f.next())
                                    {
                                        capacity=f.getInt("Capacity");
                                        capacity++;
                                        c.s.executeUpdate("update Courses set Capacity='"+capacity+"' where Title='"+course+"'");
                                    }
                                    c.s.executeUpdate(query3);
                                    System.out.println("Your course is deleted");
                                }
                                catch(Exception e)
                                {
                                    System.out.println(e);
                                }
                            }
                            else
                            {
                                System.out.println("Wrong ID!! Unable to delete course");
                            }
                        }
                        else
                        {
                            System.out.println("Your course is not deleted");
                        }
                    }
                }
                else
                {
                    System.out.println("No Records Found!!!");
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(choice.equals("3")||choice.equalsIgnoreCase("New Registration"))
        {
            System.out.println("Courses Available are listed below:\n");
            {
                try
                {
                    ResultSet rs=c.s.executeQuery("select * from Courses");
                    System.out.println("Course \t\t\t\t\t\t\t Course_id \t\t\t Title \t\t\t Capacity \t\t\t Schedule \t\t\t Description");
                    while(rs.next())
                    {
                        String coursename=rs.getString("Course");
                        String courseid=rs.getString("Course_id");
                        String coursetitle=rs.getString("Title");
                        String coursecapacity=rs.getString("Capacity");
                        String courseschedule=rs.getString("Schedule");
                        String coursedescription=rs.getString("Description");

                        System.out.println(coursename+"\t\t\t\t"+courseid+"\t\t\t"+coursetitle+"\t\t\t"+coursecapacity+"\t\t\t"+courseschedule+"\t\t\t"+coursedescription);
                    }
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
            }
            
            try
            {
                System.out.println("\nEnter your details: \n");
                System.out.print("Name: ");
                String Nname=sc.nextLine();
                System.out.print("Course: ");
                String Ncourse=sc.nextLine();
                ResultSet r=c.s.executeQuery("select ID from Students where Registered_Course='"+Ncourse+"' order by ID desc limit 1");
                if(r.next())
                {
                    newID=r.getInt("ID");
                    newID+=1;
                    //System.out.println(newID);
                }
                else
                {
                    if(Ncourse.equalsIgnoreCase("BCA"))
                    {
                        newID=BCAID;
                    }
                    if(Ncourse.equalsIgnoreCase("BBA"))
                    {
                        newID=BBAID;
                    }
                    if(Ncourse.equalsIgnoreCase("B.Tech"))
                    {
                        newID=B_TechID;
                    }
                    if(Ncourse.equalsIgnoreCase("MCA"))
                    {
                        newID=MCAID;
                    }
                    if(Ncourse.equalsIgnoreCase("MBA"))
                    {
                        newID=MBAID;
                    }
                    if(Ncourse.equalsIgnoreCase("M.Tech"))
                    {
                        newID=M_TechID;
                    }
                    
                }
                ResultSet rs=c.s.executeQuery("select Title, Capacity from Courses where Title='"+Ncourse+"'");
                if(rs.next())
                {
                    SCapacity=rs.getInt("Capacity");
                    if(Ncourse.equalsIgnoreCase("BCA")&&SCapacity>0)
                    {
                        try
                        {
                            System.out.println("Your id is: "+newID);
                            System.out.println("You opted BCA");
                            SCapacity--;
                            String NID=""+newID;
                            String Capacity=""+SCapacity;
                            String query="insert into Students values('"+Nname+"','"+NID+"','"+Ncourse+"')";
                            c.s.executeUpdate(query);
                            String query1="update Courses set Capacity='"+Capacity+"' where Title='"+Ncourse+"'";
                            c.s.executeUpdate(query1);
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                    }
                    else if(Ncourse.equalsIgnoreCase("BBA")&&SCapacity>0)
                    {
                        try
                        {
                            System.out.println("Your id is: "+newID);
                            System.out.println("You opted BBA");
                            SCapacity--;
                            String NID=""+newID;
                            int Capacity=SCapacity;
                            String query="insert into Students values('"+Nname+"','"+NID+"','"+Ncourse+"')";
                            c.s.executeUpdate(query);
                            String query1="update Courses set Capacity='"+Capacity+"' where Title='"+Ncourse+"'";
                            c.s.executeUpdate(query1);
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                    }
                    else if(Ncourse.equalsIgnoreCase("B.Tech")&&SCapacity>0)
                    {
                        try
                        {
                            System.out.println("Your id is: "+newID);
                            System.out.println("You opted B.Tech");
                            SCapacity--;
                            String NID=""+newID;
                            int Capacity=SCapacity;
                            String query="insert into Students values('"+Nname+"','"+NID+"','"+Ncourse+"')";
                            c.s.executeUpdate(query);
                            String query1="update Courses set Capacity='"+Capacity+"' where Title='"+Ncourse+"'";
                            c.s.executeUpdate(query1);
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                    }
                    else if(Ncourse.equalsIgnoreCase("MCA")&&SCapacity>0)
                    {
                        try
                        {
                            System.out.println("Your id is: "+newID);
                            System.out.println("You opted MCA");
                            SCapacity--;
                            String NID=""+newID;
                            int Capacity=SCapacity;
                            String query="insert into Students values('"+Nname+"','"+NID+"','"+Ncourse+"')";
                            c.s.executeUpdate(query);
                            String query1="update Courses set Capacity='"+Capacity+"' where Title='"+Ncourse+"'";
                            c.s.executeUpdate(query1);
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                    }
                    else if(Ncourse.equalsIgnoreCase("MBA")&&SCapacity>0)
                    {
                        try
                        {
                            System.out.println("Your id is: "+newID);
                            System.out.println("You opted MBA");
                            SCapacity--;
                            String NID=""+newID;
                            int Capacity=SCapacity;
                            String query="insert into Students values('"+Nname+"','"+NID+"','"+Ncourse+"')";
                            c.s.executeUpdate(query);
                            String query1="update Courses set Capacity='"+Capacity+"' where Title='"+Ncourse+"'";
                            c.s.executeUpdate(query1);
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                    }
                    else if(Ncourse.equalsIgnoreCase("M.Tech")&&SCapacity>0)
                    {
                        try
                        {
                            System.out.println("Your id is: "+newID);
                            System.out.println("You opted M.Tech");
                            SCapacity--;
                            String NID=""+newID;
                            int Capacity=SCapacity;
                            String query="insert into Students values('"+Nname+"','"+NID+"','"+Ncourse+"')";
                            c.s.executeUpdate(query);
                            String query1="update Courses set Capacity='"+Capacity+"' where Title='"+Ncourse+"'";
                            c.s.executeUpdate(query1);
                        }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                    }
                    else
                    {
                        System.out.println("Invalid Input!!! Enter Course Title for course");
                    }
                }
                else
                {
                    System.out.println("No Record Found");
                }
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
            
        }
        if(choice.equals("4")||choice.equalsIgnoreCase("Exit"))
        {
            System.exit(0);
        }
    }
    
    public static void main(String ar[])
    {
        int k;
        Scanner sc=new Scanner(System.in);
        do
        {
            new StudentCourseRegistrationSystem();
            System.out.print("\nPress 0 to exit: ");
            k=sc.nextInt();
        }
        while(k!=0);        
    }
}
