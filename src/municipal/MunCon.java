
package municipal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class MunCon {
    public Connection con;
    public Statement stm;
    public ResultSet rs;
 
public MunCon()
       {
       try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/municipaldb","root","");
        stm=con.createStatement();
       }catch(Exception e)
       {
       System.out.println(e);
       e.printStackTrace();
       }
        
       }
}
