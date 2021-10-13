public class Main {

    public static void main(String[] args) {

//        JDBC (Java Database Connection)
        MyJDBCConnection jdbcCon = MyJDBCConnection.connectToDatabase();

//        Creating a basic MySQL table
        jdbcCon.createTable("MyCustomTable", "name VARCHAR(255) NOT NULL", "address VARCHAR(255)", "age int");

        System.out.println();

        String[] values = {"name", "address", "age"};
        String[] dates = {"'NewDataTest'", "'NewDataTest2'", "25"};

//        Insert dates into existing table
        jdbcCon.insertIntoTable("MyCustomTable", values, dates);
        jdbcCon.insertIntoTable("MyCustomTable", values, "'TestData'", "'TestData2'", "26");

        System.out.println();

//        Update Name from a specific data of the existing table
        jdbcCon.updateTableExample("MyCustomTable",1, "name", "UpdatedDataTest");

        System.out.println();

//        Select dates from the existing table
        jdbcCon.selectIdsAndNamesFromTable("MyCustomTable");

        System.out.println();

//        Delete dates from the existing table
        jdbcCon.deleteFromTableExample("MyCustomTable", 1);
        jdbcCon.deleteFromTableExample("MyCustomTable", 2);

        System.out.println();

//        Drop the existing table
        jdbcCon.dropTableExample("MyCustomTable");


    }
}
