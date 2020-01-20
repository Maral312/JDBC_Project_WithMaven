package JDBC_Practice;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.*;

public class JDBC_TestCases {
    String url = "jdbc:oracle:thin:@18.208.127.35:1521:xe";
    String username= "hr";
    String password = "hr";

    Connection connection;
    Statement statement;


    @BeforeMethod
    public void setUp() {

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (Exception e) {

        }
    }

    @Test(description = "Verify that Ulku' salary is greater than Asiya' salary")
    public void Test1() throws SQLException {
        int UlkuSalary =0,
        asiyaSalary = 0;

        String query = "select * from testers";

        ResultSet result = statement.executeQuery(query);

        while (result.next()) {
            String name = result.getString(2);
            int salary = result.getInt(3);
            if (name.equals("Asiya")) {
                asiyaSalary = salary;
            }
            if (name.equals("Ulku")) {
                UlkuSalary = salary;
            }
        }
            System.out.println("Ulku' salary: "+ UlkuSalary);
            System.out.println("Asiya' salary: "+ asiyaSalary);




       Assert.assertTrue(UlkuSalary> asiyaSalary);
        sleepForNow(5);
    }

   public void sleepForNow(int seconds) {
       try {
           Thread.sleep(seconds * 1000);
       }catch(Exception ne){}
    }
}
