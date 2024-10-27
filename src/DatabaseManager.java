package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    public static String status = "Não conectou...";

    public DatabaseManager() {

    }
    public static java.sql.Connection getDatabaseManager() {
        Connection connection = null;
        String driverName = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String serverName = "localhost"; // Endereço do servidor do BD
        String mydatabase = "garagemdb";   	// Nome do seu banco de dados
        String url = "jdbc:mysql://" + serverName + "/" + mydatabase; // String de Conexão.
        String username = "root"; // Nome de um usuário de seu BD
        String password = "";   	// A senha de acesso do usuário quando tiver em uso.

        try {
            connection = DriverManager.getConnection(url, username, password);
            status = " Conectado";
            System.out.println("Banco " + mydatabase + status);
        } catch (SQLException e) {
            System.out.println(status);
            e.printStackTrace();
        }

        return connection;
    }


}


