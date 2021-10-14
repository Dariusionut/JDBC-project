import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

//        JDBC (Java Database Connection)
        MyJDBCConnection jdbcCon = MyJDBCConnection.connectToDatabase();

//        Creating a basic MySQL table
        jdbcCon.createTable("MyCustomTable", "name VARCHAR(255) NOT NULL", "address VARCHAR(255)", "age int");

        System.out.println();

        String[] dates = {"'NewDataTest'", "'NewDataTest2'", "25"};

//        Insert dates into existing table
        jdbcCon.insertIntoTable("MyCustomTable", Arrays.asList("name", "address", "age"), dates);
        jdbcCon.insertIntoTable("MyCustomTable", Arrays.asList("name", "address", "age"), "'TestData'", "'TestData2'", "26");

        System.out.println();

//        Update Name from a specific data of the existing table
        jdbcCon.updateTable("MyCustomTable",1, "name", "UpdatedDataTest");

        System.out.println();

//        Select dates from the existing table
        jdbcCon.selectIdsAndNamesFromTable("MyCustomTable");

        System.out.println();

//        Delete dates from the existing table
        jdbcCon.deleteFromTable("MyCustomTable", 1);
        jdbcCon.deleteFromTable("MyCustomTable", 2);

        System.out.println();

//        Drop the existing table
        jdbcCon.dropTable("MyCustomTable");

        jdbcCon.createTable("aTable", "name VARCHAR(255) NOT NULL UNIQUE", "info VARCHAR(20)");

        jdbcCon.insertIntoTable("aTable", Arrays.asList("name", "info"), "'aName'", "'someInfo'");

        jdbcCon.selectIdsAndNamesFromTable("aTable");

        jdbcCon.deleteFromTable("aTable", 1);

        jdbcCon.dropTable("aTable");


    }
}
