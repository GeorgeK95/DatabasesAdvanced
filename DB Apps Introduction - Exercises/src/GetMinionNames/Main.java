package GetMinionNames;

import java.sql.*;
import java.util.Scanner;

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
        Scanner in = new Scanner(System.in);
        int villainId = Integer.parseInt(in.nextLine());

        String fullQuery = "select m.name as minName, m.age as minAge, v.name as villName\n" +
                "from minions as m\n" +
                "join vilians_minions as vm\n" +
                "on vm.villain_id = ? and vm.minion_id = m.id\n" +
                "join villains as v\n" +
                "on v.id = vm.villain_id and v.id = ?\n" +
                "group by m.id;";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(fullQuery)) {
            preparedStatement.execute(useQuery);
            preparedStatement.setInt(1, villainId);
            preparedStatement.setInt(2, villainId);

            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            printVillain(rs);

            int c = 1;

            do {
                printMinion(rs, c);
                c++;
            } while (rs.next());

        }
    }

    private static void printMinion(ResultSet rs, int c) throws SQLException {
        System.out.printf("%d. %s %d", c, rs.getString("minName"), rs.getInt("minAge"));
        System.out.println();
    }

    private static void printVillain(ResultSet rs) throws SQLException {
        System.out.printf("Villain: %s", rs.getString("villName"));
        System.out.println();
    }
}
