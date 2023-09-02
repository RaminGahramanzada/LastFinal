package az.iktlab.dao.impl;

import az.iktlab.dao.BookRepository;
import az.iktlab.dao.connection.JDBCConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookDaoImpl implements BookRepository {
    @Override
    public int addBook(Integer usrId,Integer flightId) {
        String query = "INSERT INTO book (person_id,flightid) " +
                "VALUES (?, ?)";
        try {
            PreparedStatement preparedStatement = JDBCConnection.getInstance().getConnection().prepareStatement(query);
            preparedStatement.setInt(1,usrId);
            preparedStatement.setInt(2, flightId);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
    @Override
    public boolean cancelBook(int flightId) {
        String cancelQuery = "DELETE FROM book WHERE flightid = ?";

        try (PreparedStatement preparedStatement = JDBCConnection.getInstance().getConnection().prepareStatement(cancelQuery)) {
            preparedStatement.setInt(1, flightId);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Map<String, Object>> getBookingsByUserFullName(String fullName) {
        List<Map<String, Object>> userBookings = new ArrayList<>();
        String query = "SELECT * FROM bookings WHERE user_full_name = ?";

        try (PreparedStatement preparedStatement = JDBCConnection.getInstance().getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, fullName);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // Retrieve columns from the result set
                int bookingId = resultSet.getInt("booking_id");
                int userId = resultSet.getInt("user_id");
                int flightId = resultSet.getInt("flight_id");


                Map<String, Object> bookingInfo = new HashMap<>();
                bookingInfo.put("booking_id", bookingId);
                bookingInfo.put("user_id", userId);
                bookingInfo.put("flight_id", flightId);

                userBookings.add(bookingInfo);
            }

            return userBookings;
        } catch (SQLException e) {
            throw new RuntimeException(e); // Handle the exception as needed
        }
    }
    }

