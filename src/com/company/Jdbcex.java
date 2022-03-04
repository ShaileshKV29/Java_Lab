package com.company;

import java.sql.*;

public class Jdbcex {
    public static void main(String[] args) {
//        We need to wrap it into try catch statement otherwise it will show a red line when using methods

        try {
//            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jdbc_db",
                    "root",
                    "Sh@ile$h.29"
            );

            Statement stmt = con.createStatement();

//            boolean result = stmt.execute(
//                    "CREATE TABLE students" +
//                            "(rollno int, " +
//                            "sname varchar(20)," +
//                            "class varchar(20)," +
//                            "age int)"
//            );

//            System.out.println(result);

//            int resultSet = stmt.executeUpdate("INSERT INTO students VALUES(01, 'Shailesh', 12, 20)");
//            System.out.println(resultSet);

            PreparedStatement pst = con.prepareStatement("INSERT INTO students VALUES(?, ?, ?, ?)");
            pst.setInt(1, 03);
            pst.setString(2, "Ritesh");
            pst.setString(3, "8");
            pst.setInt(4, 20  );

            int resultInsert = pst.executeUpdate();
            System.out.println(resultInsert);

            ResultSet resultSet = stmt.executeQuery("SELECT * FROM students");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("sname"));
            }

            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
