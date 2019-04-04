package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MyCreateDataBase {


    public static void main(String[] args) throws SQLException {


//        createDataBaseTables();

    }

    private static void createDataBaseTables () throws SQLException {
        String createDataBaseTables1 = "CREATE TABLE `messages` (" +
                "  `id` int(11) NOT NULL AUTO_INCREMENT," +
                "  `name` varchar(45) DEFAULT NULL," +
                "  `messages` varchar(500) DEFAULT NULL," +
                "  PRIMARY KEY (`id`)" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8; ";
        String createDataBaseTables2 = "CREATE TABLE `user` (" +
                "  `id` int(11) NOT NULL AUTO_INCREMENT," +
                "  `name` varchar(17) DEFAULT NULL," +
                "  `password` varchar(17) NOT NULL," +
                "  PRIMARY KEY (`id`)" +
                ") ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;";

        Connection connection = DBCPDataSource.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(createDataBaseTables1);
        statement.executeUpdate(createDataBaseTables2);
        connection.close();


    }


}
