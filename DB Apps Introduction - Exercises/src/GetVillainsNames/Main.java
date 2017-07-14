package GetVillainsNames;

import java.sql.*;

/**
 * Created by George-Lenovo on 7/13/2017.
 */
public class Main {
    private static final String DBNAME = "MinionsDB";
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) throws SQLException {
        String useQuery = "USE " + DBNAME + "; ";

        String query = "select v.id,v.name as nam, count(vm.minion_id) as c \n" +
                "from vilians_minions as vm\n" +
                "join villains as v\n" +
                "on v.id = vm.villain_id\n" +
                "group by v.id\n" +
                "having count(vm.minion_id) > 3\n" +
                "order by count(vm.minion_id) desc\n";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); Statement statement = connection.createStatement()) {
            statement.executeUpdate(useQuery);
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                System.out.printf("%s %d", rs.getString("nam"), rs.getInt("c"));
                System.out.println();
            }

        }
    }
}
