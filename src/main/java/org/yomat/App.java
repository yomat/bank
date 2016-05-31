package org.yomat;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/BD_HB", "postgres", "yomat")) {
            String request = "SELECT * FROM agent";
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(request);

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                double pognon = resultSet.getDouble("pognon");
                //if(name.equals(""))
                System.out.println(name+" :\n\t "+pognon+" €");
            }

            resultSet.close();
            stmt.close();

        } catch (SQLException e) { e.printStackTrace();}

    }
}
