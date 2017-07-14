package ChangeTownNamesCasing;

import com.sun.deploy.util.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
        String line = in.nextLine();
        String useQuery = "USE " + DBNAME + "; ";
        String getCountriesQuery = "select t.name as townName\n" +
                "from towns as t\n" +
                "where t.country = ?";
        String setCountriesUpperCaseQuery = "update towns\n" +
                "set name = UPPER(name)\n" +
                "where country like ?";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(getCountriesQuery);
             PreparedStatement preparedStatement2 = connection.prepareStatement(setCountriesUpperCaseQuery)) {
            preparedStatement.setString(1, line);
            preparedStatement.execute(useQuery);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                preparedStatement2.setString(1, line);
                preparedStatement2.execute();
                List<String> countries = getCountries(rs, "townName");
                System.out.printf("%d town names were affected.", countries.size());
                System.out.print("[");
                System.out.print(StringUtils.join(countries, ", "));
                System.out.println("]");
            } else {
                System.out.println("No town names were affected.");
            }


        }
    }

    private static List<String> getCountries(ResultSet rs, String param) throws SQLException {
        List<String> list = new ArrayList<>();
        rs.beforeFirst();

        while (rs.next()) {
            String current = rs.getString(param).toUpperCase();
            list.add(current);
        }

        return list;
    }
}
