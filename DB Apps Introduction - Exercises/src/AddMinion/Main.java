package AddMinion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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

        String minionLine = in.nextLine();
        String villainLine = in.nextLine();

        String[] splittedMinionLine = minionLine.split("\\s+");
        String[] splittedVillainLine = villainLine.split("\\s+");

        String minionName = splittedMinionLine[1];
        int minionAge = Integer.parseInt(splittedMinionLine[2]);
        String minionTown = splittedMinionLine[3];
        String villainName = splittedVillainLine[1];

        String allTownsQuery = "select t.name as townName \n" +
                "from towns as t";

        String allVillainsQuery = "select v.name as villainName \n" +
                "from villains as v";

        String allMinionsQuery = "select m.name as minName\n" +
                "from minions as m";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            connection.setAutoCommit(false);
            try (Statement statement = connection.createStatement()) {
                statement.execute(useQuery);

                ResultSet rsTowns = statement.executeQuery(allTownsQuery);
                List<String> townsList = getStringListFromResultSet(rsTowns, "townName");
                if (!townsList.contains(minionTown)) {
                    String addTownQuery = "insert into towns(name, country)\n" +
                            "values ('" + minionTown + "', 'someCountry')";

                    statement.execute(addTownQuery);
                    System.out.printf("Town %s was added to the database.", minionTown);
                    System.out.println();
                }

                ResultSet rsVillains = statement.executeQuery(allVillainsQuery);
                List<String> villainsList = getStringListFromResultSet(rsVillains, "villainName");
                if (!villainsList.contains(villainName)) {
                    String addVillainQuery = "insert into villains(name, evilness_factor)\n" +
                            "values ('" + villainName + "', 'evil')";
                    statement.execute(addVillainQuery);
                    System.out.printf("Villain %s was added to the database.", villainName);
                    System.out.println();
                }

                ResultSet rsMinions = statement.executeQuery(allMinionsQuery);
                List<String> minionsList = getStringListFromResultSet(rsMinions, "minName");
                if (!minionsList.contains(minionName)) {
                    String addMinionQuery = "insert into minions(name, age, town_id)\n" +
                            "values ('" + minionName + "', '" + minionAge + "', (select t.id from towns as t where t.name = '" + minionTown + "'))";
                    statement.execute(addMinionQuery);
//                    System.out.println("Minion added.");
                }


                String minId = "select m.id as mid from minions as m where m.name = '" + minionName + "'";
                ResultSet rs1 = statement.executeQuery(minId);
                rs1.next();
                int a1 = rs1.getInt("mid");

                String villId = "select v.id as vid from villains as v where v.name = '" + villainName + "'";
                ResultSet rs2 = statement.executeQuery(villId);
                rs2.next();
                int a2 = rs2.getInt("vid");

                //TODO: check if there is duplicate map
                String addToMapTable = "insert into vilians_minions(villain_id, minion_id)\n" +
                        "values ((" + villId + "), (" + minId + "))";

                statement.execute(addToMapTable);
                System.out.printf("Successfully added %s to be minion of %s.", minionName, villainName);
                System.out.println();

                connection.commit();
                System.out.println("Success");

            } catch (SQLException e) {
                connection.rollback();
                System.out.println("Fail");
            }
        }

    }

    private static List<String> getStringListFromResultSet(ResultSet rs, String param) throws SQLException {
        List<String> list = new ArrayList<>();

        while (rs.next()) {
            String current = rs.getString(param);
            list.add(current);
        }

        return list;
    }

}
