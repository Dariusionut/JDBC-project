import java.sql.*;

public class MyJDBCConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/JDBC?createDatabaseIfNotExist=true";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static MyJDBCConnection instance;

    private static Statement stmt = null;

//    I made the constructor private to use singleton design pattern
//    JDBC is made through constructor

    private MyJDBCConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = connection.createStatement();
            System.out.println("Connection succeeds to port: " + URL + "\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    Method for creating tables

    public void createTable(String tableName, String... values) {
        try {

            StringBuilder myData = new StringBuilder();
            for (String value : values) {
                myData.append(value).append(", ");
            }

            String sql = "CREATE TABLE IF NOT EXISTS " + tableName + "(" +
                    "id INTEGER NOT NULL AUTO_INCREMENT, " +
                    myData +
                    " PRIMARY KEY (id) )";

            stmt.executeUpdate(sql);

            System.out.println("Table " + tableName + " has been created!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    Method for dropping tables

    public void dropTableExample(String tableName) {
        try {
            stmt.executeUpdate("DROP TABLE " + tableName + ";");
            System.out.println("Table " + tableName + " has been dropped!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    Method for inserting data into tables

    public void insertIntoTable(String myTableName, String[] dates, String... values) {
        try {
            StringBuilder myDates = new StringBuilder();
            StringBuilder myValues = new StringBuilder();

            for (int i = 0; i < dates.length; i++) {
                if (i < dates.length - 1) {
                    myDates.append(dates[i]).append(", ");
                } else {
                    myDates.append(dates[i]);
                }
            }

            for (int i = 0; i < values.length; i++) {
                if (i < dates.length - 1) {
                    myValues.append(values[i]).append(", ");
                } else {
                    myValues.append(values[i]);
                }
            }

            stmt.executeUpdate("INSERT " + myTableName + "(" + myDates + ") VALUES (" + myValues + ");");

            System.out.println("INSERT INTO " + myTableName + "(" + myDates + ")" + " VALUES(" + myValues + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //    Method for updating tables
    public void updateTableExample(String tableName, int id, String columnName, String newValue) {
        try {
            String sql = "UPDATE " + tableName + " SET " + columnName + " = '" + newValue + "'" + " WHERE id = " + id;

            stmt.executeUpdate(sql);

            System.out.println(columnName.substring(0, 1).toUpperCase() + columnName.substring(1) +
                    " updated to: " + newValue + ", from " + tableName + " where id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    Method for deleting data from the given table, by its ID

    public void deleteFromTableExample(String tableName, int id) {
        try {
            stmt.executeUpdate("DELETE FROM " + tableName + " WHERE ID = " + id + ";");
            System.out.println("Data with id: " + id + " has been deleted from " + tableName + "!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    Method for selecting ids and names from the given table

    public void selectIdsAndNamesFromTable(String tableName) {

        try {

            ResultSet rs = stmt.executeQuery("SELECT id, name" + " FROM " + tableName + ";");
            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");

                System.out.println("id: " + id + " name: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    I created a public method to return an instance of the class, using singleton design pattern

    public static synchronized MyJDBCConnection connectToDatabase() {
        if (instance == null) {
            instance = new MyJDBCConnection();
        }

        return instance;
    }
}
