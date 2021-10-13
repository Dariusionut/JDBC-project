import java.sql.*;

public class MyJDBCConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/JDBC?createDatabaseIfNotExist=true";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static MyJDBCConnection instance;

    private static Connection connection = null;
    private static Statement stmt = null;


    private static String insert = "INSERT example(name) VALUES(?)";

//    I made the constructor private to use singleton design pattern

    private MyJDBCConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = connection.createStatement();
            System.out.println("Connection succeeds to port: " + URL + "\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName, String... values) {
        try {

            String myData = "";
            for (int i = 0; i < values.length; i++) {
                myData += values[i] + ", ";
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

    public void dropTableExample(String tableName) {
        try {
            stmt.executeUpdate("DROP TABLE " + tableName + ";");
            System.out.println("Table " + tableName + " has been dropped!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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

            System.out.println("INSERT INTO " + myTableName + "(" + myDates + ")" + " VALUES('" + myValues + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public <T> void updateTableExample(int id, String columnName, T newValue) {
        try {
            String sql = "UPDATE example SET " + columnName + " = '" + newValue + "'" + " WHERE id = " + id;

            stmt.executeUpdate(sql);

            System.out.println(columnName + " updated to: " + newValue);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFromTableExample(String tableName, int id) {
        try {
            stmt.executeUpdate("DELETE FROM " + tableName + " WHERE ID = " + id + ";");
            System.out.println("Data with id: " + id + " has been deleted from " + tableName + "!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
