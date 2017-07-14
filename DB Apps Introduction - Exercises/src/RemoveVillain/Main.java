package RemoveVillain;

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
        String useQuery = "USE " + DBNAME + "; ";
        Scanner in = new Scanner(System.in);
        int villainId = Integer.parseInt(in.nextLine());

        String getCountOfMinions = "select count(vm.minion_id) as minCount\n" +
                "from vilians_minions as vm\n" +
                "where vm.villain_id = ?";
        String deleteFromMapTable = "delete from vilians_minions\n" +
                "where villain_id = ?";
        String selectVillainName = "select v.name as minName\n" +
                "from villains as v\n" +
                "where id = ?";
        String deleteVillain = "delete from villains\n" +
                "where id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            connection.setAutoCommit(false);
            try (PreparedStatement countStatement = connection.prepareStatement(getCountOfMinions);
                 PreparedStatement mapStatement = connection.prepareStatement(deleteFromMapTable);
                 PreparedStatement villainStatement = connection.prepareStatement(deleteVillain);
                 PreparedStatement villainNAmeStatement = connection.prepareStatement(selectVillainName);) {

                countStatement.execute(useQuery);

                countStatement.setInt(1, villainId);
                mapStatement.setInt(1, villainId);
                villainStatement.setInt(1, villainId);
                villainNAmeStatement.setInt(1, villainId);

                ResultSet count = countStatement.executeQuery();
                ResultSet name = villainNAmeStatement.executeQuery();
                mapStatement.execute();
                villainStatement.execute();

                count.next();
                name.next();

                System.out.printf("%s was deleted\n", name.getString("minName"));
                System.out.printf("%d minions released\n", count.getInt("minCount"));
                connection.commit();
                System.out.println("Success.");
            } catch (SQLException e) {
                connection.rollback();
                System.out.println("Fail.");
            }
        }
    }
}
