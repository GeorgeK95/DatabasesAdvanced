package IncreaseMinionsAge;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
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
        int[] ids = Arrays.stream(in.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String useQuery = "USE " + DBNAME + "; ";
        String modifyQuery = "update minions\n" +
                "set age = age + 1 \n" +
                "where id = ";
        String selectQuery = "select m.name as name,  m.age as age\n" +
                "from minions as m";
        String createFunctionQuery = getQuery();
        String callFunctionQuery = "UPDATE minions\n" +
                "SET name = UC_Words(name) \n" +
                "where id = ";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.execute(useQuery);
            statement.execute(createFunctionQuery);

            for (int i = 0; i < ids.length; i++) {
                int id = ids[i];

                String newNameQuery = callFunctionQuery + id;
                String newAgeQuery = modifyQuery + id;
                statement.execute(newNameQuery);
                statement.execute(newAgeQuery);
            }

            ResultSet rs = statement.executeQuery(selectQuery);
            while (rs.next()) {
                System.out.printf("%s %d\n", rs.getString("name"), rs.getInt("age"));
            }

        }

    }

    private static List<String> getNames(ResultSet rs, String param) throws SQLException {
        List<String> list = new ArrayList<>();
        rs.beforeFirst();

        while (rs.next()) {
            String current = rs.getString(param).toUpperCase();
            list.add(current);
        }

        return list;
    }

    public static String getQuery() {
        return
                "CREATE FUNCTION IF NOT EXISTS `UC_Words`( str VARCHAR(255) ) RETURNS VARCHAR(255)  \n" +
                        "BEGIN  \n" +
                        "  DECLARE c CHAR(1);  \n" +
                        "  DECLARE s VARCHAR(255);  \n" +
                        "  DECLARE i INT DEFAULT 1;  \n" +
                        "  DECLARE bool INT DEFAULT 1;  \n" +
                        "  DECLARE punct CHAR(17) DEFAULT ' ()[]{},.-_!@;:?/';  \n" +
                        "  SET s = LCASE( str );  \n" +
                        "  WHILE i < LENGTH( str ) DO  \n" +
                        "     BEGIN  \n" +
                        "       SET c = SUBSTRING( s, i, 1 );  \n" +
                        "       IF LOCATE( c, punct ) > 0 THEN  \n" +
                        "        SET bool = 1;  \n" +
                        "      ELSEIF bool=1 THEN  \n" +
                        "        BEGIN  \n" +
                        "          IF c >= 'a' AND c <= 'z' THEN  \n" +
                        "             BEGIN  \n" +
                        "               SET s = CONCAT(LEFT(s,i-1),UCASE(c),SUBSTRING(s,i+1));  \n" +
                        "               SET bool = 0;  \n" +
                        "             END;  \n" +
                        "           ELSEIF c >= '0' AND c <= '9' THEN  \n" +
                        "            SET bool = 0;  \n" +
                        "          END IF;  \n" +
                        "        END;  \n" +
                        "      END IF;  \n" +
                        "      SET i = i+1;  \n" +
                        "    END;  \n" +
                        "  END WHILE;  \n" +
                        "  RETURN s;  \n" +
                        "END ;";
    }
}
