import java.sql.*;
import java.lang.*;
public class FirstJavaProgram
{
    public static void main(String[] args) throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/demodatabase";
        String uname = "root";
        String  password = "Mohith";
        Connection con = DriverManager.getConnection(url,uname,password);
        System.out.println("Test: "+con.getCatalog());


        String query1 ="select * from data1";
        String query ="delete from data1 where name ='RamRaj'";
        Statement st = con.createStatement();
        st.executeUpdate(query);
        ResultSet res = st.executeQuery(query1);
        ResultSetMetaData resmd = res.getMetaData();
        int colcount = resmd.getColumnCount();
        while(res.next())
        {
            for(int i=1;i<=colcount;i++)
            {
                System.out.println(res.getString(i)+" ");
            }
            //System.out.println();
        }
        //DBTablePrinter.printTable(con,"demodatabase");
        con.close();


    }
}
