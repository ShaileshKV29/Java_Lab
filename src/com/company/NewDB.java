package com.company;

import java.sql.*;

public class NewDB {
    public static void main(String[] args)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jdbc_db",
                    "root",
                    "Sh@ile$h.29"
            );

            Statement stmt = conn.createStatement();

//            boolean result = stmt.execute("CREATE TABLE marks(rollno int, maths int, cpp int, dsa int)");
//            System.out.println(result);

//            int resultInsert = stmt.executeUpdate("INSERT INTO marks VALUES(2, 84, 85, 84)");
//            System.out.println(resultInsert);

//            PreparedStatement pst = conn.prepareStatement("INSERT INTO marks VALUES(?, ?, ?, ?)");
//            pst.setInt(1, 3);
//            pst.setInt(2, 95);
//            pst.setInt(3, 85);
//            pst.setInt(4, 85);
//
//            int resultPrepared = pst.executeUpdate();
//            System.out.println(resultPrepared);

            ResultSet resultSet = stmt.executeQuery("SELECT * FROM marks");

            while (resultSet.next())
            {
                System.out.print(resultSet.getInt("rollno") + " ");
                System.out.print(resultSet.getInt("maths") + " ");
                System.out.print(resultSet.getInt("cpp") + " ");
                System.out.println(resultSet.getInt("dsa"));
            }

            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
