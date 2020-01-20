package JDBC_Practice;

import java.sql.*;
import java.util.Collections;

public class SimpleConnection {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:oracle:thin:@18.208.127.35:1521:xe";
        String username = "hr";
        String password = "hr";

        //step 1:
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connected");

        //step 2:
        Statement statement = connection.createStatement();

        //select * from countries
        ResultSet result = statement.executeQuery("select * from countries");

        while (result.next()) {
            String countryName = result.getString("country_name");


            int regionID = result.getInt("region_id");
            if (countryName.equalsIgnoreCase("germany")) {

                System.out.println(countryName + " " + regionID);
            }
        }
    }
}