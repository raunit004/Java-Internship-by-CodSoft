package codsoft;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
public class conn 
{
    Connection c;
    Statement s;
    public conn()
    {
        try
        {
            c=DriverManager.getConnection("jdbc:mysql:///StudentCourseManagementSystem", "root", "Usccsql@7543");
            s=c.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
