package IncreaseAgeStoredProcedure;

import java.sql.*;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 7/14/2017.
 */
public class Main {
    private static final String DBNAME = "MinionsDB";
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) throws SQLException {
        Scanner in = new Scanner(System.in);
        int inputId = Integer.parseInt(in.nextLine());

        String callProcedureQuery = "call usp_get_older(?)";
        String useQuery = "USE " + DBNAME + "; ";
        String selectQuery = "select m.name as name, m.age as age from minions as m where id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedstatement = connection.prepareStatement(callProcedureQuery);
             PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
            preparedstatement.execute(useQuery);
            preparedstatement.setInt(1, inputId);
            preparedstatement.execute();

            selectStatement.setInt(1, inputId);
            ResultSet rs = selectStatement.executeQuery();
            rs.next();
            System.out.printf("%s %d", rs.getString("name"), rs.getInt("age"));
        }
    }
}
