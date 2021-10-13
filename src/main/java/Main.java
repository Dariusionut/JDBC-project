public class Main {

    public static void main(String[] args) {

        MyJDBCConnection jdbcCon = MyJDBCConnection.connectToDatabase();

        jdbcCon.createTable("MyCustomTable", "name VARCHAR(255) NOT NULL", "address VARCHAR(255)", "age int");

        System.out.println();

        String[] values = {"name", "address", "age"};
        String[] dates = {"'NewDataTest'", "'NewDataTest2'", "25"};

        jdbcCon.insertIntoTable("MyCustomTable", values, dates);
        jdbcCon.insertIntoTable("MyCustomTable", values, "'TestData'", "'TestData2'", "26");

        System.out.println();

        jdbcCon.selectIdsAndNamesFromTable("MyCustomTable");

        System.out.println();

        jdbcCon.deleteFromTableExample("MyCustomTable", 1);
        jdbcCon.deleteFromTableExample("MyCustomTable", 2);

        System.out.println();

        jdbcCon.dropTableExample("MyCustomTable");


    }
}
