package InitialSetup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by George-Lenovo on 7/13/2017.
 */
public class Main {
    private static final String DBNAME = "MinionsDB";
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) throws SQLException {
        String createDBQuery = "CREATE DATABASE IF NOT EXISTS " + DBNAME + "; ";

        String useQuery = "USE " + DBNAME + "; ";

        String createTownsQuery = "CREATE TABLE towns (\n" +
                "id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "name VARCHAR(50),\n" +
                "country VARCHAR(50)\n" +
                ");";

        String createMinionsQuery = "CREATE TABLE minions (\n" +
                "id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "name VARCHAR(50),\n" +
                "age INT,\n" +
                "town_id INT, \n" +
                "CONSTRAINT fk_minions_towns FOREIGN KEY(town_id) REFERENCES towns(id)\n" +
                ");";

        String createVillainsQuery = "create table villains (\n" +
                "id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "name VARCHAR(50),\n" +
                "evilness_factor VARCHAR(50)\n" +
                ");";

        String createMapTable = "create table vilians_minions (\n" +
                "villain_id INT,\n" +
                "minion_id INT,\n" +
                "constraint pk_villain_id_minion_id primary key(villain_id,minion_id),\n" +
                "constraint pk_villians_minions_villains foreign key(villain_id) REFERENCES villains(id),\n" +
                "constraint pk_villians_minions_minions foreign key(minion_id) REFERENCES minions(id)\n" +
                ");";

        String insertTowns = "insert into towns(name,country)\n" +
                "values ('Sofia','Bulgaria'),('London','UK'),('Plovdiv','Bulgaria'),('Dubai','UAE'),('New York','USA');\n";
        String insertMinions = "insert into minions(name,age,town_id)\n" +
                "values ('Ivan', 20, 1),('Ronaldo', 32, 5),('Dragan', 10, 2),('Didier', 37, 3),('Pesho', 21, 1);";
        String insertVillains = "insert into villains(name,evilness_factor)\n" +
                "values ('Steven', 'bad'),('Dirk', 'good'),('Philipe', 'evil'),('Aaron', 'super evil'),('Reina', 'bad');";
        String insertMapTable = "insert into vilians_minions(villain_id,minion_id)\n" +
                "values (1,2),(1,3),(1,1),(2,2),(4,2);";


        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); Statement statement = connection.createStatement()) {
            statement.executeUpdate(createDBQuery);
            statement.executeUpdate(useQuery);
            statement.executeUpdate(createTownsQuery);
            statement.executeUpdate(createMinionsQuery);
            statement.executeUpdate(createVillainsQuery);
            statement.executeUpdate(createMapTable);

            statement.executeUpdate(insertTowns);
            statement.executeUpdate(insertMinions);
            statement.executeUpdate(insertVillains);
            statement.executeUpdate(insertMapTable);

        }
    }
}
