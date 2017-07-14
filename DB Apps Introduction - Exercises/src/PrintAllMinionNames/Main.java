package PrintAllMinionNames;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by George-Lenovo on 7/14/2017.
 */
public class Main {
    private static final String DBNAME = "MinionsDB";
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) throws SQLException {
        String useQuery = "USE " + DBNAME + "; ";
        String getAllNamesQuery = "select m.name as name\n" +
                "from minions as m";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); Statement statement = connection.createStatement()) {
            statement.execute(useQuery);
            ResultSet rs = statement.executeQuery(getAllNamesQuery);
            List<String> names = getNames(rs, "name");

            int n = names.size();
            for (int i = 0; i < n / 2; i++) {
                String a = names.get(i);
                String b = names.get(n - 1 - i);
                System.out.println(a);
                System.out.println(b);
            }

            if (n % 2 != 0) {
                System.out.println(names.get(n / 2));
            }

        }
    }

    private static List<String> getNames(ResultSet rs, String param) throws SQLException {
        List<String> list = new ArrayList<>();
        rs.beforeFirst();

        while (rs.next()) {
            String current = rs.getString(param);
            list.add(current);
        }

        return list;
    }
}
