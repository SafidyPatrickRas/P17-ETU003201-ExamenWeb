package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static Connection getConnection() throws ClassNotFoundException {
        Connection Connection;
        String url = "jdbc:mysql://172.80.237.54:3306/db_s2_ETU003201";
        String user = "ETU003201";
        String password = "LYn5ZByZ";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection = DriverManager.getConnection(url, user, password);
            if (Connection != null) {
                System.out.println("Connexion réussie à la base de données !");
                return Connection;
            }
        } catch (SQLException e) {
            System.out.println("Erreur: Connexion à la base de données échouée.");
            e.printStackTrace();
        }
        return null;
    }
}
