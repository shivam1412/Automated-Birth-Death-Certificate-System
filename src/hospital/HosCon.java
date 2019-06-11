
package hospital;
import java.sql.*;
public class HosCon {
    public Connection con;
    public Statement stm;
    public ResultSet rs;
 
public HosCon()
       {
       try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospitaldb","root","");
        stm=con.createStatement();
       }catch(Exception e)
       {
       System.out.println(e);
       e.printStackTrace();
       }
        
       }
}
