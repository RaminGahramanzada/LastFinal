package az.iktlab.bookingapp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnPostgres {
    private static ConnPostgres instance;
    private Connection connection;

    public ConnPostgres(String dbName) {
        try{
            String url = String.format("jdbc:postgresql://localhost:5432/BookFlight",dbName);
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection(
                            url,
                            "postgres",
                            "123455"
                    );
        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Error Connection: " + e);
        }
    }
    public static ConnPostgres getInstance(String db) {
        try {
            if(instance == null || instance.getConnection().isClosed() ) {
                instance = new ConnPostgres(db);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instance;
    }
    public Connection getConnection() {
        return connection;
    }
}