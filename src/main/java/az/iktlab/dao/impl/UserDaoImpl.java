package az.iktlab.dao.impl;

import az.iktlab.dao.UserRepository;
import az.iktlab.dao.connection.JDBCConnection;
import az.iktlab.model.Flight;
import az.iktlab.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoImpl implements UserRepository {

    @Override
    public int insertUser(User user) {
        String query = "INSERT INTO person (name,surname) " +
        "VALUES (?, ?)";
        try {
            PreparedStatement preparedStatement = JDBCConnection.getInstance().getConnection().prepareStatement(query);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public User getByNameAndSurname(String name,String surname) {
        User user = null;
        String query = "select *from person where name='" + name+"'and surname='"+surname+"';";
        try {
            Statement stmt = JDBCConnection.getInstance().getConnection().createStatement();

            stmt.execute(query);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()){
                int id =  rs.getInt("id");
                String nm = rs.getString("name");
                String srnm = rs.getString("surname");
                user = new User(id,nm,srnm);
            }

            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
