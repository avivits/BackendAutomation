package class12HW;

import java.sql.*;

public class MyDB {


    private static final String USER_NAME = "wR1OEwkMnm";
    private static final String DATABASE_NAME = "wR1OEwkMnm";
    private static final String PASSWORD = "UmtmoqYZeJ";
    private static final String PORT = "3306";
    private static final String SERVER = "remotemysql.com";

    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://"+SERVER+":"+PORT, USER_NAME, PASSWORD);

      createTable(con);
      insertDog(con, "Hugo", 5, "mixed");
      insertDog(con, "Duba", 12, "mixed");
      insertDog(con, "Hanale", 15, "pit bull");
      getTableContent(con);
//      updateDogAge(con, 13, "duba");
//      deleteDog(con, "Hanale");
////      printTable();
//        getTableContent(con);

        con.close();
    }

    private static void createTable(Connection con) throws SQLException {
        String statementToExecute = "CREATE TABLE " + DATABASE_NAME + ".`dogs`(`name` VARCHAR(40) NOT NULL,`age` INT NOT NULL, 'breed' VARCHAR(30) NOT NULL ,PRIMARY KEY (`name`));";
        con.createStatement().execute(statementToExecute);

    }

    private static void insertDog(Connection con, String name, int age, String breed) throws SQLException {
        String statementToExecute = "INSERT INTO " + DATABASE_NAME + ".dogs (`id`, `name` , 'breed') VALUES ('" + name + "', '" + age + "', '" +breed  +"');";
        con.createStatement().execute(statementToExecute);
    }

   private static void updateDogAge(Connection con, int age, String name) throws SQLException {
        String statementToExecute = "UPDATE `" + DATABASE_NAME + "`.`dogs` SET `age`='"+age+"' WHERE `name`='"+name+"';";
        con.createStatement().executeUpdate(statementToExecute);
    }

    private static void deleteDog(Connection con, String name) throws SQLException {
        String statementToExecute = "DELETE FROM `" + DATABASE_NAME + "`.`dogs` WHERE `name`='"+name+"';";
        con.createStatement().execute(statementToExecute);
    }

    private static void getTableContent(Connection con) throws SQLException {
        String statementToExecute = "SELECT * FROM " + DATABASE_NAME + ".dogs;";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(statementToExecute);
        while (rs.next()) {
            //Retrieve by column name
            String name = rs.getString("name");
            int age = rs.getInt("id");
            String breed = rs.getString("breed");

            System.out.print(", Name: " + name);
            System.out.print("Age: " + age);
            System.out.print(", Breed: " + breed);

        }
        rs.close();
    }
}
